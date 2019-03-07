# -*- coding: utf-8 -*-


class ErrorEntrega(Exception):
  """Excepción para manejar errores del alumno a la hora de enviar al corrector.
  """
  
class TrabajoVencido(Exception):
    """Excepcion para manejar los trabajos del alumno enviados fuera de fecha
    """
    
class AlumnoInexistente(Exception):
    """Excepcion para manejar los trabajos de alumnos que no estan registrados
    """

class EmailIncorrecto(Exception):
	"""Excepcion para manejar los trabajos de alumnos que no estan registrados
	"""