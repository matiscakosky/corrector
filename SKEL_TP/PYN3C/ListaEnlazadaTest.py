class Nodo:
    def __init__(self,dato=None,prox=None):
        self.v=dato
        self.next=prox
        
    def __str__(self):
        return str(self.v)


class ListaEnlazada:
    def __init__(self):
        self.ult = None
        self.prim = None
        self.len = 0
        
    def insertar_en_posicion(self, i, x):
        if i < 0 or i > self.len:
            raise IndexError("Posicion invalida")
        
        nuevo = Nodo(x)
        
        if self.len == 0:
            self.prim = nuevo
            self.ult = nuevo
            self.len += 1
            return
            
        if i == 0:
            nuevo.next = self.prim
            self.prim = nuevo

        else:
            n_ant = self.prim
            for pos in range(1, i):
                n_ant = n_ant.next
            nuevo.next = n_ant.next
            n_ant.next = nuevo
            if nuevo.next is None:
                self.ult = nuevo            
        
        self.len += 1