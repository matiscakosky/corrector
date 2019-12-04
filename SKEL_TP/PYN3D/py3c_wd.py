
def organizar_wd(dic):
    pueden = [1]*31
    dias_inhabiles = dic.values()
    for lista in dias_inhabiles:
        for dia in lista:
            pueden[dia]=0
    final=[]
    for i in range(1,len(pueden)):
        if pueden[i]: final.append(i)
    return final

def validar_wd(nom,ape,password):
    special = "%$-()=#!?"
    if len(password) <= 15 and len(password)>=8 and nom not in password and ape not in password:
        for l in special:
            if l in password:
                return True
    return False
        
     
def invertir_wd(self):
    if(self.len==0 or self.len==1):
        return
    prev = None
    current = self.prim 
    while(current is not None): 
        nextt = current.next
        current.next = prev 
        prev = current 
        current = nextt
    self.ult=self.prim
    self.prim = prev              
