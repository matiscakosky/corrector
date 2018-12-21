# -*- coding: utf-8 -*-


import subprocess
import zipfile
from excepciones import ErrorEntrega


COMANDOS = ["python","pruebas.py"]


class pyCorrector:
    """Corrector de python
    Objeto que dada una entrega en el directorio correspondiente ejecuta el subproceso de pruebas y corrige
    
    Parametros: id del TP, path del TP
    
    """
    
    def __init__(self, id_tp=None,skel_dir=None,zip_tp=None):
        self.id_tp = id_tp
        self.skel_dir= skel_dir
        self.zip=zip_tp
        self.nombre_archivo=""
        
    def corregir(self):
        """Corrige el tp. si Esta aprobado devuelve un mensaje para enviar al alumno, sino lanza excepcion"""
        
        self.zip.extractall(self.skel_dir)
        
        
        
        #Ejecuto el subproceso que corrige el TP
        p=subprocess.run(COMANDOS,cwd=self.skel_dir,stdin=subprocess.DEVNULL,stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            
        borrar_archivo_de_directorio(self.id_tp,self.skel_dir)
            
        output=p.stdout.decode("utf-8")
            
        #registrar_entrega(id_tp,alumno_id,p.returncode)
            
        #Si hay error lanzo el errorEntrega
        if p.returncode != 0:
           error = p.stderr.decode("utf-8")
           raise ErrorEntrega(error + '\n' + output)
        
        return output
           
           
           
           
def borrar_archivo_de_directorio(archivo,directorio):
    #Borro el archivo descargado del alumno inmediatamente ejecutado el subproceso de correccion
    subprocess.run("del /f" + archivo,cwd=directorio,shell=True,stderr=subprocess.STDOUT)
    subprocess.run("del /f" + archivo.lower(),cwd=directorio,shell=True,stderr=subprocess.STDOUT)
    subprocess.run("del /f" + archivo.upper(),cwd=directorio,shell=True,stderr=subprocess.STDOUT)
                
            
    