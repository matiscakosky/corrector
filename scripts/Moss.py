# -*- coding: utf-8 -*-

import shutil
import subprocess
import os
import pathlib
import zipfile 
from git import Git


repository=pathlib.Path(r"/mnt/c/users/usuario/desktop/fiuba/Organizacion de datos/La otra/finger 4/Subcarpeta")



MOSS_DIR = pathlib.Path(os.environ["MOSS_DIR"])

class Moss:
    """La clase esta encargada de dejar en un repositorio los scripts de los alumnos descargarlos a una carpet y ejecutar un subproceso que muestre el link a Moss"""

    def __init__(self, id_tp, nombre_alumno, fecha, zip_tp):
        self.destino=MOSS_DIR/id_tp/nombre_alumno
        shutil.rmtree(self.destino, ignore_errors=True) #Borra el directorio si existe ya
        self.destino.mkdir(parents=True)
        self.fecha=fecha
        self.commit_message = f"New {id_tp} upload from {nombre_alumno}"
        self.zip=zip_tp
    
    def guardar_directorio(self):
        """Guarda en /moss/id_tp/nombre_alumno el tp"""
        self.zip.extractall(self.destino)
        return
    
    
    def subir(self):
        """"askpass.py es un script que saque de internet para obtener facil la contraseña de github """
        project_dir = os.path.dirname(os.path.abspath(__file__))
        os.environ['GIT_ASKPASS'] = os.path.join(project_dir, 'askpass.py')
        os.environ['GIT_USERNAME'] = "matiscakosky"
        os.environ['GIT_PASSWORD'] = os.environ["PASS"]
        g = Git(MOSS_DIR) #path to local repo
        self.comitear()
        g.push("origin","master")
    
    
    
    def comitear(self):
        self.git(["add", "--no-ignore-removal", "."])
        self.git(["commit", "-m", self.commit_message, "--date", str(self.fecha)])
    
    def git(self,args):
        subprocess.run(["git"] + args, cwd=MOSS_DIR)
        return