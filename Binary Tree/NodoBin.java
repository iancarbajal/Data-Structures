public class NodoBin<T> {
    private T elem;
    private NodoBin<T> izq,der;

    public NodoBin(T dato){
        elem=dato;
        izq=null;
        der=null;
    }
    
    public NodoBin<T> getDer(){
        return der;
    }
    public NodoBin<T> getIzq(){
        return der;
    }
    public NodoBin<T> setDer(NodoBin<T> dato){
        der=dato;
    }

    public int numDescendientes(){
        int c=0;
        
        if(izq!=null){
            c=1+izqNumDescendientes();
        }
        if(der!null){
            c=1+derNumDescendientes();
        }

        return c;
        
    }

}
