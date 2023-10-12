import java.util.ArrayList;

public class ArbolBin<T> implements BinaryTreeADT<T> {
    NodoBin<T> raiz;
    int cont;
    
    public int size(){
        return cont;
    }

    public boolean isEmpty(){
        return cont==0;
    }

    public Iterator<T> IteratorPreorden(){
        ArrayList<T> lista = new ArrayList<T>();
        preorden(raiz,lista);
        return lista.iterator();
    }

    public NodoBin<T> preorden(NodoBin<T> actual, ArrayList<T> lista){
        if(actual==null)
            return;

        lista.add(actual.getElem());
        preorden(actual.getIzq(),lista);
        preorden(actual.getDer(),lista);
    }
    public NodoBin<T> inorden(NodoBin<T> actual,ArrayList<T> lista){
        if(actual==null)
            return;

        inorden(actual.getIzq(),lista);
        lista.add(actual.getElem());
        inorden(actual.getDer(),lista);
    }
    public NodoBin<T> postorden(NodoBin<T> actual,ArrayList<T> lista){
        if(actual==null)
            return;

        postorden(actual.getIzq(),lista);
        postorden(actual.getDer(),lista);
        lista.add(actual.getElem());
    }

    public boolean contains(T element){
        
        contains(T element,false);
        return actual.equals(element);

    }

    private boolean contains(T ele,boolean f){
        if(actual==null)
            return f;

        if(actual.equals(elem))
            contains(actual.getIzq());
    }

    public <T> void borra(T dato){
        if(actual.getIzq==null || actual.getDer==null){
            if(actual.getIzq!=null)
                hijo=actual.getIzq;
            else
                hijo=actual.getDer;

            if(raiz==actual)
                raiz=hijo;
            else   
                acual.papa.cuelga(hijo);
            
            cont--;
            

        }
    }

    public int altura(){
        return altura(raiz,0);

    }
    private int atura(NodoBin<T> actual,int cont){
        if(actual==null)
            return cont;

        altura(actual.getDer(),cont);
        altura(actual.getIzq(),cont);
        cont++;
    }
}   

