from tppy2_wd import *
from tppy2 import *
from testing import show_test
import random
import traceback
import sys
import math

test=show_test()


    
def ejercicio1_test1():
    s="La lista de primos hasta 0 es la lista vacia"
    test_resul=primos_well_done(0)
    try:
        resul = primos(0)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
        
    
def ejercicio1_test2():
    s="La lista de primos hasta 1 es la lista vacia"
    test_resul=primos_well_done(1)
    try:
        resul = primos(1)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)    
        

def ejercicio1_test3():
    s="La lista de primos hasta 2 contiene al primer numero primo, un unico elemento"
    test_resul=primos_well_done(2)
    try:
        resul = primos(2)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)

def ejercicio1_test4():
    s="La lista de primos hasta 3 comienza el caso general"
    test_resul=primos_well_done(3)
    try:
        resul = primos(3)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)
    
def ejercicio1_test5():
    s="Primos de un numero negativo devuelve la lista vacia "
    test_resul=primos_well_done(-1)
    try:
        resul = primos(-1)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)    
        
        
def ejercicio1_test6():
    s="Primos desde 2 hasta un numero no primo, tengo todos hasta el anterior"
    test_resul=primos_well_done(5500)
    try:
        resul = primos(5500)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)    
        
        
def ejercicio1_test7():
    s="Primos desde 2 hasta un numero primo, tengo todos"
    test_resul=primos_well_done(5483)
    try:
        resul = primos(5483)
        test.print_test(s,resul==test_resul)
                
    except Exception as err:
        error_by_except(s,err)    
    
        
def ejercicio1_test8():
    s="Dos listas obtenidas a partir de numeros diferentes son iguales debido a que los primos son los mismos"
    test_resul0=primos_well_done(103)
    test_resulf=primos_well_done(104)
    try:
        resul0 = primos(103)
        resulf = primos(104)
        test.print_test(s,resul0==test_resul0 and resulf==test_resulf)
                
    except Exception as err:
        error_by_except(s,err)     


        
        
def ejercicio2_test1():
    s="Compruebo una cadena de caracteres"
    cad = "hola"
    try:
        res= bin_to_dec(cad)
        test.print_test(s,res==-1)
    except Exception as err:
        error_by_except(s,err)
    

def ejercicio2_test2():
    s="Compruebo una cadena de caracteres en binario con un valor decimal"
    cad = "0101010120"
    try:
        res= bin_to_dec(cad)
        test.print_test(s,res==-1)
    except Exception as err:
        error_by_except(s,err)
        
def ejercicio2_test3():
    s="Compruebo todos los numeros en un rango de hasta 4 bits"
    print(s)
    fourbits = [1,2,4,8,16]
    try:
        actual = test.fails
        for i in range(17):
            binario = bin(i)[2:]
            resul = bin_to_dec(binario)
            if(i in fourbits):
                test.print_test("Comienza con " + str(len(binario)) + " bits convirtio todo bien hasta entonces",resul==int(binario,2))
            if(resul != int(binario,2)): actual+=1
        test.print_test(s,test.fails==actual)
            
            
    except Exception as err:
        error_by_except(s,err)
        
        
def ejercicio2_test4():
    s="Compruebo todos los numeros en un rango de grande de numeros"
    print(s)
    lista = [10,100,1000,5000,10000,100000]
    try:
        actual = test.fails
        for i in range(100001):
            binario = bin(i)[2:]
            resul = bin_to_dec(binario)
            if(i in lista):
                test.print_test("Todos los numeros hasta " + str(i) + " estan bien converidos" ,resul==int(binario,2))
            if(resul != int(binario,2)): actual+=1
        test.print_test(s,test.fails==actual)
            
            
    except Exception as err:
        error_by_except(s,err)
        

def ejercicio3_test1():
    s="Compruebo todos los numeros del complemento a2 entre -128 y 127"
    actual = test.fails
    print(s)
    try:
        for i in range(127,-129,-1):
            a2bin=dec_to_bin(i)
            a2bin_test=dec_to_bin_well_done(i)
            if(a2bin != a2bin_test): actual+=1
            if i in [-128,-16,0,16,127]:
                test.print_test("Los nuemeros son correctos hasta el " + str(i),test.fails==actual)
        test.print_test(s,test.fails==actual)    
    except Exception as err:
        error_by_except(s,err)
        
        
        
        
        
def ejercicio4_test1():
    s="Opero con la opcion 1 y cadena vacia"
    option=1
    test_string=""
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
        
def ejercicio4_test2():
    s="Opero con la opcion 1 y el ejemplo del enunciado"
    option=1
    test_string="computadora"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
def ejercicio4_test3():
    s="Opero con la opcion 1 y el ejemplo del enunciado con mayusculas"
    option=1
    test_string="ComPUtAdorA"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)

def ejercicio4_test4():
    s="Opero con la opcion 1 y el abecedario"
    option=1
    test_string="abcdefghijklmnopqrstuvwxyz"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)

def ejercicio4_test5():
    s="Opero con la opcion 1 y el abecedario con mayuscula entero"
    option=1
    test_string="ABCDEFGHIJKLMNOPRSTUVWXYZ"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        

def ejercicio4_test6():
    s="Opero con la opcion 1 y el abecedario con mayusculas intercaladas"
    option=1
    test_string="abCDEFghIKLmnOPrsTuVWxyZ"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio4_test7():
    s="Opero con la opcion 2 y cadena vacia"
    option=2
    test_string=""
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)    
        

def ejercicio4_test8():
    s="Opero con la opcion 2 y el ejemplo del enunciado"
    option=2
    test_string="computadora"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
    

def ejercicio4_test9():
    s="Opero con la opcion 2 y el ejemplo del enunciado con mayusculas"
    option=2
    test_string="ComPUtAdorA"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)


def ejercicio4_test10():
    s="Opero con la opcion 2 y el abecedario"
    option=2
    test_string="abcdefghijklmnopqrstuvwxyz"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)


def ejercicio4_test11():
    s="Opero con la opcion 2 y el abecedario con mayuscula entero"
    option=2
    test_string="ABCDEFGHIJKLMNOPRSTUVWXYZ"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
    
    
    
def ejercicio4_test12():
    s="Opero con la opcion 2 y el abecedario con mayusculas intercaladas"
    option=2
    test_string="abCDEFghIKLmnOPrsTuVWxyZ"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)


def ejercicio4_test13():
    s="Opero con la opcion 2 y el abecedario con solo las vocales"
    option=2
    test_string="aeiou"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)

def ejercicio4_test14():
    s="Opero con la opcion 1 y el abecedario con solo las vocales"
    option=1
    test_string="aeiou"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
def ejercicio4_test15():
    s="Opero con la opcion 3 y cadena vacia"
    option=3
    test_string=""
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
        
def ejercicio4_test16():
    s="Opero con la opcion 3 y el ejemplo del enunciado"
    option=3
    test_string="computadora"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
def ejercicio4_test17():
    s="Opero con la opcion 3 y el ejemplo del enunciado con mayusculas"
    option=3
    test_string="ComPutAdorA"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)

def ejercicio4_test18():
    s="Opero con la opcion 3 y el abecedario"
    option=3
    test_string="abcdefghijklmnopqrstuvwxyz"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        

def ejercicio4_test19():
    s="Opero con la opcion 3 y el abecedario con mayuscula entero"
    option=3
    test_string="ABCDEFGHIJKLMNOPRSTUVWXYZ"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        

def ejercicio4_test20():
    s="Opero con la opcion 3 y el abecedario con mayusculas intercaladas"
    option=3
    test_string="abCDEFghIKLmnOPrsTuVWxyZ"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio4_test21():
    s="Opero con la opcion 3 y el abecedario con solo las vocales"
    option=3
    test_string="aeiou"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio4_test22():
    s="Opero con la opcion 1 y una frase con puntos y espacios"
    option=1
    test_string="Ser... o no ser... esa es la cuestion"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)

        
def ejercicio4_test23():
    s="Opero con la opcion 2 y una frase con puntos y espacios"
    option=2
    test_string="Ser... o no ser... esa es la cuestion"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
def ejercicio4_test24():
    s="Opero con la opcion 3 y una fase con puntos y espacios"
    option=3
    test_string="Ser... o no ser... esa es la cuestion1"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
def ejercicio4_test25():
    s="Opero con la opcion 4 y una palabra palindroma"
    option=4
    test_string="neuquen"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
def ejercicio4_test26():
    s="Opero con la opcion 4 y una palabra no palindroma"
    option=4
    test_string="ezequiel"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
def ejercicio4_test27():
    s="Opero con la opcion 4 y una palabra palindroma que mezcla mayusculas y minusculas"
    option=4
    test_string="mEneM"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio4_test28():
    s="Opero con la opcion 4 y la frase palindroma del enunciado"
    option=4
    test_string="anita lava la tina"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
def ejercicio4_test29():
    s="Opero con la opcion 4 y otra frase palindroma "
    option=4
    test_string="quinto tic programacion noicamargorp cit otn iuq"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
    except Exception as err:    
        error_by_except(s,err)
        
        
        
def ejercicio4_test30():
    s="Opero con la opcion 4 y frase palindroma que alterna mayusculas con minusculas"
    option=4
    test_string="Quinto tiC programacion noicamargorP cit otn iuq"
    operated_test = operate_string_well_done(option,test_string)
    try:
        operated = operate_string(option,test_string)
        test.print_test(s,operated_test==operated)
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
    ejercicio1_test8()
    print("")
    print("Ejercicio 2") 
 
    ejercicio2_test1()
    ejercicio2_test2()
    ejercicio2_test3()
    ejercicio2_test4()  
    print("")
    print("Ejercicio 3")
   
    
    ejercicio3_test1()
    
    print("")
    print("Ejercicio 4")    
    
    
    
    ejercicio4_test1()
    ejercicio4_test2()
    ejercicio4_test3()
    ejercicio4_test4()
    ejercicio4_test5()
    ejercicio4_test6()
    ejercicio4_test14()
    ejercicio4_test7()
    ejercicio4_test8()
    ejercicio4_test9()
    ejercicio4_test10() 
    ejercicio4_test11() 
    ejercicio4_test12() 
    ejercicio4_test13()
    ejercicio4_test15()
    ejercicio4_test16()
    ejercicio4_test17()
    ejercicio4_test18()
    ejercicio4_test19()
    ejercicio4_test20()
    ejercicio4_test21()
    ejercicio4_test22()
    ejercicio4_test23()
    ejercicio4_test24()
    ejercicio4_test25()
    ejercicio4_test26() 
    ejercicio4_test27() 
    ejercicio4_test28() 
    ejercicio4_test29()
    ejercicio4_test30()
    
    
    
        
    if test.fails != 0:
        raise Exception("ERROR: Hubo fallos " + str(test.fails) + " en los asserts del TP. Revisar")

    return 


if __name__ == "__main__":
  main()