from py3b import *
from py3b_wd import *
from testing import show_test
from ListaEnlazadaTest import Nodo as Nodo
from ListaEnlazadaTest import ListaEnlazada as LinkedList
import traceback
import random


test=show_test()

def ejercicio1_test1():
    s="Pruebo una matriz diagonal de 2x2"
    fallos = test.fails
    valor=.5
    m1=[[-1,0],[0,3]]
    try:
        test.print_test(s, es_matriz_diagonal(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
        
    
def ejercicio1_test2():    
    s="Pruebo una matriz diagonal de 3x3"
    fallos = test.fails
    valor=.5
    m1=[[21,0,0],[0,24,0],[0,0,25]]
    try:
        test.print_test(s, es_matriz_diagonal(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
        

def ejercicio1_test3():
    s="Pruebo una matriz no diagonal de 3x3"
    fallos = test.fails
    valor=.5
    m1=[[21,0,0],[0,24,0],[0,1,25]]
    try:
        test.print_test(s, False == es_matriz_diagonal(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
           

def ejercicio1_test4():
    s="Pruebo una matriz no diagonal de 2x2"
    fallos = test.fails
    valor=.5
    m1=[[-1,0],[1,3]]
    try:
        test.print_test(s, False == es_matriz_diagonal(m1))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
    
def ejercicio2_test1():
    s="Compruebo el diccionario con una frase de una sola palabra"
    valor=1
    fallos = test.fails
    frase = "Hola"
    test_resul = empiezan_con_wd(frase)
    try:
        resul = empiezan_con(frase)
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
    test_resul = empiezan_con_wd(frase)
    try:
        resul = empiezan_con(frase)
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
    test_resul = empiezan_con_wd(frase)
    try:
        resul = empiezan_con(frase)
        test.print_test(s, test_resul==resul)
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0        

def no(a):
    return False
def si(a):
    return True
def no_e(letra):
    return letra in "abcd"
    
def ejercicio3_test1():
    s = "Filtro un solo elemento, dejo la lista vacia"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    try:
        nueva=filtrar(linked,no)
        test.print_test(s, nueva.prim is None and check_list_integrity(nueva,0))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test2():
    s = "Creo una lista chica y filtro todos sus elementos"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"e")
    try:
        nueva=filtrar(linked,no)
        test.print_test(s, nueva.prim is None and check_list_integrity(nueva,0))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test3():
    s = "Creo una lista chica y el resultado del filtro es la misma lista"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"e")
    funciono=True
    try:
        nueva=filtrar(linked,si)
        l=["a","b","c","d","e"]
        actual=nueva.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next
        
        test.print_test(s, funciono and check_list_integrity(nueva,len(l)))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test4():
    s = "Creo una lista chica y filtro el ultimo elemento"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"e")
    funciono=True
    try:
        nueva=filtrar(linked,no_e)
        l=["a","b","c","d"]
        actual=nueva.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next
        
        test.print_test(s, funciono and check_list_integrity(nueva,len(l)))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test5():
    s = "Creo una lista chica y filtro el primer elemento"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"e")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"a")
    funciono=True
    try:
        nueva=filtrar(linked,no_e)
        l=["b","c","d","a"]
        actual=nueva.prim
        for i in range(len(l)):
            if actual.v != l[i]: funciono=False
            actual=actual.next
        
        test.print_test(s, funciono and check_list_integrity(nueva,len(l)))
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
    print("Examen 3ero TIC 'B'- Python")
    print("")
    nota = 0 
    print("Ejercicio 1 - matriz_diagonal (2 puntos)")
    nota += ejercicio1_test1()
    nota += ejercicio1_test2()
    nota += ejercicio1_test3()
    nota += ejercicio1_test4()
    
    
    print("")
    print("Ejercicio 2 - empiezan_con (3 puntos)") 
 
    nota += ejercicio2_test1()
    nota += ejercicio2_test2()
    nota += ejercicio2_test3()

    print("")
    print("Ejercicio 3 - filtrar (5 puntos)")
   
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