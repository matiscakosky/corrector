# -*- coding: utf-8 -*-


import subprocess
import zipfile
from excepciones import ErrorEntrega

JUNIT = r'C:\Users\Usuario\Desktop\ORT\Corrector\java\junit.jar'
HAMCREST= r'C:\Users\Usuario\Desktop\ORT\Corrector\java\hamcrest.jar'
PATH = JUNIT + ";" + HAMCREST + ";."
EXECUTER="org.junit.runner.JUnitCore"
COMANDOS=["java","-cp",PATH,EXECUTER,"Tests"]


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
        self.nombre_archivo=""
        
    def corregir(self):
        """Corrige el tp. si Esta aprobado devuelve un mensaje para enviar al alumno, sino lanza excepcion"""
        
        self.zip.extractall(self.skel_dir)
        
        
        #Compilo archivo de alumno
        java_arch=self.id_tp.lower()+".java"
        p1=subprocess.run(["javac",java_arch],cwd=self.skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        output=p1.stdout.decode("utf-8")
        
        #Compilo archivo de Tests
        path=JUNIT+";."
        p2=subprocess.run(["javac","-cp",path,"Tests.java"],cwd=self.skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        output=p2.stdout.decode("utf-8")
        
        #Ejecuto JUnit
        p3=subprocess.run(COMANDOS,cwd=self.skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        output=p3.stdout.decode("utf-8")
        
        if p1.returncode or p2.returncode or p3.returncode:
            error = "Compilation problems : - " + p1.stderr.decode("utf-8") + "Execution problems : - " + p3.stderr.decode("utf-8")
            mensaje=""
            raise ErrorEntrega(error + '\n' + output + mensaje)
        
        return output
          
           
          
          
def borrar_archivo_de_directorio(archivo,directorio):
    #Borro el archivo descargado del alumno inmediatamente ejecutado el subproceso de correccion
    subprocess.run("del /f" + archivo,cwd=directorio,shell=True,stderr=subprocess.STDOUT)
    subprocess.run("del /f" + archivo.lower(),cwd=directorio,shell=True,stderr=subprocess.STDOUT)
    subprocess.run("del /f" + archivo.upper(),cwd=directorio,shell=True,stderr=subprocess.STDOUT)
                
            
    