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
        self.fechaAlumno=fechaAlumno
        self.advertencia = False
    
    def confirmar_horario_entrega(self):
        credential={}
        with open(self.credential) as handle:
            credential = json.load(handle)
        fechaVencimiento = datetime.strptime(credential["vencimiento"], '%d/%m/%Y')
        fechaVencimiento = fechaVencimiento.replace(hour=23, minute=59, second=59)
        if self.fechaAlumno > fechaVencimiento:
            self.advertencia=True
            if not credential["corregible"]:
                raise TrabajoVencido("La fecha limite del trabajo ya expiro, la misma era {} y la entrega fue realizada a fecha {}. La entrega no sera tenida en cuenta".format(fechaVencimiento,self.fechaAlumno))
    

