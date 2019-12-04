from ListaEnlazadaTest import *

def organizar_wd(dic):
    pueden = [1]*31
    dias_inhabiles = dic.values()
    for lista in dias_inhabiles:
        for dia in lista:
            pueden[dia]=0
    final=[]
    for i in range(1,len(pueden)):
        if pueden[i]: final.append(i)
    return final

def ordenar_wd(l):
    for j in range(len(l)):
        i = l[j:].index(min(l[j:]))
        swap(l,i+j,j)
        
def duplicar_wd(self,elem):
    if(self.len==0):
        return
    
    actual= self.prim
    while(actual):
        if actual.v==elem:
            n = Nodo(elem,actual.next)
            actual.next=n
            actual=n.next
            self.len += 1
            if n.next is None:
                self.ult=n
                return
        actual=actual.next
            
                  
        
        
        
        
def swap(L,i1,i2):
    """ Esta función intercambia dos valores dentro de una lista de Python. Recibe la lista y dos índices e intercambia los valores de las posiciones i1 e i2, modificando la lista que llega por parámetro.
    Pre-condiciones: La lista no está vacía y los índices i1 e i2 son validos
    Post-condiciones: Se modifica la lista L """
    tmp = L[i1]
    L[i1] = L[i2]
    L[i2] = tmp