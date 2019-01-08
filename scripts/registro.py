# -*- coding: utf-8 -*-
"""
Script principal que maneja los registro de los alumnos

"""
import gspread
from oauth2client.service_account import ServiceAccountCredentials
from excepciones import AlumnoInexistente
from datetime import datetime

ARCHIVO_CONSULTA="consulta_notas.txt"
LIMITE_REGSITRO= (datetime.strptime("31/03/2019", '%d/%m/%Y')).replace(hour=23, minute=59, second=59)
SCOPES=['https://spreadsheets.google.com/feeds', 'https://www.googleapis.com/auth/drive']


#Notaciones del SpreadSheet
NOMBRE="APELLIDO Y NOMBRE"
DNI="DNI"
CURSO="6TO"
FECHA="FECHA REGISTRO"
EMAIL="EMAIL"



def autenticar():
    """Genera el token de acceso a SpreadSheets """
    credentials = ServiceAccountCredentials.from_json_keyfile_name("My Project-150473bd33ba.json",SCOPES)
    gc=gspread.authorize(credentials)
    wks=gc.open('Alumnos').sheet1
    return wks

def registrar_alumno(wks,nombre,dni,sexto,fecha,email):
    """Agrega al spreadsheet un registro con un nuevo alumno. El ordenado hay que hacerlo a mano.
        Solo se reciben registros dentro de la fecha indicada por la constante LIMITE_REGISRO
    """
    if fecha < LIMITE_REGSITRO:
        wks.append_row([nombre.upper(),str(dni),str(sexto).upper(),(str(fecha).split())[0],email]) 


def registrar_entrega(wks,id_tp,id_alumno,aprobo):
    """ Dados el token de acceso, un tp, un alumno y si aprobo o no. Registra la entrega en la planilla. Agregando el tp si no existia y fue el primer alumno en entregarlo
    """
    
    nota= "OK" if aprobo else "ERROR"
    #Corroboro si esta registrado el tp en el header:
    header= wks.row_values(1)
    if id_tp not in header:
        wks.update_cell(1,len(header)+1,id_tp)
    
    #Busco la fila del alumno que entrego el trabajo
    celdaAlumno = wks.find(id_alumno)
    celdaTP = wks.find(id_tp)
    wks.update_cell(celdaAlumno.row,celdaTP.col,nota)
        

def buscar_id(wks,subj_words):
    """Dado el token de SpreadSheets y un asunto de un mail, busca si hay un DNI en la planilla que coincida con el del asunto"""
    registros=wks.get_all_records()
    for dic in registros:
        if str(dic[DNI]) and str(dic[DNI]) in subj_words:
            print("Se encontró al alumno en la planilla", str(dic[DNI]))
            return str(dic[DNI])
    raise AlumnoInexistente("No se encontro ningun alumno registrado")
    
    
    
def buscar_nombre(wks, id_alumno):
    """Dado un token de spreadsheet y un id_alumno busca el nombre ubicado en la primera columna"""
    celdaAlumno = wks.find(id_alumno)
    celdaNombre = wks.cell(celdaAlumno.row,1) #Esta en la fila del alumno y columna 1
    return celdaNombre.value
    return


def consulta_de_notas(wks,id_alumno):
    """Recibe el token y un id_alumno. Busca en la planilla la fila correspondiente al id que llego por parametro y toma un mensaje predefinido como un txt fuera del programa y lo formatea con los datos
    del alumno. Luego agrega las notas de toda la fila
    FALTA ESCONDER LAS QUE SON PRIVADAS Y NO DEBERIAN VER. EJEMPLO: CONCEPTO Y SE COPIO"""
    
    registros = wks.get_all_records()
    dicAlumno= {}
    for dic in registros:
        if str(dic[DNI])==id_alumno:
            dicAlumno=dic
            break
    rta=""
    with open(ARCHIVO_CONSULTA,'r',encoding = "ISO-8859-1") as archivo:
        l=list(archivo.readlines())
        rta= "".join(l)
        rta=rta.format(dicAlumno[NOMBRE],dicAlumno[DNI],dicAlumno[EMAIL],dicAlumno[FECHA],dicAlumno[CURSO])
    
    #Uso el header para darlos en orden
    header= wks.row_values(1)[5:]   #lAS PRIMERAS 5 POSICIONES NO ME INTERESAN SON PARTE DE LOS DATOS
    
    for elem in header:
        rta += '\n'
        rta += "{}: {}".format(elem,dicAlumno[elem])
    
    return rta

    
    