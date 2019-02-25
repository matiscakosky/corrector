# -*- coding: utf-8 -*-
"""
Algoritmo de calculo de notas - Taller de Desarrollo de sistemas.

La materia tiene una forma definida y absoluta para el calculo de notas. Los criterios para aprobar la materia son:
    - Condicion necesaria de aprobacion: Todos los trabajos del trimestre y los examenes deben estar aprobados.
    - Las ponderaciones del corrector son 3. TODO OK, TARDE, ERROR. Solo las primeras dos cuentan como aprobadas.
    - Tener todos los trabajos hechos y aprobados en fecha (es decir, no hay tardes) suma +1 a la nota final.
    - No tener algun trabajo aprobado hace que la nota maxima del trimestre sea 5
    - Cualquier trabajo copiado hace que la nota maxima del trimestre sea 3
    - La nota base es un conjunto entre la nota del choice y el examen practico: puntajeObtenido* 0.4 + notaPractico * 0.6
"""
#Notaciones del spreadsheet
COPIA="COPIA"
ERROR="ERROR"
GRAIDIANCE="GRADIANCE1"
PRACTICO = "PRACTICO1"
TARDE="TARDE"

#Lista de trabajos practicos del año
TPS=["FRACCION","VECTOR","MAZO","FIUGRA","POLIGONO","VEHICULO","COCINA","TPPY1","TPPY2","TPPY3","TPPY4","LISTA"]

def calcular_nota_alumno(features):
    """Recibe un diccionario de features donde las claves son los trabajos o los examenes y los valores las notas. Devuelve una nota asociada """
    
    maximo = 10
	premio_todo_ok=1
    #Checkeo de trabajos practicos
    for k in features:
        if (k in TPS and not features[k]) or features[k]==ERROR:
            maximo=5
    if COPIA in features and features[COPIA]:
        maximo=3
    for k in features:
        if features[k]==TARDE:
            premio_todo_ok = 0
			break
        
    #Checkeo de examenes.
    
    raw_new_gradiance=features[GRAIDIANCE]
    gradiance= (raw_new_gradiance/18) * 10
    practico = features[PRACTICO]
    
    if gradiance <= 5 or practico <=5:
        maximo = 5
    
    ajustable= gradiance*0.4 + practico*0.6
    nota_final = (ajustable/10)*maximo
    
    return nota_final + premio_todo_ok
    
    

