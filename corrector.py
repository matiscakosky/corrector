# -*- coding: utf-8 -*-
"""
    Script principal de procesamiento de la entrega
    
"""

from fetch import NoHayMensajesNuevos
from fetch import revisar
from fetch import responder
from fetch import takeAttachment
from excepciones import ErrorEntrega
from pyCorrector import pyCorrector
import sys
import os
import re
import os
import io
import zipfile
import pathlib
from time import sleep
import subprocess


TP_DIR = pathlib.Path("C:\\Users\\Usuario\\Desktop\\ORT\\SKEL_TP")
JUNIT = r'C:\Users\Usuario\Desktop\ORT\Corrector\java\junit.jar'
HAMCREST= r'C:\Users\Usuario\Desktop\ORT\Corrector\java\hamcrest.jar'

MAX_ZIP_SIZE = 1024 ** 2

#Mensajes de error
MAL_ASUNTO = "No se encontro ninguna entrega en el asunto del mail, por favor reenviar con el formato correspondiente y el nombre de entrega correcto"
MAL_TAMANIO = "Archivo supera el Limite permitido de tamaño de {} bytes".format(MAX_ZIP_SIZE)
ARCHIVO_INEXISTENTE = "No se encontro ningun archivo comprimido de formato esperado adjunto en el mail enviado, por favor adjunte su entrega" 
ZIP_DANIADO = "El archivo comprimido se encuentra dañado, no es tenido en cuenta. Por favor reenviar un archivo que funcione"


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
        tp_id = buscar_tp(msg["Subject"])
        #alumno_id = buscar_alumno(msg["Subject"])
        
      
        
        if tp_id in CONSULTAS:
            print("hacer")
            #Subproceso de consultas
    
        zip_adjunto = convertir_a_zip(takeAttachment(msg))
        skel_dir = TP_DIR / tp_id
        print("llego una entrega bien")
        
        
        
        if tp_id in PY_TPS:
            
            corrector = pyCorrector(id_tp=tp_id,skel_dir=skel_dir,zip_tp=zip_adjunto)
            output=corrector.corregir()
            """
               p=subprocess.run(["python","pruebas.py"],cwd=skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
                
                borrar_archivo_de_directorio(tp_id,skel_dir)
                
                output=p.stdout.decode("utf-8")
                
                #registrar_entrega(id_tp,alumno_id,p.returncode)
                
                #Si hay error lanzo el errorEntrega
                if p.returncode != 0:
                    error = p.stderr.decode("utf-8")
                    raise ErrorEntrega(error + '\n' + output)"""
                    
            responder(msg, "Todo OK: {}".format(output))
            
        if tp_id in JAVA_TPS:
            zip_adjunto.extractall(skel_dir)
            #Compilo archivo de alumno
            java_arch=tp_id.lower()+".java"
            p=subprocess.run(["javac",java_arch],cwd=skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            output=p.stdout.decode("utf-8")
            
            borrar_archivo_de_directorio(java_arch,skel_dir)
            
            #Si hay error lanzo el errorEntrega
            if p.returncode != 0:
                error = p.stderr.decode("utf-8")
                raise ErrorEntrega(error + '\n' + output)
            print("compilo alumno")
            
            #Compilo archivo de test
            path=JUNIT+";."
            p=subprocess.run(["javac","-cp",path,"Tests.java"],cwd=skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            output=p.stdout.decode("utf-8")
            
            #Si hay error lanzo el errorEntrega
            if p.returncode != 0:
                borrar_archivo_de_directorio(tp_id.lower()+".class",skel_dir)
                error = p.stderr.decode("utf-8")
                raise ErrorEntrega(error + '\n' + output)
            print("compilo test")
            
            #Ejecuto JUnitTests
            executer="org.junit.runner.JUnitCore"
            path = JUNIT + ";" + HAMCREST + ";."
            l=["java","-cp",path,executer,"Tests"]
            p=subprocess.run(l,cwd=skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            output=p.stdout.decode("utf-8")
            
            borrar_archivo_de_directorio(tp_id.lower()+".class",skel_dir)
            borrar_archivo_de_directorio("Test.class",skel_dir)
            
            #Si hay error lanzo el errorEntrega
            if p.returncode != 0:
                error = p.stderr.decode("utf-8")
                raise ErrorEntrega(error + '\n' + output)
            print("ejecutó ")
            
            
            responder(msg, "Todo OK:"+ '\n' + "{}".format(output))
            

            
        

            
                
        

        
    except NoHayMensajesNuevos:
        print("No hay mensajes nuevos")
        #sys.exit()
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

           
def borrar_archivo_de_directorio(archivo,directorio):
    #Borro el archivo descargado del alumno inmediatamente ejecutado el subproceso de correccion
    subprocess.run("del /f" + archivo,cwd=directorio,shell=True,stderr=subprocess.STDOUT)
    subprocess.run("del /f" + archivo.lower(),cwd=directorio,shell=True,stderr=subprocess.STDOUT)
    subprocess.run("del /f" + archivo.upper(),cwd=directorio,shell=True,stderr=subprocess.STDOUT)
                
def buscar_alumno(subject):
    subj_words = [w.lower() for w in re.split(r"[^_\w]+", subject)]

def registrar_entrega(tp_id,alumno_id,aprobo):
    #Ejecutar subproceso que registre esto.
    subj_words = [w.lower() for w in re.split(r"[^_\w]+", subject)]
    return
        
        
if __name__ == "__main__":
  main()