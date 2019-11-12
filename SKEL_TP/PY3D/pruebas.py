from py3d import *
from py3d_wd import *
from testing import show_test
from ListaEnlazadaTest import Nodo as Nodo
from ListaEnlazadaTest import ListaEnlazada as LinkedList
import traceback
import random


test=show_test()

def ejercicio1_test1():
    s="Pruebo una matriz triangular de 2x2"
    fallos = test.fails
    valor=.5
    m1=[[-1,0],[0,3]]
    try:
        test.print_test(s, es_triang_superior(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
        
    
def ejercicio1_test2():    
    s="Pruebo una matriz triangular de 3x3"
    fallos = test.fails
    valor=.5
    m1=[[21,1,1],[0,24,1],[0,0,25]]
    try:
        test.print_test(s, es_triang_superior(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
        

def ejercicio1_test3():
    s="Pruebo una matriz no triangular de 3x3"
    fallos = test.fails
    valor=.5
    m1=[[21,1,1],[1,24,0],[1,1,25]]
    try:
        test.print_test(s, not es_triang_superior(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
           

def ejercicio1_test4():
    s="Pruebo una matriz no triangular de 2x2"
    fallos = test.fails
    valor=.5
    m1=[[0,0],[1,3]]
    try:
        test.print_test(s, not es_triang_superior(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
    
def ejercicio2_test1():
    s="Compruebo el diccionario con una frase de una sola palabra"
    valor=1
    fallos = test.fails
    frase = "Hola"
    test_resul = terminan_con_wd(frase)
    try:
        resul = terminan_con(frase)
        test.print_test(s, test_resul==resul)
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0

def ejercicio2_test2():
    s="Compruebo con una frase de mayor longitud"
    valor=1
    fallos = test.fails
    frase = "Anita lava la tina"
    test_resul = terminan_con_wd(frase)
    try:
        resul = terminan_con(frase)
        test.print_test(s, test_resul==resul)
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0        

def ejercicio2_test3():
    s="Compruebo con una frase de palabras repetidas, las tiene que agregar siempre"
    valor=1
    fallos = test.fails
    frase = "turu turu turu turu holi tuuu turu tuu turu su su su su susana"
    test_resul = terminan_con_wd(frase)
    try:
        resul = terminan_con(frase)
        test.print_test(s, test_resul==resul)
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0        
    
def ejercicio3_test1():
    s = "Extiendo dos listas cortas"
    valor = 1
    fallos = test.fails
    linked1 = LinkedList()
    linked2 = LinkedList()
    linked1.insertar_en_posicion(0,"a")
    linked1.insertar_en_posicion(1,"b")
    linked2.insertar_en_posicion(0,"c")
    linked2.insertar_en_posicion(1,"d")
    linked2.insertar_en_posicion(2,"e")
    funciono=True
    try:
        extend(linked1,linked2)
        l=["a","b","c","d","e"]
        actual=linked1.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next    
        test.print_test(s, funciono and check_list_integrity(linked1,linked1.len))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test2():
    s = "Extiendo una lista vacia con una con elementos"
    valor = 1
    fallos = test.fails
    linked1 = LinkedList()
    linked2 = LinkedList()
    linked2.insertar_en_posicion(0,"c")
    linked2.insertar_en_posicion(1,"d")
    linked2.insertar_en_posicion(2,"e")
    funciono=True
    try:
        extend(linked1,linked2)
        l=["c","d","e"]
        actual=linked1.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next    
        test.print_test(s, funciono and check_list_integrity(linked1,linked1.len))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0


def ejercicio3_test3():
    s = "Extiendo una lista vacia al final con una con elementos al principio"
    valor = 1
    fallos = test.fails
    linked1 = LinkedList()
    linked2 = LinkedList()
    linked1.insertar_en_posicion(0,"c")
    linked1.insertar_en_posicion(1,"d")
    linked1.insertar_en_posicion(2,"e")
    funciono=True
    try:
        extend(linked1,linked2)
        l=["c","d","e"]
        actual=linked1.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next    
        test.print_test(s, funciono and check_list_integrity(linked1,linked1.len))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0
def ejercicio3_test4():
    s = "Extiendo dos listas vacias"
    valor = 1
    fallos = test.fails
    linked1 = LinkedList()
    linked2 = LinkedList()
    funciono=True
    try:
        extend(linked1,linked2)
        l=[]
        actual=linked1.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next    
        test.print_test(s, funciono and check_list_integrity(linked1,linked1.len))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0
    
def ejercicio3_test5():
    s = "Extiendo dos listas muy grandes"
    valor = 1
    fallos = test.fails
    linked1 = LinkedList()
    linked2 = LinkedList()
    for i in range(1000):
        linked1.insertar_en_posicion(i,i)
        linked2.insertar_en_posicion(i,i+1000)
    funciono=True
    try:
        extend(linked1,linked2)
        l=list(range(1000*2))
        actual=linked1.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next    
        test.print_test(s, funciono and check_list_integrity(linked1,linked1.len))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0
    
def check_list_integrity(linked_list, length):
  current = linked_list.prim
  index = 0
  last_element = linked_list.ult
  while current:
    index += 1
    current = current.next
    if current is not None:
      last_element = current
  return length == index and (last_element is linked_list.ult)



def error_by_except(s,err):
        test.print_test(s, False)
        print("El test del punto lanzo la exception {}".format(err))
        traceback.print_exc()

def main():
    
    print("")
    print("Examen 3ero TIC 'D'- Python")
    print("")
    nota = 0 
    print("Ejercicio 1 - es_triang_superior (2 puntos)")
    nota += ejercicio1_test1()
    nota += ejercicio1_test2()
    nota += ejercicio1_test3()
    nota += ejercicio1_test4()
    
    
    print("")
    print("Ejercicio 2 - terminan_con (3 puntos)") 
 
    nota += ejercicio2_test1()
    nota += ejercicio2_test2()
    nota += ejercicio2_test3()

    print("")
    print("Ejercicio 3 - extend (5 puntos)")
   
    nota += ejercicio3_test1()
    nota += ejercicio3_test2()
    nota += ejercicio3_test3()
    nota += ejercicio3_test4()
    nota += ejercicio3_test5()
    
    
    print("--------------")
    print("FIN DEL EXAMEN")
    print("--------------")
    
    print("El resultado es ", nota)
    if(nota==10): print ("¡Felicitaciones!")
    
    if test.fails != 0:
        raise Exception("ERROR: Hubo fallos " + str(test.fails) + " en los asserts del TP. Revisar")

    return 

if __name__ == "__main__":
  main()