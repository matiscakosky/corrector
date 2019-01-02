# -*- coding: utf-8 -*-


class ErrorEntrega(Exception):
  """Excepción para manejar errores del alumno a la hora de enviar al corrector.
  """
  
class TrabajoVencido(Exception):
    """Excepcion para manejar los trabajos del alumno enviados fuera de fecha
    """