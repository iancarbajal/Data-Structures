import java.util.Random;
import java.lang.Math;

public class SkipList<T extends Comparable<T>> implements SkipListADT<T>{

    NodoSkip<T> cabeza,cola;
    int cont;
    int numListas;
    Random generador= new Random(7857857);


    public SkipList() {
        this.cabeza = new NodoSkip<T>(null);
        this.cola = new NodoSkip<T>(null);
        this.cont = 0;
        this.numListas = 1;
    }


    private void ligaIzqDer(NodoSkip<T> izq, NodoSkip<T> der){
        if(izq==null || der==null)
            return;
        
        izq.der=der;
        der.izq=izq;
    }

    private void insertaHorizontal(NodoSkip<T> anterior, NodoSkip<T> nuevo){
        ligaIzqDer(anterior, nuevo);
        if(anterior !=null)
            ligaIzqDer(nuevo, anterior.der);
    }

    private void ligaAbajo(NodoSkip<T> abajo,NodoSkip<T> arriba){
        if(abajo==null || arriba==null)
            return;
        
        abajo.arriba=arriba;
        arriba.abajo=abajo;
    }

    private void expande(){
        NodoSkip<T> nodo1,nodo2;
        nodo1=new NodoSkip<T>(null);
        nodo2=new NodoSkip<T>(null);
        ligaAbajo(cabeza, nodo1);
        ligaAbajo(cola,nodo2);
        ligaIzqDer(nodo1, nodo2);
        cabeza=nodo1;
        cola=nodo2;
        numListas++;
    }

    @Override
    public NodoSkip<T> busca(T elem) {
        NodoSkip<T> res=cabeza;
        boolean f=false;
        while(!f && res!=null){
            while(res.elem !=null && res.der!=null && (res.der.elem !=null) && res.elem.compareTo(elem)<=0){
                res=res.der;
            }
            if(res.abajo!=null)
                res=res.abajo;
            else
                f=true;
        }
        return res;
    }

    @Override
    public void inserta(T elem) {
        NodoSkip<T> nuevo=new NodoSkip<T>(elem);
        NodoSkip<T> actual=busca(elem);
        cont++;
        ligaIzqDer(actual, nuevo);

        int i=1;
        while(i<=(int) 1+Math.log(cont)/Math.log(2) && generador.nextBoolean()){
            if(numListas<i){
                expande(); 
            }
            while(actual!=null && actual.arriba==null){
                actual=actual.izq;
            }
            if(actual!=null)
                actual=actual.arriba;
            NodoSkip<T> nuevo2=new NodoSkip<>(elem);
            insertaHorizontal(actual, nuevo2);
            ligaAbajo(nuevo, nuevo2);
            i++;
        }

    }

    @Override
    public void borra(T elem) {
		
		NodoSkip<T> actual=busca(elem); //Primer paso buscar elemento
		
		//Caso base no encuentra elemento
		if(!actual.elem.equals(elem)) {
			return;
		}
		
		while(actual!=null) {
			ligaIzqDer(actual.izq,actual.der); //Conecta los dos extremos
			actual=actual.arriba;
		}
		
		//Juntar todas las conexiones
		if(numListas>1 && numListas>(int)Math.log(cont)/Math.log(2)) {
			cabeza=cabeza.abajo;
			cola=cola.abajo;
			actual=cabeza;
			while(actual!=null) {
				actual.arriba=null;
				actual=actual.der;
			}
			numListas--;
		}
		cont--;
    }

    @Override
    public String toString(){
        StringBuilder c = new StringBuilder();
        NodoSkip<T> res=cabeza;
        boolean f=false;

        while (!f && res!=null){
            if(res.abajo!=null)
                res=res.abajo;
            else
                f=true;
        }
        for(int i=0;i<cont;i++){
            c.append(res.der.toString()+" ");
        }
        return c.toString();
    }
    
}
