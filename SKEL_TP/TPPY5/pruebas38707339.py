from testing import show_test
import random
import traceback
import sys
import math
# from TPY import Node_wd, LinkedList_wd
# from TPPY5Test import Node, LinkedList
from tppy5 import Nodo as Node, ListaEnlazada as LinkedList


test=show_test()

errors = {
  "integrity": "No paso el test de integridad de la lista \n",
  "index": "No paso el test del index \n",
  "length": "No paso el test del length \n",
  "assert": "No paso el test del assert \n"
}

def error_by_except(s,err):
  test.print_test(s, False)
  print("El test del punto lanzo la exception {}".format(err))
  traceback.print_exc()

def node_test_1():
  s = "Nodo se inicializa correctamente sin next"
  value = "Buenas"
  try:
    node = Node(value)
    test.print_test(s, node.v == value and node.next is None)
  except Exception as err:
    error_by_except(s, err)
  
def node_test_2():
  s = "Nodo se inicializa correctamente con next"
  value_1 = "Fede es"
  value_2 = "un crack"
  try:
    node_2 = Node(value_2)
    node_1 = Node(value_1, node_2)
    test.print_test(s, node_1.v == value_1 and node_2.v == value_2 and node_1.next is node_2)
  except Exception as err:
    error_by_except(s, err)

def node_test_3():
  s = "Nodo se inicializa correctamente con otro elemento que no es un string"
  value = ("hola", "chau")
  try:
    node = Node(value)
    test.print_test(s, node.v == value)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_1():
  s = "Lista inicializa con un prim vacio"
  try:
    test_list = LinkedList()
    #test.print_test(s, test_list.head is None)
    test.print_test(s, test_list.prim is None)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_2():
  s = "Lista inicializa y tiene length 0"
  try:
    test_list = LinkedList()
    test.print_test(s, test_runner(length(test_list, 0)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_3():
  s = "Pruebo insertar elemento"
  value = "Hola"
  try:
    test_list = LinkedList()
    test_list.insert(0, value)
    integrity = check_list_integrity(test_list, 1)
    def custom_test():
      if not integrity:
        return errors["integrity"]
      return ""

    def custom_test2():
      if test_list.prim.v == value and test_list.prim.next is None:
        return ""
      return errors["assert"]  
    test.print_test(s, test_runner(custom_test2(), custom_test()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_4():
  s = "Pruebo insertar 2 elementos uno detras del otro"
  value = "bokita el mas grande"
  try:
    test_list = LinkedList()
    test_list.insert(0, 2)
    test_list.insert(1, value)

    def custom_test():
      if check_list_is_correct(test_list.prim, 2, [2, value]):
        return ""
      return errors["assert"]
    
    def custom_test2():
      if check_list_integrity(test_list, 2):
        return ""
      return errors["integrity"]
    test.print_test(s, test_runner(custom_test(), custom_test2()))

  except Exception as err:
    error_by_except(s, err)

def linked_list_test_5():
  s = "Pruebo insertar numero random de elementos uno detras del otro"
  element = 69
  try:
    test_list = LinkedList()
    length = random.randint(2, 20)
    many_insert(test_list, element, length)
    def custom_test():
      if check_list_is_correct(test_list.prim, element):
        return ""
      return errors["assert"]
    
    def custom_test2():
      if check_list_integrity(test_list, length):
        return ""
      return errors["integrity"]
    # test.print_test(s, check_list_is_correct(test_list.prim, element))
    test.print_test(s, test_runner(custom_test2(), custom_test()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_6():
  s = "Pruebo length de una lista con 6 elementos"
  element = 420
  try:
    test_list = LinkedList()
    many_append(test_list, element, 6)
    test.print_test(s, test_runner(length(test_list, 6)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_7():
  s = "Pruebo length de una lista con longitud random"
  element = ['hola', 'esto', 'es', 'una', 'lista']
  try:
    test_list = LinkedList()
    rand_length = random.randint(2, 18)
    many_append(test_list, element, rand_length)
    test.print_test(s, test_runner(length(test_list, rand_length)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_8():
  s = "Pruebo imprimir una lista de 5 elementos"
  element = 'hola'
  try:
    test_list = LinkedList()
    many_append(test_list, element, 5)
    res_alumno = str(test_list)
    res_correct = str([element for x in range(0, 5)])
    test.print_test(s, res_correct == res_alumno)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_9():
  s = "Pruebo imprimir una lista vacia"
  try:
    test_list = LinkedList()
    test.print_test(s, '[]' == str(test_list))
  except Exception as err:
    error_by_except(s, err)
    
def linked_list_test_10():
  s = "Pruebo insertar un elemento fuera de rango"
  try:
    test_list = LinkedList()
    error_was_thrown = False
    try:
      test_list.insert(2, "BLAZE IT")
    except IndexError as err:
      error_was_thrown = True
    test.print_test(s, error_was_thrown)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_11():
  s = "Pruebo hacer un pop de una lista vacia"
  try:
    test_list = LinkedList()    
    error_was_thrown = False
    try:
      test_list.pop()
    except IndexError as err:
      error_was_thrown = True
    test.print_test(s, error_was_thrown)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_12():
  s = "Pruebo hacer demasiados pops"
  try:
    test_list = LinkedList()
    many_append(test_list, "El 8N en la pera", 5)
    error_was_thrown = False
    try:
      for i in range(6):
        test_list.pop()
    except IndexError as err:
      error_was_thrown = True
    test.print_test(s, error_was_thrown)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_13():
  s = "Pruebo hacer un pop valido sin indice"
  value_1 = "El 8N es la fiesta de medios"
  value_2 = "El 8N es la fiesta de gestion"
  try:
    test_list = LinkedList()
    append(test_list, value_1)
    append(test_list, value_2)
    test_value_1 = test_list.pop()
    test_value_3 = test_list.pop()

    def custom_test1():
      try:
        if value_2 == test_value_1 and value_1 == test_value_3:
          return ""
        return errors["assert"]
      except Exception:
        return errors["assert"]

    def custom_test2():
      try:
        integrity = check_list_integrity(test_list, 0)
        if integrity:
          return ""
        return errors["integrity"]
      except Exception:
        return errors["integrity"]

    test.print_test(s, test_runner(custom_test1(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_14():
  s = "Pruebo hacer un pop valido con indice"
  value_1 = "El 8N es la fiesta de medios"
  value_2 = "El 8N es la fiesta de gestion"
  try:
    test_list = LinkedList()
    append(test_list, "ELEMENTO SORPRESA")
    append(test_list, value_1)
    append(test_list, value_2)
    test_value_1 = test_list.pop(1)
    test_value_2 = test_list.pop(1)
    integrity = check_list_integrity(test_list, 1)
    test.print_test(s, value_1 == test_value_1 and value_2 == test_value_2 and integrity)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_15():
  s = "Pruebo hacer un index de un elemento que existe"
  value_1 = "El 8N es la fiesta de medios"
  value_2 = "El 8N es la fiesta de gestion"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 10)
    append(test_list, value_2)
    index_1 = test_list.index(value_1)
    index_2 = test_list.index(value_2)
    test.print_test(s, index_1 == 0 and index_2 == 10)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_16():
  s = "Pruebo hacer un index de un elemento que no existe"
  value_1 = "El 8N es la fiesta de medios"
  value_2 = "El 8N es la fiesta de gestion"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 10)
    append(test_list, value_2)
    was_error_thrown = False
    
    index = test_list.index("El 8N es la fiesta de gestion de tic")
    was_error_thrown = not index
    test.print_test(s, was_error_thrown)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_17():
  s = "Pruebo hacer remove de un elemento que no existe"
  value_1 = "El 8N es la fiesta de medios"
  value_2 = "El 8N es la fiesta de gestion"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 10)
    append(test_list, value_2)
    error_was_thrown = False
    try:
      test_list.remove("ESTE TEXTO NO ESTA")
    except ValueError as err:
      error_was_thrown = True

    def custom_test():
      if error_was_thrown:
        return ""
      return errors["assert"]
    
    def custom_test1():
      try:
        if check_list_integrity(test_list, 11):
          return ""
        return errors["integrity"]
      except Exception:
        return errors["integrity"]
    test.print_test(s, error_was_thrown)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_18():
  s = "Pruebo hacer remove de un elemento que existe"
  value_1 = "El 8N es la fiesta de medios"
  value_2 = "El 8N es la fiesta de gestion"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 10)
    append(test_list, value_2)
    many_append(test_list, value_1, 5)
    test_list.remove(value_2)
    integrity = check_list_integrity(test_list, 15)
    def custom_test():
      if not integrity:
        return errors["integrity"]
      return ""
  
    test.print_test(s, test_runner(custom_test()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_19():
  s = "Hago varias operaciones (4 insert uno detras del otro, 1 pop con indice, 1 pop sin indice y un remove, un length y un index)"
  value_1 = "La orden de los factores"
  value_2 = "No altera el producto"
  try:
    test_list = LinkedList()
    many_insert(test_list, value_1, 2)
    many_insert(test_list, value_2, 1)
    many_insert(test_list, value_1, 1)
    test_list.pop()
    test_list.pop(0)
    test_list.remove(value_1)
    has_thrown_exception = False
    def custom_test2():
      if not check_list_integrity(test_list, 1):
        return errors["integrity"]
      return ""
    def custom_test():
      if test_list.prim.v != value_2:
        return errors["assert"]
      return ""
    result = test_runner(custom_test(), index(test_list), length(test_list, 1), custom_test2())
    test.print_test(s, result)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_20():
  s = "Hago varias operaciones (6 inserts uno detras del otro, 1 remove, 1 pop con indice, 2 pop sin indice, un length y un index)"
  value_1 = "Some"
  value_2 = "Body"
  value_3 = "Once"
  try:
    test_list  = LinkedList()
    many_insert(test_list, value_1, 2)
    many_insert(test_list, value_2, 2)
    many_insert(test_list, value_3, 2)
    test_list.remove(value_3)
    test_list.pop(1)
    test_list.pop()
    test_element = test_list.pop()

    def custom_test2():
      if not check_list_integrity(test_list, 2):
        return errors["integrity"]
      return ""
    
    def custom_test():
      return "" if (value_2 == test_element) else errors["assert"]
    result = test_runner(custom_test(), length(test_list, 2), index(test_list, value_2, 1), custom_test2())
    test.print_test(s, result)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_21():
  s = "Checkeo que la lista enlazada termina con None despues de hacer un append"
  try:
    test_list = LinkedList()
    test_list.append("JAJA")
    test.print_test(s, test_list.prim.next is None)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_22():
  s ="Hago una lista dentro de un Linked List e imprimo"
  try:
    test_list = LinkedList()
    value_1 = "sin = o/h"
    value_2 = "cos = a/h"
    value_3 = "tan = sin/cos"
    test_list2 = [value_1, value_2]
    many_append(test_list, value_1, 4)
    append(test_list, value_3)
    append(test_list, test_list2)
    append(test_list, value_2)

    first_list = [value_1 for x in range(0, 4)]
    first_list.extend([value_3 for x in range(0, 1)])
    first_list.append(test_list2)
    first_list.append(value_2)
    test.print_test(s, str(first_list) == str(test_list))

    # ORDEN DE LISTA 4 value_1, value_3, test_list2, value_2
  except Exception as err:
    error_by_except(s, err)
    
def linked_list_test_23():
  s = "Inserto 10000 elementos"
  try:
    test_list = LinkedList()
    value_1 = "Iñaki hermoso"
    many_insert(test_list, value_1, 10000)
    def custom_test_1():
      try:
        if check_list_integrity(test_list, 10000):
          return errors["integrity"]
        return ""
      except Exception:
        return errors["integrity"]
    test.print_test(s, test_runner(custom_test_1()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_24():
  s = "Hago remove del ultimo elemento de la lista"
  try:
    test_list = LinkedList()
    value_1 = 1
    value_2 = "January"
    value_3 = (1970)
    append(test_list, value_1)
    append(test_list, value_2)
    append(test_list, value_3)
    test_list.remove(value_3)
    
    def custom_test1():
      try:
        if not check_list_is_correct(test_list.prim, value_1, [value_1, value_2]):
          return errors["assert"]
        return ""
      except Exception:
        return errors["assert"]
    
    def custom_test2():
      try:
        if not check_list_integrity(test_list, 2):
          return errors["integrity"]
        return ""
      except Exception:
        return errors["integrity"]
    test.print_test(s, test_runner(custom_test1(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_25():
  s = "Hago remove del primer elemento de la lista"
  try:
    test_list = LinkedList()
    value_1 = 1
    value_2 = "January"
    value_3 = (1970)
    append(test_list, value_1)
    append(test_list, value_2)
    append(test_list, value_3)
    test_list.remove(value_1)
    test.print_test(s, check_list_is_correct(test_list.prim, value_2, [value_2, value_3]))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_26():
  s = "Hago pop del primer elemento de la lista"
  try:
    test_list = LinkedList()
    value_1 = 1
    value_2 = "January"
    value_3 = (1970)
    append(test_list, value_1)
    append(test_list, value_2)
    append(test_list, value_3)
    test_element = test_list.pop(0)
    
    def custom_test():
      try:
        if check_list_integrity(test_list, 2):
          return ""
        return errors["integrity"]
      except Exception:
        return errors["integrity"]

    def custom_test2():
      try:
        if check_list_is_correct(test_list.prim, value_2, [value_2, value_3]) and test_element == value_1:
          return ""
        return errors["assert"]
      except Exception:
        return errors["assert"]

    test.print_test(s, test_runner(custom_test(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_27():
  s = "Hago un index de una lista de 1000 elementos"
  try:
    test_list = LinkedList()
    value_1 = "!"
    value_2 = "F"
    many_append(test_list, value_1, 999)
    append(test_list, value_2)
    correct_index = 999
    test_index = test_list.index(value_2)
    test.print_test(s, test_index == correct_index)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_28():
  s = "Checkeo que la lista enlazada vacia tenga un ult"
  try:
    test_list = LinkedList()
    test.print_test(s, test_list.ult is None)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_29():
  s = "Hago pop default de una lista con elementos intercalados"
  value_1 = "Foo"
  value_2 = "Bar"
  try:
    test_list = LinkedList()
    for i in range(0, 8):
      append(test_list, value_1)
      append(test_list, value_2)
    result = []
    expected_result = [value_2, value_1, value_2]
    for i in range(0, 3):
      result.append(test_list.pop())
    
    def custom_test1():
      return errors["assert"] if not (result == expected_result) else  ""

    def custom_test2():
      return errors["integrity"] if not check_list_integrity(test_list, 13) else ""
    
    test.print_test(s, test_runner(custom_test2(), custom_test1()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_30():
  s = "Hago pop y append del pop varias veces"
  value_1 = (1, 2, 3)
  value_2 = (4, 5, 6)
  value_3 = (7, 8, 9)
  try:
    test_list = LinkedList()
    for i in range(0, 4):
      test_list.append(value_1)
      test_list.append(value_2)
      test_list.append(value_3)
    for i in range(0, 9):
      temp = test_list.pop()
      test_list.append(temp)
    
    def custom_test():
      return errors["integrity"] if not check_list_integrity(test_list, 12) else ""
    test.print_test(s, test_runner(custom_test()))
  except Exception as err:
    error_by_except(s, err)
  
def linked_list_test_31():
  s = "Pruebo hacer un append"
  value_1 = "Javascript No.1"
  try:
    test_list = LinkedList()
    test_list.append(value_1)

    def custom_test1():
      return errors["integrity"] if not check_list_integrity(test_list, 1) else ""
    
    def custom_test2():
      return errors["assert"] if not (test_list.prim.v == value_1) else ""

    test.print_test(s, test_runner(custom_test1(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_32():
  s = "Pruebo hacer varios append"
  value_1 = "Python No.2"
  value_2 = "Java No.3"
  value_3 = "PHP is shit"
  try:
    test_list = LinkedList()
    test_list.append(value_1)
    test_list.append(value_2)
    test_list.append(value_3)

    def custom_test1():
      return errors["integrity"] if not check_list_integrity(test_list, 3) else ""

    def custom_test2():
      return errors["assert"] if not (check_list_is_correct(test_list.prim, value_1, [value_1, value_2, value_3])) else ""

    test.print_test(s, test_runner(custom_test1(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_33():
  s = "Pruebo hacer 150000 appends"
  value_1 = "why"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 100000)
    test.print_test(s, test_runner(length(test_list, 100000)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_34():
  s = "Pruebo hacer 5000 pop"
  value_1 = "is"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 5000)
    for i in range(0, 5000):
      test_list.pop()
    test.print_test(s, test_runner(length(test_list, 0)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_35():
  s = "Pruebo hacer 5000 pop con indice"
  value_1 = "is"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 5000)
    for i in range(0, 5000):
      test_list.pop(0)
    test.print_test(s, test_runner(length(test_list, 0)))
  except Exception as err:
    error_by_except(s, err)


def linked_list_test_36():
  s = "Pruebo hacer 5000 remove"
  value_1 = "is"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 5000)
    for i in range(0, 5000):
      test_list.remove(value_1)
    test.print_test(s, test_runner(length(test_list, 0)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_37():
  s = "Pruebo hacer 8 inserts uno detras del otro e inserto devuelta dentro de la lista"
  value_1 = "Boomer"
  value_2 = "Ok"
  try:
    test_list = LinkedList()
    many_insert(test_list, value_2, 8)
    test_list.insert(2, value_1)
    correct_list = []
    for i in range(0, 9):
      if i == 2:
        correct_list.append(value_1)
      else:
        correct_list.append(value_2)
    def custom_test():
      if check_list_is_correct(test_list.prim, value_2, correct_list):
        return ""
      return errors["assert"]
    
    def custom_test2():
      if check_list_integrity(test_list, 9):
        return ""
      return errors["integrity"]
    
    test.print_test(s, test_runner(custom_test(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_38():
  s = "Pruebo hacer 8 inserts uno detras del otro e inserto en la ultima posicion"
  value_1 = "Boomer"
  value_2 = "Ok"
  try:
    test_list = LinkedList()
    many_insert(test_list, value_2, 8)
    test_list.insert(7, value_1)
    correct_list = []
    for i in range(0, 9):
      if i == 7:
        correct_list.append(value_1)
      else:
        correct_list.append(value_2)
    def custom_test():
      if check_list_is_correct(test_list.prim, value_2, correct_list):
        return ""
      return errors["assert"]
    
    def custom_test2():
      if check_list_integrity(test_list, 9):
        return ""
      return errors["integrity"]
    
    test.print_test(s, test_runner(custom_test(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_39():
  s = "Pruebo hacer 8 inserts uno detras del otro e inserto en la primera posicion"
  value_1 = "Boomer"
  value_2 = "Ok"
  try:
    test_list = LinkedList()
    many_insert(test_list, value_2, 8)
    test_list.insert(0, value_1)
    correct_list = []
    for i in range(0, 9):
      if i == 0:
        correct_list.append(value_1)
      else:
        correct_list.append(value_2)
    def custom_test():
      if check_list_is_correct(test_list.prim, value_1, correct_list):
        return ""
      return errors["assert"]
    
    def custom_test2():
      if check_list_integrity(test_list, 9):
        return ""
      return errors["integrity"]
    
    test.print_test(s, test_runner(custom_test(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_40():
  s = "Pruebo hacer 8 inserts uno detras del otro e inserto en la segunda posicion"
  value_1 = "Boomer"
  value_2 = "Ok"
  try:
    test_list = LinkedList()
    many_insert(test_list, value_2, 8)
    test_list.insert(1, value_1)
    correct_list = []
    for i in range(0, 9):
      if i == 1:
        correct_list.append(value_1)
      else:
        correct_list.append(value_2)
    def custom_test():
      if check_list_is_correct(test_list.prim, value_2, correct_list):
        return ""
      return errors["assert"]
    
    def custom_test2():
      if check_list_integrity(test_list, 9):
        return ""
      return errors["integrity"]
    
    test.print_test(s, test_runner(custom_test(), custom_test2()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_41():
  s = "Hago un pop del ultimo elemento de la lista con indice."
  value_1 = "Esto"
  value_2 = "No esta todo ok"
  try:
    test_list = LinkedList()
    correct_list = []
    for i in range(0, 3):
      append(test_list, value_1)
      append(test_list, value_2)
      correct_list.append(value_1)
      correct_list.append(value_2)

    correct_popped = []
    test_popped = []
    
    for i in range(0, 3):
      correct_popped.append(correct_list.pop(len(correct_list)-1))
      current = test_list.prim
      index = 0
      while current is not None:
        current = current.next
        index += 1
      test_popped.append(test_list.pop(index - 1))

    def custom_test():
      if correct_popped == test_popped and check_list_is_correct(test_list.prim, value_1, correct_list):
        return ""
      return errors["assert"]

    def custom_test3():
      if check_list_integrity(test_list, 3):
        return ""
      return errors["integrity"]

    test.print_test(s, test_runner(custom_test(), custom_test3()))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_42():
  s="Pruebo hacer un index de un elemento que ya borre utilizando REMOVE"
  value_1 = "Esta?"
  value_2 = "O no esta?"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 4)
    many_append(test_list, value_2, 1)
    many_append(test_list, value_1, 4)
    test_list.remove(value_2)

    def custom_test():
      index = test_list.index(value_2)
      if index is not None:
        return errors["assert"]
      return ""

    test.print_test(s, test_runner(custom_test()))
  except Exception as err:
    error_by_except(s, err) 

def linked_list_test_43():
  s = "Pruebo hacer remove dentro de una lista con elementos repetidos"
  value_1 = "Yas"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 9)
    test_list.remove(value_1)

    def custom_test():
      if check_list_integrity(test_list, 8):
        return ""
      return errors["integrity"]

    test.print_test(s, test_runner(custom_test()))
  except Exception as err:
    error_by_except(s, err) 

def linked_list_test_44():
  s = "Pruebo hacer un index de una lista con elementos repetidos"
  value_1 = "Senna"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 10)
    indice = test_list.index(value_1)
    test.print_test(s, indice == 0)
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_45():
  s = "Pruebo hacer un length despues de haber borrado un elemento (pop sin indice)"
  value_1 = "hue"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 9)
    test_list.pop()
    test.print_test(s, test_runner(length(test_list, 8)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_46():
  s = "Pruebo hacer un length despues de haber borrado un elemento (pop con indice)"
  value_1 = "hue"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 9)
    test_list.pop(8)
    test.print_test(s, test_runner(length(test_list, 8)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_47():
  s = "Pruebo hacer un length despues de haber borrado un elemento (remove)"
  value_1 = "hue"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 9)
    test_list.remove(value_1)
    test.print_test(s, test_runner(length(test_list, 8)))
  except Exception as err:
    error_by_except(s, err)

def linked_list_test_48():
  s = "Pruebo hacer un length despues de haber borrado un elemento (pop(0))"
  value_1 = "hue"
  try:
    test_list = LinkedList()
    many_append(test_list, value_1, 9)
    test_list.pop(0)
    test.print_test(s, test_runner(length(test_list, 8)))
  except Exception as err:
    error_by_except(s, err)

""" HELPER FUNCTIONS """

# Funcion que llena una lista de un elemento n veces
def many_insert(linked_list, element, n):
  size = len(linked_list)
  for i in range(size, n + size):
    linked_list.insert(i, element)

def many_append(linked_list, element, n):
  for i in range(0, n):
    append(linked_list, element)

def append(list, el):
  new_node = Node(el)
  if list.prim is None:
    list.prim = new_node
  else:
    list.ult.next = new_node
    try:
      new_node.prev = list.ult
    except Exception:
      pass
  list.ult = new_node
  list.len += 1

# Funcion que obtiene el length iterando por la lista para ver si hay perdida de integridad de la lista
def check_list_integrity(linked_list, length):
  try:
    current = linked_list.prim
    index = 0
    last_element = linked_list.ult
    while current:
      index += 1
      current = current.next
      if current is not None:
        last_element = current
    return length == index and (last_element is linked_list.ult)
  except Exception:
    return False

# Funcion recursiva que checkea que todos los elementos de una lista esten correctos. Por default checkea que este lleno de un solo elemento, pero podes pasarle una lista para que checkee elemento por elemento. Para esta opcion, test_element tiene que ser el primer elemento de la lista.
def check_list_is_correct(node, test_element, list_correct = None, i = 0):
  try:
    if node.next is None and node.v == test_element:
      return True
    elif node.v != test_element:
      return False
    i += 1
    return check_list_is_correct(node.next, list_correct[i] if (list_correct != None) else test_element, list_correct, i)
  except Exception:
    return False
# Recibe funciones de testing que responden o un error o un "".
def test_runner(*argv):
  res = ""
  for arg in argv:
    res += arg
  if res != "":
    raise Exception(res)
  return True

# Test que checkea que el length sea correcto
def length(linked_list, length):
  try:
    if len(linked_list) != length:
      return errors["length"]
    return ""
  except Exception:
    return errors["length"]

# Test que checkea que el index de un elemento sea correcto. Si no recibe Index, checkea que el elemento NO este en la lista.
def index(linked_list, element = None, index = None):
    result = False
    try:
      if index is None:
        result = not linked_list.index(element)
      elif index is not None:
        result = index == linked_list.index(element)
      return "" if result else errors["index"]
    except Exception:
      return errors["index"]

def main():
  print("")
  print("Trabajo practico 5 - Python")
  print("")

  excepciones_de_corrector="""
----Aclaraciones--------------------------------------------------------------------------
Llamar v, next a los atributos del Nodo

Llamar prim, ult, len a los atributos de la Lista Enlazada

Cuando haces remove de un elemento que no existe, tira Value Error

Remove borra la primera instancia del elemento dentro de la lista

Cuando haces un index de un elemento que no existe, devuelve None

Las listas se imprimen de forma ['hola', 'soy', 'mati'] CON espacios entre elementos

Si la lista se imprime con [hola, soy, mati], es incorrecta. 

Todos los ultimos nodos de la lista enlazada tienen que apuntar a None.

Para errores de timeout es muy probable que esten en el append. Sino es esto, es posible que algun nodo este apuntando a si mismo y/o un nodo anterior, generando una lista circular.

Para errores de integridad hay que estar atento a que el ultimo elemento de la lista (ult) se mantenga actualizado, osea que apunte al nodo correcto
------------------------------------------------------------------------------------------
  """
  print(excepciones_de_corrector)
  print("\n \n")

  print("NODO")
  node_test_1()
  node_test_2()
  node_test_3()

  print(" \n")

  print("LISTA ENLAZADA")
  linked_list_test_1()
  linked_list_test_28()

  print(" \n")

  print("APPEND")
  linked_list_test_31()
  linked_list_test_32()
  linked_list_test_33()
  linked_list_test_21()

  print(" \n")

  print("INSERTAR")
  linked_list_test_3()
  linked_list_test_4()
  linked_list_test_5()
  linked_list_test_10()
  linked_list_test_37()
  linked_list_test_38()
  linked_list_test_39()
  linked_list_test_40()

  print(" \n")

  print("LENGTH")
  linked_list_test_2()
  linked_list_test_6()
  linked_list_test_7()
  linked_list_test_45()
  linked_list_test_46()
  linked_list_test_47()

  print(" \n")

  print("STRING")
  linked_list_test_8()
  linked_list_test_9()
  linked_list_test_22()

  print(" \n")

  print("POP")
  linked_list_test_11()
  linked_list_test_12()
  linked_list_test_13()
  linked_list_test_14()
  linked_list_test_26()
  linked_list_test_29()
  linked_list_test_34()
  linked_list_test_35()
  linked_list_test_41()

  print(" \n")

  print("INDEX")
  linked_list_test_15()
  linked_list_test_16()
  linked_list_test_42()
  linked_list_test_44()

  print(" \n")

  print("REMOVE")
  linked_list_test_17()
  linked_list_test_18()
  linked_list_test_24()
  linked_list_test_25()
  linked_list_test_36()
  linked_list_test_43()

  print(" \n")

  print("OPERACIONES RANDOM")
  linked_list_test_19()
  linked_list_test_20()
  linked_list_test_30()

  if test.fails != 0:
    raise Exception("ERROR: Hubo fallos " + str(test.fails) + " en los asserts del TP. Revisar")
  print("Felicitaciones, pero su todo ok esta en otro castillo")
  print("\n" * 500 + "Frootloops, Done By ArangShih")
  print("TODO OK")
  return

if __name__ == "__main__":
  main()
  """
  lista = LinkedList()
  append(lista, "hola")
  print(str(lista))
  """
