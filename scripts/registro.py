# -*- coding: utf-8 -*-
"""
Script principal que maneja los registro de los alumnos

"""
import gspread
from oauth2client.service_account import ServiceAccountCredentials
from excepciones import AlumnoInexistente
from datetime import datetime
LIMITE_REGSITRO= (datetime.strptime("31/03/2019", '%d/%m/%Y')).replace(hour=23, minute=59, second=59)
SCOPES=['https://spreadsheets.google.com/feeds', 'https://www.googleapis.com/auth/drive']

def autenticar():
    credentials = ServiceAccountCredentials.from_json_keyfile_name("My Project-150473bd33ba.json",SCOPES)
    gc=gspread.authorize(credentials)
    wks=gc.open('Alumnos').sheet1
    return wks

def registrar_alumno(wks,nombre,dni,sexto,fecha,email):
    """Agrega al spreadsheet un registro con un nuevo alumno. El ordenado hay que hacerlo a mano.
        Solo se reciben registros dentro de la fecha indicada por la constante LIMITE_REGISRO
    """
    if fecha < LIMITE_REGSITRO:
        wks.append_row([nombre,dni,sexto,(str(fecha).split())[0],email]) 
    
    
