

class show_test:
    def __init__(self):
        self.fails=0
        
    def print_test(self,mensaje,ok):
        if not ok: self.fails += 1
        print("{} ... {}".format(mensaje,"OK" if ok else "ERROR" ))