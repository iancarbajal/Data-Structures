import numpy as np


class NodoTrie:
    def __init__(self):
        self.In=False
        self.sim={}

class Trie:
    def __init__(self):
        self.raiz=NodoTrie()
        self.cont=0
        self.raiz.In=True

    def inserta(self, elem):
        l=len(elem)
        li=list(elem)
        for i in range(l):
            if li[i] not in sim.keys():
                sim[cont]=li[i]

    def busca(self, palabra):
        r=False
        actual=self.raiz
        i=0
        while(i in actual.sim):
            actual=actual.sim[palabra]
            i+=1

        if(i==len(palabra) and actual.sim[i].fin):
            r=True

        return(r)
                
    def __recorre(self,actual,cad,lista):
        if(actual.bandera):
            lista.add(cad)

        for k in actual.sim.keys():
            recorre(actual.sim[k],cad+k,lista)

    def recorre(self):
        recorre(raiz,"",[])

    def borra(self, palabra):
        return("TO DO")
