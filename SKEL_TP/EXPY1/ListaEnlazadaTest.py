class Nodo:
    def __init__(self,dato=None,prox=None):
        self.dato=dato
        self.prox=prox
        
    def __str__(self):
        return str(self.dato)


class ListaEnlazada:
    def __init__(self):
        """Crea una lista enlazada vacía."""
        self.prim = None
        self.len = 0
        
    def insertar_en_posicion(self, i, x):
        if i < 0 or i > self.len:
            raise IndexError("Posición inválida")
        
        nuevo = Nodo(x)
        
        if i == 0:
            # Caso particular: insertar al principio
            nuevo.prox = self.prim
            self.prim = nuevo
        else:
            # Buscar el nodo anterior a la posición deseada
            n_ant = self.prim
            for pos in range(1, i):
                n_ant = n_ant.prox
        
            # Intercalar el nuevo nodo
            nuevo.prox = n_ant.prox
            n_ant.prox = nuevo
        
        self.len += 1