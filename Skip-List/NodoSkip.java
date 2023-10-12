public class NodoSkip<T> {
    T elem;
    NodoSkip<T> izq,der,arriba,abajo;

    NodoSkip(){
        elem=null;
        izq=null;
        der=null;
        arriba=null;
        abajo=null;
    }

    NodoSkip(T elem){
        this.elem=elem;
        izq=null;
        der=null;
        arriba=null;
        abajo=null;
    }
    @Override
    public String toString(){
        return elem.toString();
    }

}
