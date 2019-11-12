from py3c import *
from py3c_wd import *
from testing import show_test
from ListaEnlazadaTest import Nodo as Nodo
from ListaEnlazadaTest import ListaEnlazada as LinkedList
import traceback
import random


test=show_test()

def ejercicio1_test1():
    s="Valido una password bien"
    fallos = test.fails
    valor=.5
    contra = "pikachu!#"
    try:
        test.print_test(s, validar("mati","scako",contra))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
        
    
def ejercicio1_test2():    
    s="Valido una password que no cumple con los largos"
    fallos = test.fails
    valor=.5
    try:
        test.print_test(s, not validar("mati","scako","ho"))
        test.print_test(s, not validar("mati","scako","holiiiiiiiiiiiiiiiiiiiiiiiiii"))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
        

def ejercicio1_test3():
    s="Valido una password que tiene el nombre o apellido del usuario"
    fallos = test.fails
    valor=.5
    try:
        test.print_test(s, not validar("mati","scako","aficomati123"))
        test.print_test(s, not validar("mati","scako","ascakos"))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
           

def ejercicio1_test4():
    s="Prueba de cambio de password"
    fallos = test.fails
    valor=.5
    try:
        test.print_test(s, validar("mati","scako","holachau!2015")and not validar("mati","scako","hola qwert"))

        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0
    
def ejercicio2_test1():
    s="Pruebo 3 amigos con mucha disponibidad"
    valor=1
    fallos = test.fails
    dic = {"matias":[2],"cacho":[3,4],"fede":[30]}
    test_resul=organizar_wd(dic)
    try:
        resul=organizar(dic)
        test.print_test(s, test_resul==resul)
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0

def ejercicio2_test2():
    s="Pruebo 5 amigos que entre todos no pueden los dias pares y repetidos"
    valor=1
    fallos = test.fails
    dic = {"matias":[2,4,6,8,10],"cacho":[8,12,14,16,18,20],"fede":[10,22,24,26],"eze":[2,28],"fabio":[6,8,2,18,30]}
    test_resul=organizar_wd(dic)
    try:
        resul=organizar(dic)
        test.print_test(s, test_resul==resul)
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0

        
def ejercicio2_test3():
    s="Pruebo muchos amigos que no se pueden juntar todos nunca"
    valor=1
    fallos = test.fails
    dic = {"matias":[2,4,6,8,10],"cacho":[8,12,14,16,18,20],"fede":[10,22,24,26],"eze":[2,28],"fabio":[6,8,2,18,30],"ana":list(range(1,16,2)),"sol":list(range(17,30,2))}
    test_resul=organizar_wd(dic)
    try:
        resul=organizar(dic)
        test.print_test(s, test_resul==resul)
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0

    
def ejercicio3_test1():
    s = "Invierto la lista de dos elementos"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    largo=2
    try:
        invertir(linked)
        test.print_test(s, linked.prim.v == "b" and linked.ult.v == "a" and check_list_integrity(linked,largo))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test2():
    s = "Invierto una lista de cinco elementos, creados a partir de nodos"
    valor = 1
    largo=5
    fallos = test.fails
    n5=Nodo("Banana",None)
    n4=Nodo("Manzana",n5)
    n3=Nodo("Durazno",n4)
    n2=Nodo("Coco",n3)
    n1=Nodo("Uva",n2)
    le = LinkedList()
    le.ult=n5
    le.prim=n1
    le.len=largo
    try:
        invertir(le)
        final=["Banana","Manzana","Durazno","Coco","Uva"]
        actual=le.prim
        funciono = True
        for i in range(largo):
            if (actual.v!=final[i]): funciono=False
            actual=actual.next
        test.print_test(s, funciono and check_list_integrity(le,largo))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test3():
    s = "Pruebo invertir una lista grande de elementos"
    valor = 1
    largo = 101
    fallos = test.fails
    linked = LinkedList()
    for i in range(largo):
        linked.insertar_en_posicion(i,i*2)
    funciono=True
    final=list(range(200,-1,-2))
    try:
        invertir(linked)
        actual=linked.prim
        for i in range(largo):
            if actual.v != final[i]: funciono=False
            actual=actual.next
        
        test.print_test(s, funciono and check_list_integrity(linked,len(final)))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test4():
    s = "Invierto la lista de un elemento"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    largo=1
    try:
        invertir(linked)
        test.print_test(s, linked.prim.v == "a" and linked.ult.v == "a" and check_list_integrity(linked,largo))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test5():
    s = "Invierto la lista de tres elementos"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    largo=3
    try:
        invertir(linked)
        test.print_test(s, linked.prim.v == "c" and linked.ult.v == "a" and check_list_integrity(linked,largo))
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
    print("Examen 3ero TIC 'C'- Python")
    print("")
    nota = 0 
    print("Ejercicio 1 - validar (2 puntos)")
    nota += ejercicio1_test1()
    nota += ejercicio1_test2()
    nota += ejercicio1_test3()
    nota += ejercicio1_test4()
    
    
    print("")
    print("Ejercicio 2 - organizar (3 puntos)") 
 
    nota += ejercicio2_test1()
    nota += ejercicio2_test2()
    nota += ejercicio2_test3()

    print("")
    print("Ejercicio 3 - invertir (5 puntos)")
   
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