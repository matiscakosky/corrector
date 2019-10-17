from tppy3_wd import *
from tppy3 import *
from testing import show_test
import traceback
import math
import gc

#import sys
#sys.path.append("/usr/local/lib/python3.6/dist-packages")


from memory_profiler import memory_usage
import random


test=show_test()

def ejercicio1_test1():
    s="Compruebo las repeticiones consectuvas con una lista de un elemento"
    test_resul=repeticiones_consecutivas_wd([1])
    try:
        resul = repeticiones_consecutivas([1])
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
        
    
def ejercicio1_test2():
    s="Compruebo las repeticiones consecutivas con una lista de 3 elementos diferentes sin repetir"
    test_resul=repeticiones_consecutivas_wd([1,2,3])
    try:
        resul = repeticiones_consecutivas([1,2,3])
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)    
        

def ejercicio1_test3():
    s="Compruebo las repeticiones consecutivas con una lista de 2 elementos iguales al principio y uno sin repetir"
    test_resul=repeticiones_consecutivas_wd([1,1,3])
    try:
        resul = repeticiones_consecutivas([1,1,3])
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)

def ejercicio1_test4():
    s="Compruebo una lista con varios elementos repetidos al final"
    test_resul=repeticiones_consecutivas_wd([1,3,3,3,3,3,3,3,3,3,3,3])
    try:
        resul = repeticiones_consecutivas([1,3,3,3,3,3,3,3,3,3,3,3])
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
    
def ejercicio1_test5():
    s="Compruebo un caso general de varios elementos diferentes repetidos"
    test_resul=repeticiones_consecutivas_wd([3,3,5,2,4,6,2,3,4,5,6,2,2,2,2,2,3,3,3,3,35,5,5,5,5,5,1,1,1,1,2,2,2,2,4,5,6,7,7,7,7,1])
    try:
        resul = repeticiones_consecutivas([3,3,5,2,4,6,2,3,4,5,6,2,2,2,2,2,3,3,3,3,35,5,5,5,5,5,1,1,1,1,2,2,2,2,4,5,6,7,7,7,7,1])
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)    
        
        
def ejercicio1_test6():
    s="Compruebo repeticiones consecutivas con el ejemplo del enunciado"
    test_resul=repeticiones_consecutivas_wd([1,1,1,3,3,2,1])
    try:
        resul = repeticiones_consecutivas([1,1,1,3,3,2,1])
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)    
        
        
def ejercicio1_test7():
    s="Tomo una lista de 100 elementos al azar y compruebo sus repeticiones"
    lista=[]
    for i in range(100):
        lista.append(random.randint(0,3))
    test_resul=repeticiones_consecutivas_wd(lista)
    try:
        resul = repeticiones_consecutivas(lista)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)    
    
    
        
        
def ejercicio2_test1():
    s="Compruebo empaquetar una cadena de a 1"
    cad = "hola"
    num=1
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)
    

def ejercicio2_test2():
    s="Compruebo ejemplo de una frase agrupados de a 2"
    cad = "a caballo regalado no se le miran los dientes"
    num=2
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)
        
def ejercicio2_test3():
    s="Compruebo ejemplo con frase 1"
    cad = "Una sandia fantasma, por supuesto"
    num=3
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)
        
        
def ejercicio2_test4():
    s="Compruebo ejemplo con frase 2"
    cad = "Mas vale pajaro en mano, que 100 volando"
    num=4
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)
        
def ejercicio2_test5():
    s="Compruebo ejemplo con frase 3"
    cad = "Mas vale pajaro en mano, que 100 volando"
    num=4
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)


def ejercicio2_test6():
    s="Compruebo ejemplo con frase larga agrupados de a numero grande"
    cad = "Yo tengo un cumple medio lejos pero tal vez me pueda pegar una escapada, confirmo ese dia tambien Yo tengo un cumple medio lejos pero tal vez me pueda pegar una escapada, confirmo ese dia tambien Yo tengo un cumple medio lejos pero tal vez me pueda pegar una escapada, confirmo ese dia tambien Yo tengo un cumple medio lejos pero tal vez me pueda pegar una escapada, confirmo ese dia tambien Yo tengo un cumple medio lejos pero tal vez me pueda pegar una escapada, confirmo ese dia tambien"
    num=20
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)


def ejercicio2_test7():
    s="Compruebo ejemplo con cadena vacia"
    cad = ""
    num=1
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)



def ejercicio2_test7():
    s="Compruebo ejemplo con cadena mas chica que el numero para agrupar"
    cad = "Mati"
    num=100
    test_resul=empaquetar_wd(cad,num)
    try:
        resul = empaquetar(cad,num)
        test.print_test(s,resul==test_resul)
    except Exception as err:
        error_by_except(s,err)

def measure_mem(func):
    gc.collect()
    process_usage = memory_usage(max_usage=True)
    gc.collect()
    usage = memory_usage(func, 0.005, max_usage=True)[0]
    gc.collect()
    return usage - process_usage 

def ejercicio3_test1():
    s = "Invierto la lista vacia, devuelve la lista vacia"
    try:
        test.print_test(s, invertir([]) == [])
    except Exception as err:
        error_by_except(s, err)

def ejercicio3_test2():
    s = "Invierto la lista de un elemento, devuelve la misma lista"
    try:
        test.print_test(s, invertir([1234]) == [1234])
    except Exception as err:
        error_by_except(s, err)

def ejercicio3_test3():
    s = "Invierto la lista de una cantidad par de elementos, devuelve la lista invertida"
    try:
        test.print_test(s, invertir(list(range(0, 128))) == list(range(127, -1, -1)))
    except Exception as err:
        error_by_except(s, err)

def ejercicio3_test4():
    s = "Invierto la lista de una cantidad impar de elementos, devuelve la lista invertida"
    try:
        test.print_test(s, invertir(list(range(0, 127))) == list(range(126, -1, -1)))
    except Exception as err:
        error_by_except(s, err)

def ejercicio3_test5():
    s = "Invierto la lista de una cantidad grande de elementos, devuelve la lista invertida"
    try:
        test.print_test(s, invertir(list(range(0, 500000))) == list(range(499999, -1, -1)))
    except Exception as err:
        error_by_except(s, err)

DL6_ARG = []
DL6_RES = []
def DL6_CALL():
    invertir_inplace(DL6_ARG)
    
def ejercicio3_test6():
    s = "Invierto inplace la lista vacia, devuelve la lista vacia y usa poca memoria"
    try:
        mem = measure_mem(DL6_CALL)
        test.print_test(s, DL6_ARG == DL6_RES and mem < 1)
    except Exception as err:
        error_by_except(s, err)

DL7_ARG = [1234]
DL7_RES = [1234]
def DL7_CALL():
    invertir_inplace(DL7_ARG)
    
def ejercicio3_test7():
    s = "Invierto inplace la lista de un elemento, devuelve la misma lista y usa poca memoria"
    try:
        mem = measure_mem(DL7_CALL)
        test.print_test(s, DL7_ARG == DL7_RES and mem < 1)
    except Exception as err:
        error_by_except(s, err)

DL8_ARG = list(range(0, 128))
DL8_RES = list(range(127, -1, -1))
def DL8_CALL():
    invertir_inplace(DL8_ARG)
    
def ejercicio3_test8():
    s = "Invierto inplace la lista de una cantidad par de elementos, devuelve la lista invertida y usa poca memoria"
    try:
        mem = measure_mem(DL8_CALL)
        test.print_test(s, DL8_ARG == DL8_RES and mem < 1)
    except Exception as err:
        error_by_except(s, err)

DL9_ARG = list(range(0, 127))
DL9_RES = list(range(126, -1, -1))
def DL9_CALL():
    invertir_inplace(DL9_ARG)
def ejercicio3_test9():
    s = "Invierto inplace la lista de una cantidad impar de elementos, devuelve la lista invertida y usa poca memoria"
    try:
        mem = measure_mem(DL9_CALL)
        test.print_test(s, DL9_ARG == DL9_RES and mem < 1)
    except Exception as err:
        error_by_except(s, err)

DL10_ARG = list(range(0, 500000))
DL10_RES = list(range(499999, -1, -1))
def DL10_CALL():
    invertir_inplace(DL10_ARG)
    
def ejercicio3_test10():
    s = "Invierto inplace la lista de una cantidad grande de elementos, devuelve la lista invertida y usa poca memoria"
    try:
        mem = measure_mem(DL10_CALL)
        test.print_test(s, DL10_ARG == DL10_RES and mem < 1)
    except Exception as err:
        error_by_except(s, err)
        
        
        
        
def ejercicio4_test1():
    s="Utilizo map y filter con listas vacias, el resultado son listas vacias"
    lista=[]
    lista = list(map(None,[]))
    lista = list(filter(None,[]))
    try:
        lista_test = _map(None,[])
        lista_test =  _filter(None,[]) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)
        
        
def f(x):
    return x**2
def reemplazar_e(s):
    return s.replace("o","e")
def es_int(x):
    return x.isdigit()
def es_primo(n):
    for i in range(2,int(n**0.5)+1):
        if n%i == 0:
            return False
    return True

def conversion(elem):
    try:
        int(elem)
        return True
    except:
        return False
        
def ejercicio4_test2():
    s="Utilizo map con una funcion matematica sobre elementos numericos"
    lista_i=[1,2,3,4,5,6,7,8]
    lista = list(map(f,lista_i))
    try:
        lista_test = _map(f,lista_i)
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)
def conversion(elem):
    try:
        int(elem)
        return True
    except:
        return False
def false(e):
    return False
        
def ejercicio4_test3():
    s="Utilizo map con una funcion que opera sobre cadenas"
    lista=["compu","mati","futbol","Google","ort","juntos","inclusivo","tomi"]
    lista = list(map(reemplazar_e,lista))
    try:
        lista_test = _map(reemplazar_e,lista) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)
def ejercicio4_test4():
    s="Utilizo map sobre elementos variados"
    lista_i=["compu","1","futbol","2","ort","10","6","5","a"]
    lista = list(map(es_int,lista_i))
    try:
        lista_test = _map(es_int,lista_i) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)

def ejercicio4_test5():
    s="Utilizo filter sobre elementos numericos con una funcion matematica"
    lista=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,176,17,18,19,20,21,22,23]
    lista = list(filter(es_primo,lista))
    try:
        lista_test = _filter(es_primo,lista) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)
        
        

def ejercicio4_test6():
    s="Utilizo filter sobre una funcion con elementos de tipo string"
    lista=["compu","1","futbol","2","ort","10","6","5","a"]
    lista = list(filter(es_int,lista))
    try:
        lista_test = _filter(es_int,lista) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio4_test7():
    s="Utilizo la funcion filter sobre elementos variados"
    lista=["compu","1",(1,2),[],3,4.1,{},"5","a"]
    lista = list(filter(conversion,lista))
    try:
        lista_test = _filter(conversion,lista) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)
        

def ejercicio4_test8():
    s="Filter de una lista con un elemento deja una lista vacia"
    lista=["a"]
    lista = list(filter(false,lista))
    try:
        lista_test = _filter(false,lista) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)

def ejercicio4_test9():
    s="Map con un solo elemento deja un solo elemento"
    lista=["a"]
    lista = list(map(false,lista))
    try:
        lista_test = _map(false,lista) 
        test.print_test(s,lista_test==lista)
    except Exception as err:    
        error_by_except(s,err)


        

def error_by_except(s,err):
        test.print_test(s, False)
        print("El test del punto lanzo la exception {}".format(err))
        traceback.print_exc()

def main():
    
    print("")
    print("Trabajo practico 2 - Python")
    print("")
    
    print("Ejercicio 1")
    ejercicio1_test1()
    ejercicio1_test2()
    ejercicio1_test3()
    ejercicio1_test4()
    ejercicio1_test5()
    ejercicio1_test6()
    ejercicio1_test7()
    
    
    print("")
    print("Ejercicio 2") 
 
    ejercicio2_test1()
    ejercicio2_test2()
    ejercicio2_test3()
    ejercicio2_test4()
    ejercicio2_test5()
    ejercicio2_test6()
    ejercicio2_test7()  
    print("")
    print("Ejercicio 3")
   
    ejercicio3_test1()
    ejercicio3_test2()
    ejercicio3_test3()
    ejercicio3_test4()
    ejercicio3_test5()
    ejercicio3_test6()
    ejercicio3_test7()
    ejercicio3_test8()
    ejercicio3_test9()
    ejercicio3_test10()
    
    print("")
    print("Ejercicio 4")   
    
    
    
    ejercicio4_test1()
    ejercicio4_test2()
    ejercicio4_test3()
    ejercicio4_test4()
    ejercicio4_test5()
    ejercicio4_test6()
    ejercicio4_test7()
    ejercicio4_test8()
    ejercicio4_test9()
    
    
    if test.fails != 0:
        raise Exception("ERROR: Hubo fallos " + str(test.fails) + " en los asserts del TP. Revisar")

    return 

if __name__ == "__main__":
  main()
