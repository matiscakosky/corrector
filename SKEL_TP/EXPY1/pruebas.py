from expy1 import *
from testing import show_test
import random
from ListaEnlazadaTest import ListaEnlazada
from ListaEnlazadaTest import Nodo
test=show_test()


    
def assert_ejercicio1_prueba1():
    try:
        print("Test 1: 1 punto")
        print("Compruebo que funcione para una playlist y una canccion")
        fallos = test.fails
        dicPlaylist = {"p1":["c1"]}
        dicCanciones = {"c1":60}
        resul=duraciones_playlist(dicCanciones, dicPlaylist)
        test.print_test("la playlist 1 tiene 60 segundos de duracion", resul["p1"]==60 and len(resul)==1)
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 1 {}".format(err))
        test.print_test("la playlist 1 tiene 60 segundos de duracion", False)
        return 0

def assert_ejercicio1_prueba2():
    try:
        print("Test 2: 1 punto")
        print("Compruebo que funcione para una playlist y varias cancciones")
        fallos = test.fails
        dicPlaylist = {"p1":["c1","c2","c3","c4"]}
        dicCanciones = {"c1":60,"c2":63,"c3":12,"c4":105}
        resul=duraciones_playlist(dicCanciones, dicPlaylist)
        test.print_test("la playlist 1 tiene 240 segundos de duracion", resul["p1"]==240 and len(resul)==1)
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 1 {}".format(err))
        test.print_test("la playlist 1 tiene 240 segundos de duracion", False)
        return 0

def assert_ejercicio1_prueba3():
    try:
        print("Test 3: 1 punto")
        print("Compruebo que funcione para varias playlist y varias cancciones")
        fallos = test.fails
        dicPlaylist = {"p1":["c1","c2","c3","c4"],"p2":["c4","c5","c6","c7"],"p3":["c1","c2","c5","c7"]}
        dicCanciones = {"c1":60,"c2":63,"c3":12,"c4":105,"c5":74,"c6":68,"c7":101}
        resul=duraciones_playlist(dicCanciones, dicPlaylist)
        test.print_test("Compruebo las duraciones de las playlist", resul["p1"]==240 and resul["p2"]==348 and resul["p3"]==298 and len(resul)==3)
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 1 {}".format(err))
        test.print_test("Compruebo las duraciones de las playlist", False)
        return 0

def assert_ejercicio2_prueba1():
    try:
        print("Test 4: 1 punto")
        print("Ordeno una lista chiquita")
        fallos = test.fails
        l1=[1,214,41,415,6,467,764,246,4,7247,6,1356,764,84,-23,1]
        l2=[1,214,41,415,6,467,764,246,4,7247,6,1356,764,84,-23,1]
        ordenar(l1)
        test.print_test("Las listas estan ordenadas iguales", l1==sorted(l2))
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 1 {}".format(err))
        test.print_test("Las listas estan ordenadas iguales", False)
        return 0

def assert_ejercicio2_prueba2():
    try:
        print("Test 5: 1 punto")
        print("Ordeno una lista mediana aleatoria")
        fallos = test.fails
        l1=[]
        l2=[]
        for i in range(100):
            numero=random.randint(-50000,50000)
            l1.append(numero)
            l2.append(numero)
        ordenar(l1)
        test.print_test("Compruebo que este ordenada la mediana", l1==sorted(l2))
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 2 {}".format(err))
        test.print_test("Compruebo que este ordenada la mediana", False)
        return 0
def assert_ejercicio2_prueba3():
    try:
        print("Test 6: 1 punto")
        print("Ordeno una lista gigante aleatoria")
        fallos = test.fails
        l1=[]
        l2=[]
        for i in range(10000):
            numero=random.randint(-50000,50000)
            l1.append(numero)
            l2.append(numero)
        ordenar(l1)
        test.print_test("Compruebo que este ordenada la grande", l1==sorted(l2))
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 2 {}".format(err))
        test.print_test("Compruebo que este ordenada la grande", False)
        return 0

def assert_ejercicio3_prueba1():
    try:
        print("Test 7: 1 puntos")
        print("Prueba de invertir una lista enlazada de 5 elementos")
        fallos = test.fails
        n5=Nodo("Banana",None)
        n4=Nodo("Manzana",n5)
        n3=Nodo("Durazno",n4)
        n2=Nodo("Coco",n3)
        n1=Nodo("Uva",n2)
        le = ListaEnlazada()
        le.prim=n1
        le.len=5
        invertir_lista(le)
        final=["Banana","Manzana","Durazno","Coco","Uva"]
        actual=le.prim
        for i in range(5):
            test.print_test("El elemento " + str(i) + " esta bien invertido",actual.dato==final[i])
            actual=actual.prox
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 3 {}".format(err))
        test.print_test("Compruebo que este invertida la lista de 5 elementos", False)
        return 0
def assert_ejercicio3_prueba2():
    try:
        print("Test 8: 2 puntos")
        print("Prueba de invertir una lista enlazada de 100 elementos")
        fallos = test.fails
        le = ListaEnlazada()
        for i in range(101):
            le.insertar_en_posicion(i,i*2)
        invertir_lista(le)
        final=list(range(200,0,-2))
        actual=le.prim
        for i in range(100):
            test.print_test("El elemento " + str(i) + " esta bien invertido",actual.dato==final[i])
            actual=actual.prox
        return 2 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 3 {}".format(err))
        test.print_test("Compruebo que este invertida la lista de 100 elementos", False)
        return 0
def assert_ejercicio3_prueba3():
    try:
        print("Test 9: 1 puntos")
        print("Prueba de invertir una lista enlazada de 1 elemento")
        fallos = test.fails
        n1=Nodo("Uva")
        le = ListaEnlazada()
        le.prim=n1
        le.len=1
        invertir_lista(le)
        actual=le.prim
        test.print_test("No se invierte la lista con un elemento",actual.dato=="Uva")
        return 1 if (test.fails == fallos) else 0
    except Exception as err:
        print("Fallo el test del punto 3 {}".format(err))
        test.print_test("Compruebo que este invertida la lista de un elemento", False)
        return 0        
    

def main():
    
    print("")
    print("Recuperatorio febrero - Examen de python ")
    print("")
    nota = 0
    
    print("Ejercicio 1")
    nota += assert_ejercicio1_prueba1()
    print("")
    nota += assert_ejercicio1_prueba2()
    print("")   
    nota += assert_ejercicio1_prueba3()
    print("")
    print("Ejercicio 2")    
    nota += assert_ejercicio2_prueba1()
    print("")   
    nota += assert_ejercicio2_prueba2()
    print("")
    nota += assert_ejercicio2_prueba3()
    print("")
    print("Ejercicio 3")
    nota += assert_ejercicio3_prueba1()
    print("")
    nota += assert_ejercicio3_prueba2()
    print("")
    nota += assert_ejercicio3_prueba3()
    
    print("--------------")
    print("FIN DEL EXAMEN")
    print("--------------")
    
    print("El resultado es ", nota)
    
    
    if test.fails != 0:
        raise ValueError("ERROR")

    return 


if __name__ == "__main__":
  main()


