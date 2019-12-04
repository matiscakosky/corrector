def es_triang_superior(M):
    for i in range(len(M)):
        for j in range(len(M)):
            if(j<i and M[i][j] != 0): return False
    return True
                
def terminan_con(s):
    s=s.lower()
    dic={}
    l = s.split()
    for palabra in l:
        lista_pal=dic.get(palabra[0],[])
        lista_pal.append(palabra)
        dic[palabra[0]]=lista_pal
    return dic


def extend(self,otra):
    if self.len == 0:
        self.prim = otra.prim
        self.ult=otra.ult
        self.len = otra.len
        return
    self.ult.next = otra.prim
    if otra.ult:self.ult = otra.ult
    self.len += otra.len
