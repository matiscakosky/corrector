from tppy2 import *
from testing import show_test

test=show_test()

def assert_devolver4():
    print("Test 1")
    print("Compruebo que el resultado de la funcion es un 4")
    resul=devolver_4()
    
    test.print_test("El resultado de la funcion es 4",resul==4)


def main():
    
    print()
    print("TP: Python TPPY 2 ")
    
    for i in range(4):
        print()
    assert_devolver4()
    
    if test.fails != 0:
        raise ValueError("ERROR")

    return 


if __name__ == "__main__":
  main()