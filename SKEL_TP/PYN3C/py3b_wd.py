from ListaEnlazadaTest import *


def es_matriz_diagonal_wd(m):
    for i in range(len(m)):
        for j in range(len(m)):
            if i!=j:
                if m[i][j] != 0:
                    return False
    return True

def empiezan_con_wd(s):
    s=s.lower()
    dic={}
    l = s.split()
    for palabra in l:
        lista_pal=dic.get(palabra[0],[])
        lista_pal.append(palabra)
        dic[palabra[0]]=lista_pal
    return dic


def filtrar_wd(self,f):
    new = ListaEnlazada()
    actual = self.prim
    while actual:
        if(f(actual.v)):
            n = Nodo(actual.v)
            if new.len == 0:
                new.prim=n
                new.ult=n
                new.len += 1
                actual=actual.next
                continue
            new.ult.next=n
            new.ult=n
            new.len += 1
        actual=actual.next
    return new
            
            
            