public class NodoBin<T>{
   T elem;
    NodoBin<T> izq, der,papa;

    NodoBin (T dato){
    
        elem = dato;
        izq = null;
        der = null;
        papa=null;
    }


    public void setDer (NodoBin<T> actual){
        der = actual;
    }
    public void setIzq (NodoBin<T> actual){
        izq = actual;
    }
    public NodoBin<T> getDer(){
      return der;
    }
    public NodoBin<T> getIzq(){
      return izq;
    }
    public T getElem(){
        return elem;
    }
    public NodoBin<T> getPapa(){
      return papa;
    }
    public void setPapa(NodoBin<T> actual){
    papa=actual;
    }
    public void setElem(T elemento){
      elem=elemento;
    } 



  
}