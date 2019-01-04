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
    """Genera el token de acceso a SpreadSheets """
    credentials = ServiceAccountCredentials.from_json_keyfile_name("My Project-150473bd33ba.json",SCOPES)
    gc=gspread.authorize(credentials)
    wks=gc.open('Alumnos').sheet1
    return wks

def registrar_alumno(wks,nombre,dni,sexto,fecha,email):
    """Agrega al spreadsheet un registro con un nuevo alumno. El ordenado hay que hacerlo a mano.
        Solo se reciben registros dentro de la fecha indicada por la constante LIMITE_REGISRO
    """
    if fecha < LIMITE_REGSITRO:
        wks.append_row([nombre.upper(),str(dni),str(sexto).upper(),(str(fecha).split())[0],email]) 


def registrar_entrega(wks,id_tp,id_alumno,aprobo):
    nota= "OK" if aprobo else "ERROR"
    #Corroboro si esta registrado el tp en el header:
    header= wks.row_values(1)
    if id_tp not in header:
        wks.update_cell(1,len(header)+1,id_tp)
    
    #Busco la fila del alumno que entrego el trabajo
    celdaAlumno = wks.find(id_alumno)
    celdaTP = wks.find(id_tp)
    wks.update_cell(celdaAlumno.row,celdaTP.col,nota)
       

def buscar_id(wks,subj_words):
    print(subj_words)
    """Dado el token de SpreadSheets y un asunto de un mail, busca si hay un DNI en la planilla que coincida con el del asunto"""
    registros=wks.get_all_records()
    for dic in registros:
        if str(dic["DNI"]) and str(dic["DNI"]) in subj_words:
            print("Se encontró al alumno en la planilla", str(dic["DNI"]))
            return str(dic["DNI"])
    raise AlumnoInexistente("No se encontro ningun alumno registrado")
    
    
    