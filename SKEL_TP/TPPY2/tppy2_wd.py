from math import sqrt


def es_primo(n):
    for i in range(2,int(n**0.5)+1):
        if n%i == 0:
            return False
    return True
        

def primos_well_done(n):
    return [i for i in range(2,n+1) if es_primo(i)]

    
def bin_to_dec_well_done(s):
    dec=0
    s=s[::-1]
    for i in range(len(s)):
        if (not (s[i] == "1" or s[i] == "0")): return -1
        if (s[i]=="1"):
            dec += 2**i
    return dec

def bin_positive_rotated(n):
    """Devuele una lista rotada con cada elemento, una numero binario que representa al numeo n"""
    l=[0]*8
    for i in range(7,-1,-1):
        if (n-(2**i)>=0):
            n-=(2**i)
            l[i]="1"
        else:
            l[i]="0"
    return l


def deny_bit(b):
    return "0" if b=="1" else "1"

def deny(l):
    return list(map(deny_bit,l))

def sumar_1(l):
    for i in range(len(l)):
        if l[i]=="0":
            l[i]="1"
            return
        else:
            l[i]="0"

def dec_to_bin_well_done(n):
    l= bin_positive_rotated(abs(n))    
    if(n<0):
        l=deny(l)
        sumar_1(l)
    return "".join(l[::-1])
         


   
def operate_string_well_done(orden,cadena):
    vocales="aeiou"
    abc="abcdefghijklmnopqrstuvwxyz"
    cadena=cadena.lower()
    if (orden not in range(1,5)): return "order not found"
    if(orden==2):
        s=""
        for l in cadena:
            if l in vocales or (l not in abc):
                s+=l
        return s
    
    if(orden==1):
        s=""
        for l in cadena:
            if not l in vocales:
                s+=l
        return s
   
    if(orden==3):
        s=""
        for l in cadena:
            if l in vocales:
                s+=vocales[(vocales.index(l)+1)%len(vocales)]
            else:
                s+=l
        return s
    if (orden == 4):
        lista=cadena.split()
        sin_espacios="".join(lista)
        return sin_espacios==sin_espacios[::-1]
    
    
            
    
    
    
    
    