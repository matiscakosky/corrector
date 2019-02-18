# -*- coding: utf-8 -*-
"""
Script que contiene la clase LimiteDeEntrega. Encargada de manipular las credenciales de los trabajos practicos y decidir que hacer dadod un trabajo practico

La fecha de vencimiento sera dada en clase y tendran tiempo de hacerla hasta ese dia a las 23:59:59

"""
from excepciones import TrabajoVencido
import json
from datetime import datetime

class LimiteDeEntrega:
    """La clase modela un limitador que dice si el tp esta en condiciones de ser corregido o no.
    La clase se genera a partir del path del trabajo practico a delimitar y la fecha en la que el trabajo fue entregado.
    Un archivo de credenciales en formato json debe estar dentro del path de pruebas del trabajo practico junto con todo lo demás que haga falta para que sea corregido
    La clase LimiteDeEntrega leera previamente el archivo de crendenciales y guardara entre sus atributos si debe enviar una advertencia al alumno por el vencimiento o directamente lanza
    una excepcion al flujo principal porque el trabajo esta vencido.
    """
    
    def __init__(self, skel_dir, fechaAlumno):
        self.credential=skel_dir / "credentials.json"
        self.fechaAlumno=fechaAlumno
        self.advertencia = False
    
    def confirmar_horario_entrega(self):
        """Confirma segun las credenciales almacenadas en sus atributos si:
        - Se corrige normalmente
        - Se corrige con advertencia por entrega tardía 
        - No se corrige:
        """
        credential={}
        try:
            with open(self.credential) as handle:
                credential = json.load(handle)
            fechaVencimiento = datetime.strptime(credential["vencimiento"], '%d/%m/%Y %H:%M:%S')
            if self.fechaAlumno > fechaVencimiento:
                self.advertencia=True
                if not credential["corregible"]:
                    raise TrabajoVencido("La fecha limite del trabajo ya expiro, la misma era {} y la entrega fue realizada a fecha {}. La entrega no sera tenida en cuenta".format(fechaVencimiento,self.fechaAlumno))
        except FileNotFoundError:
            print("NO HAY CREDENCIALES DISPONIBLES PARA ESTE TRABAJO PRACTICO")
            return
        except ValueError as err:
            print(err)
            return

