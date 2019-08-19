""" 
		Script que maneja la cuenta de gmail haciendo el fetch de mensajes
		
"""
import base64
import email
import email.message
import email.policy
import email.utils
from email.mime.text import MIMEText
import os
from apiclient import errors
from googleapiclient.discovery import build
from httplib2 import Http
from oauth2client import file, client, tools
import dateutil.parser as parser
import time
import datetime

#Usuario gmai = tddentregas@gmail.com
#Contraseña = tddautomatico

#Define constants
user_id =  'me'
label_id_one = 'INBOX' #Etiqueta de bandeja a fetchear
label_id_two = 'UNREAD' #Etiqueta de estado de mail a fetchear
label_id_three = 'SPAM' #Etiqueta de bandeja a fetchear
SCOPES=["https://www.googleapis.com/auth/gmail.modify","https://www.googleapis.com/auth/gmail.compose","https://www.googleapis.com/auth/gmail.send"]

class NoHayMensajesNuevos(Exception):
  """Excepción para manejar el caso de que no hay mails nuevos para revisar.
  """


def revisar():
    """Funcion princpal del corrector. Hace el fetch de un email para luego procesarlo """

    service = autenticar()
    dicMensaje=revisar_nuevos_no_leidos(service)
    message = GetMimeMessage(service,user_id,dicMensaje['id']) #Convierto a objeto mensaje
    cambiarALeido(service,dicMensaje['id'])
    return message


def responder(msg, text):
    """ Funcion que envia un mensaje al autor de msg de parte del destinatario"""
    service = autenticar()
    message = MIMEText(text )
    message['to'] = msg['From']
    message['from'] = msg['To']
    message['subject'] = "Re: " + msg['Subject']
    
    raw = base64.urlsafe_b64encode(message.as_bytes())
    raw = raw.decode()
    msj = {'raw': raw}
      
    try:
        enviado = (service.users().messages().send(userId=user_id, body=msj).execute())
        print ('Message Id: %s' % enviado['id'])
    except errors.HttpError as error:
        print ('An error occurred: %s' % error)
        
def autenticar():
    """
    Esta funcion toma de la variable SCOPES los permisos que quiera darle a la APPI para que acceda a mi GMAIL
    No recibe parametros y devuelve un objeto autentificador con el token para poder hacer el fetch de mensajes
    
    Pre-Condiciones: existe en el directorio de este script un archivo con credentials.json que tiene las credenciales
    de la API de Google-Gmail para generar el token.
    
    Post-Condiciones: genera en el mismo directorio del script un archvo token.json (con persistencia) para poder acceder
    a la cuenta de gmail, si quiero cambiar los perimos debo borrar ese archivo y ejecutar la autenticacion de nuevo.
    
    Aca puedo cambiar la cuenta que escucha la bandeja de entrada. 
    """
    
    #SCOPES = 'https://www.googleapis.com/auth/gmail.modify'
    store = file.Storage('token.json')
    creds = store.get()
    if not creds or creds.invalid:
        flow = client.flow_from_clientsecrets('credentials.json', SCOPES)
        creds = tools.run_flow(flow, store)
    GMAIL = build('gmail', 'v1', http=creds.authorize(Http()))
    
    return GMAIL

def cambiarALeido(service,id):
    """Cambia la etiqueta del mensaje por una de leido"""
    service.users().messages().modify(userId=user_id, id=id,body={ 'removeLabelIds': ['UNREAD']}).execute()

def revisar_nuevos_no_leidos(service):
    """
    Recibe el token GMAIL para tomar los mensajes del inbox que tengan las condiciones de label_id_one y label_id_two y devuelve un
    con todos los mensajes que luego debe ser parseado
    Pre-condiciones: El token GMAIL esta creado y autenticado
    Post-condiciones: Devuelve un mensaje (en forma de diccionario)
    """
    unread_msgs = service.users().messages().list(userId='me',labelIds=[label_id_one, label_id_two, label_id_three], maxResults=1,includeSpamTrash=True).execute()
    mssg_list = unread_msgs.get('messages',[])
    if (not len(mssg_list)): raise NoHayMensajesNuevos("No hay mensajes nuevos en este momento")
    return mssg_list[0]
    #Si quiero que devuelva todos los no leidos quito el parametro maxResults=1 de .list() y hago return mssg_list (Ojo como lo manejas mas arriba)

def obtener_fecha_mensaje(date_str):
    """Recibe un string con la fecha en el formato dada por el objeto message. Devuelve un date time con la fecha del mensaje"""
    REMOTE_TIME_ZONE_OFFSET = -3 * 60 * 60
    tupla = email.utils.parsedate(date_str)
    tiempo = time.mktime(tupla)
    return datetime.datetime.fromtimestamp(tiempo + REMOTE_TIME_ZONE_OFFSET)

def obtener_datos_de_mensaje(message):
    """
    Recibe el mensaje y devuelve algunos features del mensaje recibido
    Pre-condiciones: el mensaje no esta vacio
    Post-condiciones: Devuelve una lista con el asunto, remitente, fecha del mensaje recibido
    """
    final_list = []
    final_list.append(message['Subject'])
    final_list.append(message['From'])
    final_list.append(message['Date'])
    
    return final_list

def takeAttachment(msg):
    """Toma el archivo comprimido si no hay devuelve una cadena vacia"""
    
    for part in msg.walk():
        if part.get_content_maintype() == "multipart":
            continue
        
        filename = part.get_filename() or ""
        if filename.lower().endswith(".zip"):
            zip_bytes = part.get_payload(decode=True)
            return zip_bytes
    return ""

    
def informar_posible_copia(msg,text):
    """ Funcion que envia un mensaje al autor de msg de parte del destinatario"""
    service = autenticar()
    message = MIMEText(text)
    message['to'] = "mscakosky@ort.edu.ar"
    message['from'] = msg['To']
    message['subject'] = "Posible copia detectada en el corrector"
    
    raw = base64.urlsafe_b64encode(message.as_bytes())
    raw = raw.decode()
    msj = {'raw': raw}
      
    try:
        enviado = (service.users().messages().send(userId=user_id, body=msj).execute())
        print ('Message Id: %s' % enviado['id'])
    except errors.HttpError as error:
        print ('An error occurred: %s' % error)




def GetMimeMessage(service, user_id, msg_id):
  """Get a Message and use it to create a MIME Message.

  Args:
    service: Authorized Gmail API service instance.
    user_id: User's email address. The special value "me"
    can be used to indicate the authenticated user.
    msg_id: The ID of the Message required.

  Returns:
    A MIME Message, consisting of data from Message.
  """
  try:
    message = service.users().messages().get(userId=user_id, id=msg_id,
                                             format='raw').execute()
    
    msg_str = base64.urlsafe_b64decode(message['raw'].encode('ASCII'))

    mime_msg = email.message_from_bytes(msg_str)

    return mime_msg
  except errors.HttpError:
    print ('An error occurred: %s' % erro)
