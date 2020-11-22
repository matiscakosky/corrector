from py3a import *
from py3a_wd import *
from testing import show_test
from ListaEnlazadaTest import Nodo as Nodo
from ListaEnlazadaTest import ListaEnlazada as LinkedList
import traceback
import random


test=show_test()

def ejercicio1_test1():
    s="Ordeno una lista chiquita, la lista al final queda ordenada inplace"
    fallos = test.fails
    valor=.5
    l1=[1,214,41,415,6,467,764,246,4,7247,6,1356,764,84,-23,1]
    l2=[1,214,41,415,6,467,764,246,4,7247,6,1356,764,84,-23,1]
    try:
        ordenar(l1)
        test.print_test(s, l1==sorted(l2))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0


def ejercicio1_test2():
    s="Ordeno una lista chiquita, casi todos sus elementos estan repetidos"
    fallos = test.fails
    valor=.5
    l1=[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,-23,1]
    l2=[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,-23,1]
    try:
        ordenar(l1)
        test.print_test(s, l1==sorted(l2))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0


def ejercicio1_test3():
    s="Ordeno una lista de 100 elementos aleatorios entre -50000 y 50000"
    fallos = test.fails
    valor=.5
    l1=[]
    l2=[]
    for i in range(100):
        numero=random.randint(-50000,50000)
        l1.append(numero)
        l2.append(numero)
    try:
        ordenar(l1)
        test.print_test(s, l1==sorted(l2))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s,err)
        return 0


def ejercicio1_test4():
    s="Ordeno una lista de strings"
    valor=.5
    fallos = test.fails
    l1=["mati","hola","que","tal","como","va"]
    l2=["mati","hola","que","tal","como","va"]
    try:
        ordenar(l1)
        test.print_test(s, l1==sorted(l2))
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
    s = "Lista de un unico elemento, duplico ese"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,5)
    try:
        duplicar(linked,5)
        dato1 = linked.prim.v
        dato2 = linked.prim.next.v
        test.print_test(s, dato1 == dato2 and check_list_integrity(linked,2))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test2():
    s = "Creo una lista chica y duplico el elemento del medio"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"e")
    try:
        l=["a","b","c","c","d","e"]
        duplicar(linked,"c")
        actual=linked.prim
        for i in range(len(l)):
            if actual.v != l[i]: test.fails += 1
            actual=actual.next
        test.print_test(s, test.fails == fallos and check_list_integrity(linked,len(l)))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test3():
    s = "Creo una lista chica y duplico el elemento del principio"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"e")
    try:
        l=["a","a","b","c","d","e"]
        duplicar(linked,"a")
        actual=linked.prim
        for i in range(len(l)):
            if actual.v != l[i]: test.fails += 1
            actual=actual.next
        test.print_test(s, test.fails == fallos and check_list_integrity(linked,len(l)))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test4():
    s = "Creo una lista chica y duplico el elemento del final"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"a")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"e")
    try:
        l=["a","b","c","d","e","e"]
        duplicar(linked,"e")
        actual=linked.prim
        for i in range(len(l)):
            if actual.v != l[i]: test.fails += 1
            actual=actual.next
        test.print_test(s, test.fails == fallos and check_list_integrity(linked,len(l)))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0
def ejercicio3_test5():
    s = "Creo una lista chica y duplico el elemento del princiío y del final"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    linked.insertar_en_posicion(0,"e")
    linked.insertar_en_posicion(1,"b")
    linked.insertar_en_posicion(2,"c")
    linked.insertar_en_posicion(3,"d")
    linked.insertar_en_posicion(4,"e")
    try:
        l=["e","e","b","c","d","e","e"]
        duplicar(linked,"e")
        actual=linked.prim
        for i in range(len(l)):
            if actual.v != l[i]: test.fails += 1
            actual=actual.next
        test.print_test(s, test.fails == fallos and check_list_integrity(linked,len(l)))
        return valor if (test.fails == fallos) else 0
    except Exception as err:
        error_by_except(s, err)
        return 0

def ejercicio3_test5_aux():
    s = "Creo una lista con varios elementos y duplico los pares"
    valor = 1
    fallos = test.fails
    linked = LinkedList()
    for i in range(100):
        linked.insertar_en_posicion(i,i+1)
    l=[]
    for i in range(1,101):
        l.append(i)
        if(i%2==0): l.append(i)
    try:
        for i in range(2,100,2):
            duplicar(linked,i)
        actual=linked.prim
        for i in range(len(l)):
            if actual.v != l[i]: test.fails += 1
            actual=actual.next
        test.print_test(s, test.fails == fallos and check_list_integrity(linked,len(l)))
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
  return length == index

def error_by_except(s,err):
        test.print_test(s, False)
        print("El test del punto lanzo la exception {}".format(err))
        traceback.print_exc()

def main():

    print("")
    print("Examen 3ero TIC 'A'- Python")
    print("")
    nota = 0
    print("Ejercicio 1 - ordenar (2 puntos)")
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
    print("Ejercicio 3 - duplicar (5 puntos)")

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
