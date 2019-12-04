def es_triang_superior_wd(M):
    for i in range(len(M)):
        for j in range(len(M)):
            if(j<i and M[i][j] != 0): return False
    return True
                
def terminan_con_wd(s):
    s=s.lower()
    dic={}
    l = s.split()
    for palabra in l:
        lista_pal=dic.get(palabra[-1],[])
        lista_pal.append(palabra)
        dic[palabra[-1]]=lista_pal
    return dic


def extend_wd(self,otra):
    if self.len == 0:
        self.prim = otra.prim
        self.ult=otra.ult
        self.len = otra.len
        return
    self.ult.next = otra.prim
    if otra.ult:self.ult = otra.ult
    self.len += otra.len
