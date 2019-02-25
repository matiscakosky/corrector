#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
    Script principal de procesamiento de la entrega
    
    Flujo principal del corrector:
        - Revisa que haya una entrega en la casilla de mensajes de tddentregas@gmail.com
        - Autentica en Google Drive y Google Spreadsheets y genera un objeto token para poder acceder y modificar las planillas
        - Revisa en el asunto si hay un trabajo practico reconocido o una consulta
        - Revisa en el asunto si hay un alumno registrado en la planilla
        - Si hay un TP genera un objeto corrector de Java o Python según reconozca en el asunto del mail
        - Revisa las credenciales del TP, si las mismas son validas continua con la correccion, sino la limita a una advertencia o la cancelacion del mismo.
        - El objeto corrector realiza su correcion
        - Se actualiza la planilla 
        - Se genera un objeto Moss que una vez aprobado el TP guarda el contenido del archivo comprimido en un path y sube todos los scripts a un repositorio en Github.
"""

import os
from fetch import NoHayMensajesNuevos
from fetch import revisar
from fetch import responder
from fetch import takeAttachment
from fetch import obtener_fecha_mensaje
from excepciones import ErrorEntrega
from excepciones import TrabajoVencido
from excepciones import AlumnoInexistente
from pyCorrector import PyCorrector
from vencimientos import LimiteDeEntrega
from javaCorrector import JavaCorrector4
from registro import registrar_alumno
from registro import registrar_entrega
from registro import autenticar
from registro import buscar_id
from registro import consulta_de_notas
from registro import buscar_nombre
from Moss import Moss
import re
import io
import zipfile
import pathlib
from time import sleep


SKEL_DIR = pathlib.Path(os.environ["SKEL_DIR"])

MAX_ZIP_SIZE = 1024 ** 2

#Mensajes de error
MAL_ASUNTO = "No se encontro ninguna entrega en el asunto del mail, por favor reenviar con el formato correspondiente y el nombre de entrega correcto"
MAL_TAMANIO = "Archivo supera el Limite permitido de tamaño de {} bytes".format(MAX_ZIP_SIZE)
ARCHIVO_INEXISTENTE = "No se encontro ningun archivo comprimido de formato esperado adjunto en el mail enviado, por favor adjunte su entrega" 
ZIP_DANIADO = "El archivo comprimido se encuentra dañado, no es tenido en cuenta. Por favor reenviar un archivo que funcione. Se recomienda comprimir con el comrpesor online https://archivo.online-convert.com/es/convertir-a-zip"
MENSAJE_ADVERTENCIA= "ADVERTENCIA: El trabjo práctico recientemente enviado no fue entregado dentro del plazo correspondiente, el trabajo se corregirá de todas maneras. La nota del mismo esta sujeta a este retraso del TP"
MAL_REGISTRO="Un problema surgio con su registro/entrega. Revisar si llenó correctamente los campos del registro/entrega en el asunto del mail y vuelvalo a intentar. Su registro/entrega no fue tenida en cuenta"
BIENVENIDA="Registro completado con éxito - Bienvenido a Taller de desarrollo de sistemas - TIC ORT Argentina"
ALUMNO_INEXSISTENTE="ERROR: No se logro identificar al alumno revise si escribio bien su DNI"

#Opciones del corrector
JAVA_TPS=["FRACCION","VECTOR","MAZO","FIUGRA","POLIGONO","VEHICULO","COCINA"]
PY_TPS=["TPPY1","TPPY2","TPPY3","TPPY4","LISTA"]
CONSULTAS=["NOTAS","REGISTRAR"]


def escuchar():
    while(True):
        main()
        sleep(3)
        

def main():
    """ Funcion principal"""
    id_tp=None
    id_alumno=None
    try:
        msg = revisar() #Conecto Con la API de Gmail
        wks = autenticar() # Concecto con la API de Drive y Spreadsheet   
        id_tp = buscar_tp(msg["Subject"])
        
        if id_tp in CONSULTAS:
            manejar_consultas(wks,msg,id_tp)
            return
            
            
        id_alumno = buscar_alumno(wks,msg["Subject"])
        zip_adjunto = convertir_a_zip(takeAttachment(msg))
        skel_dir = SKEL_DIR / id_tp
        corrector=cargar_correctores(id_tp,str(skel_dir),zip_adjunto)
        print("llego una entrega bien")
        
        limitador = checkear_vencimiento_tp(skel_dir,obtener_fecha_mensaje(msg["Date"]))
        if limitador.advertencia: responder(msg,MENSAJE_ADVERTENCIA) #fijarse de empalmarlo con el otro mail
        
        output=corrector.corregir()
        
        responder(msg, "Todo OK: {}".format(output))
        registrar_entrega(wks,id_tp, id_alumno,True,limitador.advertencia)
        
        moss = Moss(id_tp, buscar_nombre(wks,id_alumno), obtener_fecha_mensaje(msg["Date"]), zip_adjunto)
        moss.guardar_directorio()
        moss.subir()
   
    except NoHayMensajesNuevos:
        print("No hay mensajes nuevos")
    
    except AlumnoInexistente:
        responder(msg, ALUMNO_INEXSISTENTE)
        
    except TrabajoVencido as err:
        responder(msg, "TRABAJO VENCIDO: {}".format(err))
        
    except zipfile.BadZipFile:
        responder(msg, "ERROR: {}".format(ZIP_DANIADO))
    
    except ErrorEntrega as err:
        if id_tp and id_alumno:
            registrar_entrega(wks,id_tp, id_alumno,False)
        responder(msg, "ERROR: {}".format(err))
        
    except RuntimeError as err:
        responder(msg, "ERROR: Comunicarse con el docente para solucionarlo {}".format(err))

def buscar_tp(subject):
    """ 
        Recibe el asunto del mail en forma de string. Itera por el directorio de SKEL_DIR y busca si alguna palabra 
        del asunto coincide con algun sub-directorio ubicado en SKEL_DIR. 
        Las consultas tambien son reconocidas en este nivel, para eso deben tener su propio path dentro de SKEL_DIR para ser reconocidas, luego se hara la separacion correspondiente.
        Si lo encuentra devuelve el nombre del sub-directorio tal cual esta escrito en el path
        Si no lo encuentra lanza una excepcion de ErrorEntrega
        
    """
    subj_words = [w.lower() for w in re.split(r"[^_\w]+", subject)]
    candidates = {p.name.lower(): p.name for p in SKEL_DIR.iterdir()}
    
    for key in candidates:
        if key in subj_words:
            return candidates[key]
    
    raise ErrorEntrega(MAL_ASUNTO)

def convertir_a_zip(zip_bytes):
    """Recibe un conjunto de bytes que se pueden interpretar como un archivo zip y devuelve un objeto zip"""
    if (not zip_bytes): raise ErrorEntrega(ARCHIVO_INEXISTENTE)
    if len(zip_bytes) > MAX_ZIP_SIZE:
        raise ErrorEntrega(MAL_TAMANIO)
    return zipfile.ZipFile(io.BytesIO(zip_bytes))


def checkear_vencimiento_tp(skel_dir, fechaEntrega):
    """Recibe la ubicacion del TP que se quiere verificar, y la fecha de entrega en formato date time
        Devuelve un objeto de la clase LimiteDeEntrega que sabe si el TP esta en condiciones de entregarse.
    """
    limitador = LimiteDeEntrega(skel_dir,fechaEntrega)
    limitador.confirmar_horario_entrega()
    return limitador
    
           
def cargar_correctores(id_tp=None,skel_dir=None,zip_adjunto=None):
    """Devuelve un objeto corrector de java o python segun se haya reconocido anteriormente.
        Todas las propiedades del corrector son creadas, recibiendo el id_tp la ubicacion del tp en skel_dir y
        el archivo zip adjuntado en el mail"""
    if id_tp in PY_TPS:
        return PyCorrector(id_tp=id_tp,skel_dir=skel_dir,zip_tp=zip_adjunto)
    elif id_tp in JAVA_TPS:
        return JavaCorrector4(id_tp=id_tp,skel_dir=skel_dir,zip_tp=zip_adjunto)
    

def manejar_consultas(wks,msg,id_tp):
    """Funcion encargada de manejar las consultas no relacionadas a corregir trabajos practicos.
    La misma recibe el objeto msg de GMAIL para poder generar una respuesta dentro de la funcion que no sea la de los trabajos practicos 
    y el toquen de SpreadSheets para poder leer/modificar la planilla. Tambien recibe el id_tp donde contiene en ella que consulta se hara."""
    if id_tp == "REGISTRAR":
        #El subject del mail de registro de la forma "REGISTRO - Apellido Nombre - A - DNI"
        try:
            subj_words = [w.lower() for w in re.split(r"[^_\w]+", msg["Subject"])]
            nombre = subj_words[1] + " " + subj_words[2]
            sexto=subj_words[3]
            dni = subj_words[4]
            registrar_alumno(wks,nombre=nombre,sexto=sexto,dni=dni,fecha=obtener_fecha_mensaje(msg["Date"]),email=msg["From"])
            responder(msg,BIENVENIDA)
        except IndexError:
            raise ErrorEntrega(MAL_REGISTRO)
    elif id_tp == "NOTAS":
        #El subject del mail de registro sera de la forma NOTAS - DNI
        id_alumno = buscar_alumno(wks,msg["Subject"])
        respuesta = consulta_de_notas(wks,id_alumno)
        responder(msg, respuesta)
        

def buscar_alumno(wks,subject):
    """Recibe el token de spreadsheet y el asunto del mail en forma de string y reconoce si hay algun dni que coincida con los de la planilla, en cuyo caso lo devuelve
    sino lanza expecion de AlumnoInexsistente"""
    subj_words = [w.lower() for w in re.split(r"[^_\w]+", subject)]
    id_alumno=buscar_id(wks,subj_words)
    return id_alumno 
        
if __name__ == "__main__":
  main()
