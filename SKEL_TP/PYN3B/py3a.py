# -*- coding: utf-8 -*-
"""
Editor de Spyder

Este es un archivo temporal.
"""

from ListaEnlazadaTest import * 

#def ordenar(L):
    
    
#def swap(L,i1,i2):
"""   tmp = L[i1]
    "L[i1] = L[i2]
    "L[i2] = tmp"""

def duplicar(self,elemento):
    actual=self.prim
    while actual:
        if elemento == actual.v:
            nuevitoNodo = Nodo(elemento,actual.next)
            actual.next = nuevitoNodo
            actual = actual.next.next
            self.len += 1
            
            if(nuevitoNodo.next is None):
                self.ult = actual
                return
        else:
        actual = actual.next
    
            
        
