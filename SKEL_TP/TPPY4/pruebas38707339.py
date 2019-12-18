try:
    import sys
    import traceback
    import random
except ImportError:
    raise Exception("ERROR DEL CORRECTOR: PYTHON STL NO ENCONTRADO")

def WD_tuplas_a_diccionario(l):
    dic={}
    for t in l:
        ll=dic.get(t[0],[])
        ll.append(t[1])
        dic[t[0]]=ll
    return dic

def WD_cadena_mas_larga(s):
    s=s.lower()
    dic={}
    for palabra in s.split():
        for letra in palabra:
            palabra_actual = dic.get(letra,palabra)
            if len(palabra) >= len(palabra_actual):
                dic[letra]=palabra
    return dic

def WD_cantidad_apariciones_palabra(s):
    dic={}
    s = s.lower()
    for palabra in s.split():
        dic[palabra]=dic.get(palabra,0)+1
    return dic

def WD_duracion_playlist(dic1,dic2):
    final = {}
    for playlist in dic2:
        final[playlist] = 0
        canciones=dic2[playlist]
        for cancion in canciones:
            final[playlist] = final.get(playlist,0)+dic1[cancion]
    return final

class Test:
    def __init__(self):
        self.fails=0
        
    def print_test(self, mensaje, ok):
        if not ok: self.fails += 1
        print("{} ... {}".format(mensaje,"OK" if ok else "ERROR"))

    def print_test_motivo(self, mensaje, errores):
        if len(errores): self.fails += 1
        print("{} ... {}{}".format(mensaje,"OK" if not errores else "ERROR: ", " + ".join(errores)))
        

    def error_by_except(self, s, err):
        print("---ERROR CON EXCEPTION---")
        self.print_test_motivo(s, ["EXCEPTION LANZADA"])
        print("{}: {}".format(type(err).__name__, err))
        traceback.print_tb(sys.exc_info()[2].tb_next)
        print("-------------------------")

    def bad_import(self):
        raise Exception("ERROR: NO SE DETECTO TPPY4.PY")

test=Test()

try:
    import tppy4
except ImportError:
    test.bad_import()

try:
    from tppy4 import tuplas_a_diccionario
    ej1F = True
except ImportError:
    ej1F = False

try:
    from tppy4 import cantidad_apariciones_palabra
    ej2F = True
except ImportError:
    ej2F = False

try:
    from tppy4 import cadena_mas_larga
    ej3F = True
except ImportError:
    ej3F = False

try:
    from tppy4 import duracion_playlist
    ej4F = True
except ImportError:
    ej4F = False

    
def EJ1_1():
    s="Lista vacia, resultado vacio"
    try:
        l = []; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_2():
    s="Lista de una tupla"
    try:
        l = [("HOLA", "CHAU")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_3():
    s="Lista de dos tuplas distintas"
    try:
        l = [("HOLA", "CHAU"), ("ROJO", "VERDE")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_4():
    s="Lista de dos tuplas con misma clave"
    try:
        l = [("HOLA", "CHAU"), ("HOLA", "CHAU2")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_5():
    s="Lista de 5 tuplas, combinaciones de tuplas con misma clave son 1 2 2"
    try:
        l = [("1", "1"), ("2", "2"), ("2", "3"), ("4", "4"), ("4", "5")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_6():
    s="Lista de 5 tuplas, combinaciones de tuplas con misma clave son 2 1 2"
    try:
        l = [("1", "1"), ("1", "2"), ("3", "3"), ("4", "4"), ("4", "5")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_7():
    s="Lista de 5 tuplas, combinaciones de tuplas con misma clave son 2 2 1"
    try:
        l = [("1", "1"), ("1", "2"), ("3", "3"), ("3", "4"), ("5", "5")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_8():
    s="Lista de 10 tuplas, todas claves distintas"
    try:
        l = [("1", "A"), ("2", "B"), ("3", "C"), ("4", "D"), ("5", "E"), ("6", "F"), ("7", "G"), ("8", "H"), ("9", "I"), ("10", "J")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_9():
    s="Lista de 10 tuplas, todas claves iguales"
    try:
        l = [("1", "A"), ("1", "B"), ("1", "C"), ("1", "D"), ("1", "E"), ("1", "F"), ("1", "G"), ("1", "H"), ("1", "I"), ("1", "J")]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_10():
    s="Lista con clave None, varios tipos para valores"
    try:
        l = [(None, "A"), (None, 1), (None, None), (None, True)]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_11():
    s="Lista con clave numerica, varios tipos para valores"
    try:
        l = [(1, "A"), (1, 1), (1, None), (1, True)]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_12():
    s="Lista con clave booleana, varios tipos para valores"
    try:
        l = [(False, "A"), (False, 1), (False, None), (False, True)]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_13():
    s="Lista con clave de string, varios tipos para valores"
    try:
        l = [("A", "A"), ("B", 1), ("C", None), ("D", True)]; good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_14():
    s="Caso aleatorio, 100 elementos, esta garantizado que va a haber claves duplicadas"
    try:
        l = []; 
        for i in range(100):
            l.append((random.choice([None, 1, 2, 3, True, False, "", "A", "B"]),i))
        good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ1_15():
    s="Caso aleatorio, 10000 elementos, esta garantizado que va a haber claves duplicadas"
    try:
        l = []; 
        for i in range(10000):
            l.append((random.choice([None, 1, 2, 3, True, False, "", "A", "B"]),i))
        good_ref = list(l); good_res = WD_tuplas_a_diccionario(l); errors = []
        res = tuplas_a_diccionario(l)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if l != good_ref:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_1():
    s="Cadena vacia"
    try:
        input_s = ""; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_2():
    s="Cadena una sola letra"
    try:
        input_s = "A"; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_3():
    s="Cadena en miniscula"
    try:
        input_s = "uno dos dos cuatro dos cinco tres tres ocho uno"; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_4():
    s="Cadena con mayusculas, la salida esta en minusculas"
    try:
        input_s = "Uno Uno uno dos dos cuAtro cuAtro Tres Tres ocho"; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_5():
    s="Cadena con numeros"
    try:
        input_s = "1 2 2 3 5 6 seis ocho uno dos cu4tro cu4tro"; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_6():
    s="Cadena con multiples espacios"
    try:
        input_s = "uno dos  dos      cuatro   cinco cinco  seis seis   ocho dos"; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_7():
    s="Cadena con espacios en las puntas"
    try:
        input_s = "  dos dos cuatro cinco seis dos tres tres ocho nueve  "; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_8():
    s="Cadena con solo espacios"
    try:
        input_s = "                   "; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_9():
    s="Cadena con solo una palabra"
    try:
        input_s = "ABCDEFGH"; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_10():
    s="Cadena con 100000 repeticiones"
    try:
        input_s = "A " * 100000; good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ2_11():
    s="Cadena con 10000 palabras al azar, incluyendo numeros"
    try:
        input_s = ""
        for i in range(10000):
            input_s += random.choice(["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"]) + " "
        good_res = WD_cantidad_apariciones_palabra(input_s); errors = []
        res = cantidad_apariciones_palabra(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_1():
    s="Cadena vacia"
    try:
        input_s = ""; good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_2():
    s="Cadena una sola letra"
    try:
        input_s = "A"; good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_3():
    s="Cadena una sola letra"
    try:
        input_s = "CASA"; good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_4():
    s="Cadena con 4 palabras"
    try:
        input_s = "HOLA COMO ESTAS PASANDOLA"; good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_5():
    s="Cadena con 4 palabras, varios espacios innecesarios"
    try:
        input_s = "    HOLA    COMO  ESTAS      PASANDOLA  "; good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_6():
    s="Cadena de una palabra con 10000 caracteres consecutivos"
    try:
        input_s = "AB" * 5000; good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_7():
    s="Cadena de 100 palabras, cada una mas larga que la anterior"
    try:
        input_s = ""
        for i in range(1, 101):
            input_s += "A" * i + " "
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_8():
    s="Cadena de 100 palabras, cada una mas corta que la anterior"
    try:
        input_s = ""
        for i in range(100, 0, -1):
            input_s += "A" * i + " "
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_9():
    s="Cadena de 5 palabras, hay empates de cantidad en algunas letras pero no son la respuesta optima"
    try:
        input_s = "HOLA CHAU CASA ACABAR HH"
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_10():
    s="Cadena de 5 palabras, hay palabras repetidas"
    try:
        input_s = "HOLA HOLA HOLA CHAU HAHA"
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_11():
    s="Cadena de 50000 palabras"
    try:
        input_s = (random.choice(["A", "B"]) + " ") * 50000
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_12():
    s="La cadena ingresada contiene numeros"
    try:
        input_s = "n0 m3 6u574n l45 p4l4b45 l4r645"
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_13():
    s="La cadena ingresada son 500000 espacios"
    try:
        input_s = " " * 500000
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ3_14():
    s="Caso de prueba con texto especifico 1"
    try:
        input_s = "Escribir una funcion que reciba una lista de tuplas y que devuelva un diccionario en donde las claves sean los primeros elementos de las tuplas y los valores una lista con los segundos"
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)
        
def EJ3_15():
    s="Caso de prueba con texto especifico 2"
    try:
        input_s = "Caso de prueba con texto especifico 2"
        good_res = WD_cadena_mas_larga(input_s); errors = []
        res = cadena_mas_larga(input_s)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_1():
    s="Los dos diccionarios vacios"
    try:
        d1, d2 = {}, {}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)

        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_2():
    s="Una cancion, una playlist, la cancion forma parte de la playlist"
    try:
        d1, d2 = {"1": 1}, {"1" : ["1"]}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_3():
    s="Una cancion, una playlist, la cancion no forma parte de la playlist"
    try:
        d1, d2 = {"1": 1}, {"1" : []}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_4():
    s="3 canciones, 8 playlist, se analizan las 8 posibilidades"
    try:
        d1, d2 = {"1": 1, "2" : 10, "3" : 100}, {"1" : [], "2" : ["1"], "3" : ["2"], "4" : ["2", "1"], "5" : ["3"], "6" : ["3", "1"], "7" : ["3", "2"], "8": ["3", "2", "1"]}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_5():
    s="1000 canciones, cada una aparece o no en 0/1/muchas playlists al azar"
    try:
        d1 = {}
        for i in range(1,1000):
            d1[str(i)] = i
        d2 = {"0" : [], "1" : [], "2" : [], "3" : [], "4" : []}
        for i in range(1,1000):
            stri = str(i)
            if bool(random.getrandbits(1)): d2["0"].append(stri)
            if bool(random.getrandbits(1)): d2["1"].append(stri)
            if bool(random.getrandbits(1)): d2["2"].append(stri)
            if bool(random.getrandbits(1)): d2["3"].append(stri)
            if bool(random.getrandbits(1)): d2["4"].append(stri)
        g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_6():
    s="Una cancion y una playlist tienen como nombre el string vacio"
    try:
        d1, d2 = {"": 1, "1" : 1}, {"" : [], "1" : [""], "2" : ["1"], "3" : ["1", ""]}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_7():
    s="Todas las canciones en todas las playlists"
    try:
        d1, d2 = {"1": 1, "2" : 10, "3" : 100}, {"1" : ["1", "2", "3"], "2" : ["1", "2", "3"], "3" : ["1", "2", "3"]}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_8():
    s="Hay canciones pero no playlists"
    try:
        d1, d2 = {"1": 1, "2" : 10, "3" : 100}, {}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

def EJ4_9():
    s="Mismas playlists pero canciones in diferente orden"
    try:
        d1, d2 = {"A": 1, "B" : 10, "C" : 100}, {"1" : ["A", "B", "C"], "2" : ["A", "C", "B"],"2" : ["B", "A", "C"],"4" : ["B", "C", "A"],"5" : ["C", "A", "B"],"6" : ["C", "B", "A"],}; g1, g2 = dict(d1), dict(d2); good_res = WD_duracion_playlist(d1, d2); errors = []
        res = duracion_playlist(d1, d2)
        if res != good_res:
            errors.append("RESPUESTA ERRONEA")
        if d1 != g1 or d2 != g2:
            errors.append("REFERENCIA MODIFICADA")
        test.print_test_motivo(s, errors)
    except Exception as err:
        test.error_by_except(s,err)

EJERCICIOS1 = [
    EJ1_1,
    EJ1_2,
    EJ1_3,
    EJ1_4,
    EJ1_5,
    EJ1_6,
    EJ1_7,
    EJ1_8,
    EJ1_9,
    EJ1_10,
    EJ1_11,
    EJ1_12,
    EJ1_13,
    EJ1_14,
    EJ1_15
]
EJERCICIOS2 = [
    EJ2_1,
    EJ2_2,
    EJ2_3,
    EJ2_4,
    EJ2_5,
    EJ2_6,
    EJ2_7,
    EJ2_8,
    EJ2_9,
    EJ2_10,
    EJ2_11
]
EJERCICIOS3 = [
    EJ3_1,
    EJ3_2,
    EJ3_3,
    EJ3_4,
    EJ3_5,
    EJ3_6,
    EJ3_7,
    EJ3_8,
    EJ3_9,
    EJ3_10,
    EJ3_11,
    EJ3_12,
    EJ3_13,
    EJ3_14,
    EJ3_15
]
EJERCICIOS4 = [
    EJ4_1,
    EJ4_2,
    EJ4_3,
    EJ4_4,
    EJ4_5,
    EJ4_6,
    EJ4_7,
    EJ4_8,
    EJ4_9
]


def main():
    #HEADER
    print("TPPY4 - Tests hechos por Ignacio Di Leva y Hernan Lanusse")
    print("\nACLARACIONES:" + """

Ejercicio 1 tuplas_a_diccionario:
0 <= len(L) <= 10000
len(t) == 2 para toda tupla t de la lista
NO usar .lower()
Esta garantizado que la lista no contiene tuplas identicas (pueden compartir clave o valor pero no ambas cosas)
El algoritmo debe soportar varios tipos de elementos, no solo strings
Si la lista es modificada y la funcion termina con la lista diferente a la original, tendra un error por REFERENCIA MODIFICADA. La funcion no debe tener side effects. Consejo: si necesitas modificar la lista, podes hacer una copia o recordar de devolverla a su configuracion original

Ejercicio 2 cantidad_apariciones_palabra:
0 <= len(S) <= 200000
Recordar de usar .lower()
Esta garantizado que el string no tiene caracteres especiales (es siempre alfanumerico con espacios)

Ejercicio 3 cadena_mas_larga:
0 <= len(S) <= 500000
Recordar de usar .lower()
Esta garantizado que el string no tiene caracteres especiales (es siempre alfanumerico con espacios)
En caso de que la haya un empate en las cadenas mas largas, utilizar siempre la ultima correcta

Ejercicio 4 duracion_playlist:
0 <= len(dic1) <= 1000
0 <= len(dic2) <= 1000
0 <= len(L) <= 1000 para todo L en dic2
NO usar .lower()
Esta garantizado que la duracion de las canciones son siempre un entero positivo
Una cancion puede pertenecer a 0, 1, o multiples playlists
Una playlist no puede contener a la misma cancion mas de una vez
Si qualquiera de los dos diccionarios es modificado y la funcion termina con este diferente a su version original, tendra un error por REFERENCIA MODIFICADA. La funcion no debe tener side effects. Consejo: si necesitas modificar algun diccionario, podes hacer una copia o recordar de devolverlo a su configuracion original
"""
)
    print("TESTS:\n")
    #EJ1
    if ej1F:
        print("EJERCICIO 1")
        for f in EJERCICIOS1:
            f()
    else:
        test.fails += len(EJERCICIOS1)
        print("Ejercicio 1 no encontrado, " + str(len(EJERCICIOS1)) + " errores")
    print("\n\n")
    #EJ2
    if ej2F:
        print("EJERCICIO 2")
        for f in EJERCICIOS2:
            f()
    else:
        test.fails += len(EJERCICIOS2)
        print("Ejercicio 2 no encontrado, " + str(len(EJERCICIOS2)) + " errores")
    print("\n")
    #EJ3
    if ej3F:
        print("EJERCICIO 3")
        for f in EJERCICIOS3:
            f()
    else:
        test.fails += len(EJERCICIOS3)
        print("Ejercicio 3 no encontrado, " + str(len(EJERCICIOS3)) + " errores")
    print("\n")
    #EJ4
    if ej4F:
        print("EJERCICIO 4")
        for f in EJERCICIOS4:
            f()
    else:
        test.fails += len(EJERCICIOS4)
        print("Ejercicio 4 no encontrado, " + str(len(EJERCICIOS4)) + " errores")
    print("\n")
    #FOOTER
    if test.fails != 0:
        raise Exception("ERROR: Hubo "+ str(test.fails) + " fallo" + "" if test.fails == 1 else "s" + " en los asserts del TP. Revisar")
    else:
        print("OK " + str(len(EJERCICIOS1) + len(EJERCICIOS2) + len(EJERCICIOS3) + len(EJERCICIOS4)) + " tests\n")
        print("Felicitaciones!\nNacho & J")

if __name__ == "__main__":
    main()