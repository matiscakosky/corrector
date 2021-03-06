# -*- coding: utf-8 -*-

import os
import subprocess
import zipfile
from excepciones import ErrorEntrega

JUNIT = os.environ["junit"]
HAMCREST= os.environ["hamcrest"]

PATH = JUNIT + ":" + HAMCREST + ":."
EXECUTER="org.junit.runner.JUnitCore"
COMANDOS=["java","-cp",PATH,EXECUTER,"Tests"]

TIMEOUT = 120


class JavaCorrector4:
    """Corrector de Java
    Objeto que dada una entrega en el directorio correspondiente ejecuta el subproceso de pruebas y corrige.
    Usa JUnit4 y una version de hamcrest 1.3 (Un poco vieja)
    Para informacion acerca de como se ejecuta JUnit desde la consola ir al archivo explicativo. ("Para el subprocess de java.txt")
    

    Pre: Los archivos de Junit y Hamcrest deben estar accesibles
    Parametros: id del TP, path del TP, zip del tp
    """
    
    def __init__(self, id_tp=None,skel_dir=None,zip_tp=None):
        self.id_tp = id_tp
        self.skel_dir= skel_dir
        self.zip=zip_tp
        self.nombre_archivos= zip_tp.namelist()
        
    def corregir(self):
        """Corrige el tp. si Esta aprobado devuelve un mensaje para enviar al alumno, sino lanza excepcion"""
        

        print(self.skel_dir)
        self.zip.extractall(self.skel_dir)
        
        try:
            #Compilo archivos de alumno
            for archivo in self.nombre_archivos:
                p1=subprocess.run(["javac",archivo],cwd=self.skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE,timeout=TIMEOUT)
                if p1.returncode: break     #Corta si encuentra un error.
            
            #Compilo archivo de Tests
            path=JUNIT+":."
            p2=subprocess.run(["javac","-cp",path,"Tests.java"],cwd=self.skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE,timeout=TIMEOUT)
            output=p2.stdout.decode("utf-8")
    
            #Ejecuto JUnit
            p3=subprocess.run(COMANDOS,cwd=self.skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE,timeout=TIMEOUT)
            output=p3.stdout.decode("utf-8")
            
            self.borrar_archivo_de_directorio()
            
            if p1.returncode or p2.returncode or p3.returncode:
                error = "Compilation problems : - " + p1.stderr.decode("utf-8") + p2.stderr.decode("utf-8") + "Execution problems : - " + p3.stderr.decode("utf-8")
                raise ErrorEntrega(error + '\n' + output)
                
            return output
        
        except subprocess.TimeoutExpired:
            self.borrar_archivo_de_directorio()
            raise ErrorEntrega("TimeOut - El proceso tardó demasiado en ejecutar.")
            
    
    def borrar_archivo_de_directorio(self):
        #Borro el archivo descargados
        for filename in os.listdir(self.skel_dir):
            if (filename in self.nombre_archivos) or filename.endswith(".class"):
                os.remove( self.skel_dir + "/" + filename)
        
    

          
       
            
    
