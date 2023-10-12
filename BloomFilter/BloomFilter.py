import numpy as np
import hashlib as hl

class BloomFilter():
    def __init__(self, size,k):
        self.k=k
        self.bloom=np.array([False for i in range(size)], dtype=bool)
        self.size=size
        self.cont=0

    def inserta(self,dato):
        pos=self.getHash(dato)
        for i in pos:
            self.bloom[i]=True
        self.cont+=1
        
    def getHash(self,dato):
        bits=int(np.ceil(np.log(self.size)/np.log(2)))
        hexa=int(np.ceil(bits/4))
        nMd5=int(np.ceil(self.k*hexa/32))
        hash=hl.md5(dato.encode('utf-8')).hexdigest()
        for i in range(nMd5-1):
            hash+=hl.md5(hash.encode('utf-8')).hexdigest()
        res=[]
        for i in range(0,hexa*self.k,hexa):
            res.append(int(hash[i:i+hexa],16)%self.size)
        return(res)

    def busca(self,elem):
        pos=self.getHash(elem)
        f=True
        i=0
        while(f and i<len(pos)):
            if not self.bloom[pos[i]]:
                f=False
            i+=1
        return(f)        



b=BloomFilter(255,4)
b.inserta("fer")
print(b.busca("fer"))