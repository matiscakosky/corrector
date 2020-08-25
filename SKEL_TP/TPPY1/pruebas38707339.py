import tppy1
from tppy1 import *
from testing import show_test
import random
import traceback
import sys
import math

test=show_test()


    
def ejercicio1_test1():
    s="Compruebo convert_timestamp_to_seg solo con una hora"
    test_resul=1*3600
    try:
        resul = convert_timestamp_to_seg(1,0,0)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
        
    
def ejercicio1_test2():
    s="Compruebo convert_timestamp_to_seg solo con minutos"
    test_resul=5*60
    try:
        resul = convert_timestamp_to_seg(0,5,0)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
        
        

def ejercicio1_test3():
    s="Compruebo convert_timestamp_to_seg solo con segundps"
    test_resul=30
    try:
        resul = convert_timestamp_to_seg(0,0,30)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
        

def ejercicio1_test4():
    s="Compruebo convert_timestamp_to_seg solo con horas negativas"
    test_resul=abs(-1)*3600
    try:
        resul = convert_timestamp_to_seg(-1,0,0)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
    
    
def ejercicio1_test5():
    s="Compruebo convert_timestamp_to_seg solo con minutos negativos"
    test_resul=abs(-1)*60
    try:
        resul = convert_timestamp_to_seg(0,-1,0)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
        
        
        
def ejercicio1_test6():
    s="Compruebo convert_timestamp_to_seg solo con segundos negativos"
    test_resul=abs(-1)
    try:
        resul = convert_timestamp_to_seg(0,0,-1)
        test.print_test(s,resul==test_resul)
        
    except Exception as err:
        error_by_except(s,err)
        
        
        
def ejercicio1_test7():
    s="Combino diferentes horas minutos y segundos. Todos positivos"
    test_resul=10*3600 + 40*60 + 12
    try:
        resul = convert_timestamp_to_seg(10,40,12)
        test.print_test(s,resul==test_resul)
        
    except Exception as err:
        error_by_except(s,err)
        
    
        
def ejercicio1_test8():
    s="Combino diferentes horas minutos y segundos. Todos negativos"
    test_resul=abs(-5)*3600 + abs(-70)*60 + abs(-4)
    try:
        resul = convert_timestamp_to_seg(-5,-70,-4)
        test.print_test(s,resul==test_resul)
        
    except Exception as err:
        error_by_except(s,err)
        


def ejercicio1_test9():
    s="Combino diferentes horas minutos y segundos. Alterno positivos y negativos"
    test_resul=abs(-5)*3600 + abs(80)*60 + abs(-4)
    try:
        resul = convert_timestamp_to_seg(-5,80,-4)
        test.print_test(s,resul==test_resul)
        
    except Exception as err:
        error_by_except(s,err)
        
    

def ejercicio1_test10():
    s="Tomo 3 numeros al azar alternados positivo y negativo, los paso a la funcion y responde"
    hour=random.randint(-50,50)
    mi=random.randint(-50,50)
    seg=random.randint(-50,50)


    test_resul=abs(hour)*3600 + abs(mi)*60 + abs(seg)
    try:
        resul = convert_timestamp_to_seg(hour,mi,seg)
        test.print_test(s,resul==test_resul)
        
    except Exception as err:
        error_by_except(s,err)
        
        
def ejercicio2_test1():
    s="Compruebo una cantidad de horas exactas"
    hours_resul=3
    min_resul=0
    seg_resul=0
    try:
        h,m,se = convert_seg_to_timestamp(10800)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)
    

def ejercicio2_test2():
    s="Compruebo una cantidad de minutos exactos"
    hours_resul=0
    min_resul=5
    seg_resul=0
    try:
        h,m,se = convert_seg_to_timestamp(300)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)

def ejercicio2_test3():
    s="Compruebo una cantidad de segundos exactos"
    hours_resul=0
    min_resul=0
    seg_resul=10
    try:
        h,m,se = convert_seg_to_timestamp(10)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)
        
        
def ejercicio2_test4():
    s="Compruebo el caso borde de segundos a minutos"
    fails_up_moment = test.fails
    try:
        hours_resul=0
        min_resul=0
        seg_resul=59
    
        h,m,se = convert_seg_to_timestamp(59)
        test.print_test("Comienzo con 59 segundos antes de sumar 1",hours_resul==h and min_resul == m and seg_resul == se)
    
        hours_resul=0
        min_resul=1
        seg_resul=0
    
        h,m,se = convert_seg_to_timestamp(60)
        test.print_test("Agrego 1 segundo, se convierte en un minuto",hours_resul==h and min_resul == m and seg_resul == se)
    
    
        hours_resul=0
        min_resul=1
        seg_resul=1
    
        h,m,se = convert_seg_to_timestamp(61)
        test.print_test("Agrego 1 segundo, se convierte en un minuto y un segundo",hours_resul==h and min_resul == m and seg_resul == se)
    
        test.print_test(s,test.fails==fails_up_moment)
    
    except Exception as err:
        error_by_except(s,err)


def ejercicio2_test5():
    s="Compruebo el caso borde de minutos a horas"
    fails_up_moment = test.fails
    try:
        hours_resul=0
        min_resul=59
        seg_resul=59
    
        h,m,se = convert_seg_to_timestamp(3599)
        test.print_test("Comienzo con 59 minutos y 59 segundos antes de sumar 1 segudo",hours_resul==h and min_resul == m and seg_resul == se)
    
        hours_resul=1
        min_resul=0
        seg_resul=0
    
        h,m,se = convert_seg_to_timestamp(3600)
        test.print_test("Agrego 1 segundo, se convierte en una hora",hours_resul==h and min_resul == m and seg_resul == se)
    
    
        hours_resul=1
        min_resul=0
        seg_resul=1
    
        h,m,se = convert_seg_to_timestamp(3601)
        test.print_test("Agrego 1 segundo, se convierte en una hora y un segundo",hours_resul==h and min_resul == m and seg_resul == se)
    
        test.print_test(s,test.fails==fails_up_moment)
    
    except Exception as err:
        error_by_except(s,err)
        
        
def ejercicio2_test6():
    s="Compruebo una cantidad de horas exactas negativas"
    hours_resul=3
    min_resul=0
    seg_resul=0
    try:
        h,m,se = convert_seg_to_timestamp(-10800)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)
        
        
        
def ejercicio2_test6():
    s="Compruebo una cantidad de horas exactas negativas"
    hours_resul=3
    min_resul=0
    seg_resul=0
    try:
        h,m,se = convert_seg_to_timestamp(-10800)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)
        
        
        
        
def ejercicio2_test7():
    s="Compruebo una caso general cualquiera"
    hours_resul=247
    min_resul=53
    seg_resul=33
    try:
        h,m,se = convert_seg_to_timestamp(892413)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err) 
        
def ejercicio2_test8():
    s="Compruebo una caso de entero muy grande"
    hours_resul=6051313541171
    min_resul=37
    seg_resul=4
    try:
        h,m,se = convert_seg_to_timestamp(21784728748217824)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)
        
def ejercicio2_test9():
    s="Compruebo el caso trivial"
    hours_resul=0
    min_resul=0
    seg_resul=0
    try:
        h,m,se = convert_seg_to_timestamp(0)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)
        
def ejercicio2_test10():
    s="Compruebo que la composicion de funciones convert_timestamp_to_seg convert_seg_to_timestamp resulta la funcion identidad"
    hours_resul=277
    min_resul= 25
    seg_resul=55
    _seg = convert_timestamp_to_seg(hours_resul,min_resul,seg_resul)
    try:
        h,m,se = convert_seg_to_timestamp(_seg)
        test.print_test(s,hours_resul==h and min_resul == m and seg_resul == se)
    except Exception as err:
        error_by_except(s,err)
        
        

def ejercicio3_test1():
    s="Compruebo el triangular de 0"
    try:
        triangs = triangular_numbers(0)
        triang_test=[]
        test.print_test(s,triang_test==triangs)
    except Exception as err:
        error_by_except(s,err)
        
        
        
        
        
def ejercicio3_test2():
    s="Compruebo el triangular del ejemplo de la consigna"
    try:
        triangs = triangular_numbers(5)
        triang_test=[1,3,6,10,15]
        test.print_test(s,triang_test==triangs)
    except Exception as err:
        error_by_except(s,err)
    
def ejercicio3_test3():
    s="Compruebo la lista del triangular de 50"
    num=50
    triang_test=triangular_well_done(num)
    try:
        triangs = triangular_numbers(num)
        test.print_test(s,triang_test==triangs)
    except Exception as err:
        error_by_except(s,err)


def ejercicio3_test4():
    s="Compruebo la lista del triangular de un numero negativo"
    num=-1
    triang_test=triangular_well_done(num)
    try:
        triangs = triangular_numbers(num)
        test.print_test(s,triang_test==triangs)
    except Exception as err:
        error_by_except(s,err)

def ejercicio3_test5():
    s="Compruebo la lista del triangular de un numero grande"
    num=1000
    triang_test=triangular_well_done(num)
    try:
        triangs = triangular_numbers(num)
        test.print_test(s,triang_test==triangs)
    except Exception as err:
        error_by_except(s,err)
        
        
        
def ejercicio4_test1():
    s="Busco los pares entre 0 y 1, es una lista de un solo elemento "
    a=0
    b=1
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
        
def ejercicio4_test2():
    s="Busco los pares entre entre dos numeros positivos de par a par"
    a=2
    b=20
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)


def ejercicio4_test3():
    s="Busco los pares entre entre dos numeros positivos de par a impar"
    a=8
    b=314
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)



def ejercicio4_test4():
    s="Busco los pares entre entre dos numeros positivos de impar a par"
    a=9
    b=100
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)


def ejercicio4_test5():
    s="Busco los pares entre entre dos numeros positivos de impar a impar"
    a=7
    b=51
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)
        
        

def ejercicio4_test6():
    s="Busco los pares entre entre dos numeros negativos de par a par"
    a=-20
    b=-2
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
        
def ejercicio4_test7():
    s="Busco los pares entre entre dos numeros negativos de impar a par"
    a=-717
    b=-618
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)
        
        

def ejercicio4_test8():
    s="Busco los pares entre entre dos numeros negativos de par a impar"
    a=-108
    b=-99
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)        


def ejercicio4_test9():
    s="Busco los pares entre entre dos numeros negativos de impar a impar"
    a=-107
    b=-99
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)        


def ejercicio4_test10():
    s="Busco los pares entre entre el caso que |b|<|a|"
    a=1000
    b=100
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)        


def ejercicio4_test11():
    s="Busco los pares entre entre el caso que |b|=|a| par"
    a=1000
    b=1000
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)
    
    
    
def ejercicio4_test12():
    s="Busco los pares entre entre el caso que |b|=|a| impar"
    a=1
    b=1
    even_test=even_numbers_between_well_done(a,b)
    try:
        even = even_numbers_between(a,b)
        test.print_test(s,even_test==even)
    except Exception as err:    
        error_by_except(s,err)
        
        
def ejercicio5_test1():
    s="Factorial de 0"
    fact_test=1
    try:
        fact = tppy1.factorial(0)
        test.print_test(s,fact_test==fact)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio5_test2():
    s="Factorial de 1"
    fact_test=1
    try:
        fact = tppy1.factorial(1)
        test.print_test(s,fact_test==fact)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
        
def ejercicio5_test3():
    s="Factorial de numero positivo chico"
    num=5
    fact_test=5*4*3*2*1
    try:
        fact = tppy1.factorial(num)
        test.print_test(s,fact_test==fact)
    except Exception as err:    
        error_by_except(s,err)
    
        
def ejercicio5_test4():
    s="Factorial de numero positivo medio"
    num=10
    fact_test=3628800
    try:
        fact = tppy1.factorial(num)
        test.print_test(s,fact_test==fact)
    except Exception as err:    
        error_by_except(s,err)
    
        
def ejercicio5_test5():
    s="Factorial de numero positivo medio"
    num=10
    fact_test=3628800
    try:
        fact = tppy1.factorial(num)
        test.print_test(s,fact_test==fact)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio5_test6():
    s="Factorial de numero positivo alto"
    num=50
    fact_test=math.factorial(num)
    try:
        fact = tppy1.factorial(num)
        test.print_test(s,fact_test==fact)
    except Exception as err:    
        error_by_except(s,err)
        
        
def even_numbers_between_well_done(a,b):
    return list(range(a+a%2,b+1,2))

def triangular_well_done(n):
    aux=0
    l=[]
    for i in range(1,n+1):
        aux+=i
        l.append(aux)
    return l

        

def error_by_except(s,err):
        test.print_test(s, False)
        print("El test del punto lanzo la exception {}".format(err))
        traceback.print_exc()

def main():
    
    print("")
    print("Trabajo practico 1 - Python")
    print("")
    
    print("Ejercicio 1")
    
    ejercicio1_test1()
    ejercicio1_test2()
    ejercicio1_test3()
    ejercicio1_test4()
    ejercicio1_test5()
    ejercicio1_test6()
    ejercicio1_test7()
    ejercicio1_test8()
    ejercicio1_test9()
    ejercicio1_test10()
    print("")
    print("Ejercicio 2") 
 
    ejercicio2_test1()
    ejercicio2_test2()
    ejercicio2_test3()
    ejercicio2_test4()
    ejercicio2_test5()
    ejercicio2_test6()
    ejercicio2_test7()
    ejercicio2_test8()
    ejercicio2_test9()
    ejercicio2_test10()  
    print("")
    print("Ejercicio 3")
   
    
    ejercicio3_test1()
    ejercicio3_test2()
    ejercicio3_test3()
    ejercicio3_test4()
    ejercicio3_test5()
    
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
    ejercicio4_test10() 
    ejercicio4_test11() 
    ejercicio4_test12() 
    
    print("")
    print("Ejercicio 5")   
    
    ejercicio5_test1()
    ejercicio5_test2()
    ejercicio5_test3()
    ejercicio5_test4()
    ejercicio5_test5()
    ejercicio5_test6()
    
    
        
    if test.fails != 0:
        raise ValueError("ERROR: Hubo fallos " + str(test.fails) + " en los asserts del TP. Revisar")

    return 


if __name__ == "__main__":
  main()


