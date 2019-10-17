#from memory_profiler import memory_usage

#from memory_profiler import profile
#import gc

"""
def measure_mem(func):
    gc.collect()
    process_usage = memory_usage(max_usage=True)
    gc.collect()
    usage = memory_usage(func, 0.005, max_usage=True)[0]
    gc.collect()
    return usage - process_usage

def invertListA(l):
    return l[::-1] 
 
def invertListBIdeal(l):
    for i in range(0, len(l) // 2 - 1):
        t = l[i]
        l[i] = l[len(l) - i - 1]
        l[len(l) - i - 1] = t

def testA():
    invertListA(lista1)
def testB():
    invertListBIdeal(lista2)

def test01compruebomemoria():
    vara = measure_mem(testA)
    print(str(vara))
    varb = measure_mem(testB)
    print(str(varb))
    print("Dif: ", str(vara-varb))
   """ 
def invertir_wd(L):
    return L[::-1]

def empaquetar_wd(s,n):
    l = s.split()
    cad = "".join(l)
    final=[]
    for i in range(0,len(cad),n):
        final.append(cad[i:i+n])
    return final
    

def invertir_inplace_wd(L):
    for i in range(len(L)//2):
        aux=L[i]
        L[i]=L[len(L)-1-i]
        L[(len(L)-1)-i]=aux
    return L

def repeticiones_consecutivas_wd(L):
    if(len(L)==0): return []
    L.append(None)
    final=[]
    anterior=None
    cont=None
    for elem in L:        
        if (not anterior):
            anterior=elem
            cont=1
            continue
        if elem==anterior:
            cont+=1
        else:
            final.append((anterior,cont))
            anterior=elem
            cont=1
    return final

def _map(funct,obj):
    return list(map(funct,obj))

def _filter(funct,obj):
    return list(filter(funct,obj))

    
