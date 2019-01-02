# -*- coding: utf-8 -*-
"""
Script que contiene la clase LimiteDeEntrega. Encargada de manipular las credenciales de los trabajos practicos y decidir si un trabajo practico
- Se corrige normalmente
- Se corrige con advertencia por entrega tardía 
- No se corrige


NO DEBE SER SENSIBLE A FALLOS. SI NO EXISTEN LAS CREDENCIALES DEBE SEGUIR CORRIGIENDO NORMALMENTE
"""
from excepciones import TrabajoVencido
import json
from datetime import datetime

class LimiteDeEntrega:
    
    def __init__(self, skel_dir, fechaAlumno):
        self.credential=skel_dir / "credentials.json"
        self.fechaAlumno=fechaAlumno.replace(hour=0, minute=0, second=0)
        self.advertencia = False
    
    def checkear(self): #CAMBIAR ESTE NOMBRE HORRIBLE
        credential={}
        with open(self.credential) as handle:
            credential = json.load(handle)
        fechaVencimiento = datetime.strptime(credential["vencimiento"], '%d/%m/%Y')
        if self.fechaAlumno > fechaVencimiento:
            self.advertencia=True
            if not credential["corregible"]:
                raise TrabajoVencido("La fecha limite del trabajo ya expiro, la misma era {} y la entrega fue realizada a fecha {}. La entrega no sera tenida en cuenta".format(fechaVencimiento,self.fechaAlumno))
    

