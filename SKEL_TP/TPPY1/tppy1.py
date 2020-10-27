def convert_timestamp_to_seg(h,m,s):
    segundos = abs(s)
    minutos = abs(m)
    horas = abs(h)   

    segundostotal = horas*60*60 + minutos*60 + segundos
    return segundostotal

def convert_seg_to_timestamp(s):
    s = abs(s)
    minutos = s//60
    segundos = s%60
    horas = 0
    
    if (minutos >=60):
        horas = minutos//60
        minutos = minutos%60
    
    total = (horas, minutos, segundos)
    return total

def triangular_numbers(n):
    contador = 0
    suma = 0
    lista = []
    while (contador <= n):
        suma = suma + contador
        lista.append(suma)
        contador = contador + 1
    return lista

def even_numbers_between(a,b):
    if (a==b):
        lista = [a, b]
    
    if (a < b):
        numero = a
        menos = b - 1
        lista = []
        if (a%2 == 0):
            lista = [a]
            while (numero < b and numero < menos):
                numero = numero + 2
                lista.append(numero)
                lista.sort()
            return lista

        if (a%2 < 0 or a%2 > 0):
            numero = numero - 1
            while (numero < b and numero < menos):
                numero = numero + 2
                lista.append(numero)
                lista.sort()
            return lista
    if (b < a):
        numero = b
        menos = a - 1
        lista = []
        if (b%2 == 0):
            lista = [a]
            while (numero < a and numero < menos):
                numero = numero + 2
                lista.append(numero)
                lista.sort()
            return lista

        if (b%2 < 0 or b%2 > 0):
            numero = numero - 1
            while (numero < a and numero < menos):
                numero = numero + 2
                lista.append(numero)
                lista.sort()
            return lista

def factorial(n):
    factorial = 1
    numero = 1
    while (numero <= n):
        factorial = factorial * numero
        numero = numero + 1
    return factorial

print (even_numbers_between(4,10))