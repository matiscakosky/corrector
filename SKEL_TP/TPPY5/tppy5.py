class Nodo:
    def __init__ (self, _value, _next = None, _last = None):
        self.v = _value
        self.next = _next
        self.last = _last

class ListaEnlazada:
    def __init__ (self):
        self.len = 0
        self.ult = None
        self.prim = None

    def pop(self, index = None):
        if self.len == 0:               # Si no hay nada para remover
            raise IndexError('Index out of range')

        if index == None:               # Si es none, borro el ultimo
            tempret = self.ult          # Agarro el ultimo nodo para devolverlo
            if not(self.ult.last == None):
                self.ult.last.next = None # Pongo el puntero del anterior al ultimo en None
            self.ult = self.ult.last    # Pongo el ultimo puntero como su anterior
            self.len -= 1               # Le saco uno a Len
            print(self)
            return tempret.v

        if index > self.len:               # Me fijo que este en el rango
            raise IndexError('Index out of range')

        if index == self.len:       # Si es el ultimo, borro el ultimo
            tempret = self.ult          # Agarro el ultimo nodo para devolverlo
            if not(self.ult.last == None):
                self.ult.last.next = None # Pongo el puntero del anterior al ultimo en None
            self.ult = self.ult.last    # Pongo el ultimo puntero como su anterior
            self.len -= 1               # Le saco uno a Len
            return tempret.v

        if index == 0:                  # Si es cero, borro el primero
            tempret = self.prim         # Agarro el primer nodo para devolverlo
            self.prim = self.prim.next  # Hago que primero sea el siguiente
            if not(self.len == 1):
                self.prim.last = None       # Hago que el anterior al nuevo primero sea None
            self.len -= 1               # Le saco uno a Len
            return tempret.v

        # Else esta en el medio
        temp = self.prim
        for i in range(0, index):
            temp = temp.next            # Temp es igual a su siguiente

        tempret = temp                  # Agarro el nodo correspondiente para devolverlo
        tempNext = temp.next            # Agarro el nodo siguiente
        tempLast = temp.last            # Agarro el nodo anterior

        if not(tempLast == None):
            tempLast.next = tempNext    # El next del antrior va a ser igual tempnext
        if not(tempNext == None):
            tempNext.last = tempLast    # El last del siguiente va a ser igual a templast

        # Temp no apunte a nada
        temp.next = None
        temp.last = None

        self.len -= 1                   # Le saco uno a Len
        return tempret.v

    def insert(self, index, elem):
        if index > self.len + 1:        # Me fijo que este en el rango
            raise IndexError('Index out of range')
        if index < 0:                   # Solo valores posivivos admitidos
            raise IndexError('Index out of range')

        if index == 0:
            nodo = Nodo(elem)           # Creo el nodo
            if not(self.len == 0):      # Si el len de la lista no es cero
                self.prim.last = nodo   # Pongo que el primero apunte a nodo
                nodo.next = self.prim   # Pongo que el next de nodo sea el primero
            self.prim = nodo            # Actualizo prim como nodo
            self.len += 1               # Le meto uno a Len
            return

        # Voy a donde tengo que insertar un elemento
        temp = self.prim
        for i in range(0, index - 1):
            temp = temp.next            # Temp es igual a su siguiente

        tempNext = temp.next            # Agarro el nodo siguiente
        nodo = Nodo(elem, tempNext, temp) # Creo el nodo de elem, con sus respectivos valores de cadena

        if index == self.len:           # Si el elemento es el ultimo,
            self.ult = nodo             # Lo actualizo
            temp.next = nodo            # Conecto el nodo anterior con el nuevo

        else:                           # Else
            temp.next = nodo            # Meto el elemento en el medio de
            tempNext.last = nodo        # temp y su siguiente

        self.len += 1                   # Le meto uno a Len
        return

    def index(self, elem):
        temp = self.prim
        for i in range(0, self.len):
            if temp.v == elem:
                return i           # Encontre, devuelvo en index
            temp = temp.next
        return                          # No encontre, no devuelvo nada

    def remove(self, elem):
        index = self.index(elem)       # Busco el index del elemento elem
        if index == None:               # Si no existe, no remuevo nada y tiro error
            raise ValueError()

        self.pop(index)                # Remuevo el elemento en el indice
        return

    def append(self, elem):
        nodo = Nodo(elem)               # Creo el nodo de elem
        if self.len == 0:               # Si no hay nada, meto elem como primero y ultimo
            self.prim = nodo
            self.ult = nodo
        else:
            self.ult.next = nodo        # Hago que el ultimo nodo apunte al nuevo nodo
            nodo.last = self.ult        # Pongo el last del nodo al ultimo
            self.ult = nodo             # Hago que ultimo apunte al nodo

        self.len += 1
        return

    def __len__(self):
        return self.len

    def __str__(self):
        temp = self.prim
        salida = []
        for i in range(0, self.len):
            if not(temp == None):
                salida.append(temp.v)
                temp = temp.next
        return str(salida)
