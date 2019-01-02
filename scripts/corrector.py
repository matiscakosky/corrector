# -*- coding: utf-8 -*-
"""
    Script principal de procesamiento de la entrega
    
"""

from fetch import NoHayMensajesNuevos
from fetch import revisar
from fetch import responder
from fetch import takeAttachment
from fetch import obtener_fecha_mensaje
from excepciones import ErrorEntrega
from excepciones import TrabajoVencido
from pyCorrector import PyCorrector
from vencimientos import LimiteDeEntrega
from javaCorrector import JavaCorrector4
import os
import re
import io
import zipfile
import pathlib
from time import sleep


TP_DIR = pathlib.Path(os.environ["SKEL_DIR"])


MAX_ZIP_SIZE = 1024 ** 2

#Mensajes de error
MAL_ASUNTO = "No se encontro ninguna entrega en el asunto del mail, por favor reenviar con el formato correspondiente y el nombre de entrega correcto"
MAL_TAMANIO = "Archivo supera el Limite permitido de tamaño de {} bytes".format(MAX_ZIP_SIZE)
ARCHIVO_INEXISTENTE = "No se encontro ningun archivo comprimido de formato esperado adjunto en el mail enviado, por favor adjunte su entrega" 
ZIP_DANIADO = "El archivo comprimido se encuentra dañado, no es tenido en cuenta. Por favor reenviar un archivo que funcione"
MENSAJE_ADVERTENCIA= "ADVERTENCIA: El trabjo práctico recientemente enviado no fue entregado dentro del plazo correspondiente, el trabajo se corregirá de todas maneras. La nota del mismo esta sujeta a este retraso del TP"

#Opciones del corrector
JAVA_TPS=["FRACCION","VECTOR","FIUGRA","POLIGONO","VEHICULO","COCINA"]
PY_TPS=["TPPY1","TPPY2","TPPY3","TPPY4","LISTA"]
CONSULTAS=["NOTAS"]


def escuchar():
    while(True):
        main()
        sleep(3)
        

def main():
    """ Funcion principal """
    try:
        msg = revisar()
        id_tp = buscar_tp(msg["Subject"])
        #alumno_id = buscar_alumno(msg["Subject"])
        
    
        if id_tp in CONSULTAS:
            print("hacer")
            #Subproceso de consultas
    
        zip_adjunto = convertir_a_zip(takeAttachment(msg))
        skel_dir = TP_DIR / id_tp
        corrector=cargar_correctores(id_tp,str(skel_dir),zip_adjunto)
        print("llego una entrega bien")
        
        limitador = checkear_vencimiento_tp(skel_dir,obtener_fecha_mensaje(msg["Date"]))
        if limitador.advertencia: responder(msg,MENSAJE_ADVERTENCIA) #fijarse de empalmarlo con el otro mail
        
        output=corrector.corregir()
        responder(msg, "Todo OK: {}".format(output))
        
        


   
    except NoHayMensajesNuevos:
        print("No hay mensajes nuevos")
        
    except TrabajoVencido as err:
        responder(msg, "TRABAJO VENCIDO: {}".format(err))
    except ErrorEntrega as err:
        responder(msg, "ERROR: {}".format(err))
    except RuntimeError as err:
        responder(msg, "ERROR: Comunicarse con el docente para solucionarlo {}".format(err))

def buscar_tp(subject):
    subj_words = [w.lower() for w in re.split(r"[^_\w]+", subject)]
    candidates = {p.name.lower(): p.name for p in TP_DIR.iterdir()}
    
    for key in candidates:
        if key in subj_words:
            return candidates[key]
    
    raise ErrorEntrega(MAL_ASUNTO)

def convertir_a_zip(zip_bytes):
    """Recibe un conjunto de bytes que se pueden interpretar como un archivo zip y devuelve un objeto zip"""
    if (not zip_bytes): raise ErrorEntrega(ARCHIVO_INEXISTENTE)
    if len(zip_bytes) > MAX_ZIP_SIZE:
        raise ErrorEntrega(MAL_TAMANIO)
    try:
        return zipfile.ZipFile(io.BytesIO(zip_bytes))
    except zipfile.BadZipFile:
        raise ErrorEntrega(ZIP_DANIADO)

def checkear_vencimiento_tp(skel_dir, fechaEntrega):
    limitador = LimiteDeEntrega(skel_dir,fechaEntrega)
    limitador.checkear()
    return limitador
    
           
def cargar_correctores(id_tp=None,skel_dir=None,zip_adjunto=None):
    if id_tp in PY_TPS:
        return PyCorrector(id_tp=id_tp,skel_dir=skel_dir,zip_tp=zip_adjunto)
    elif id_tp in JAVA_TPS:
        return JavaCorrector4(id_tp=id_tp,skel_dir=skel_dir,zip_tp=zip_adjunto)
    
    
                
def buscar_alumno(subject):
    subj_words = [w.lower() for w in re.split(r"[^_\w]+", subject)]

def registrar_entrega(tp_id,alumno_id,aprobo):
    #Ejecutar subproceso que registre esto.
    subj_words = [w.lower() for w in re.split(r"[^_\w]+", subject)]
    return
        
        
if __name__ == "__main__":
  main()
