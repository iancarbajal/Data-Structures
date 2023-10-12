import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class ArbolAVL<T extends Comparable<T>> implements ArbolAVLADT<T> {
    private NodoAVL<T> raiz;

    public ArbolAVL() {
        raiz=null;
    }

    public ArbolAVL(T elem) {
        this.raiz = new NodoAVL<T>(elem);
    }

    public boolean isEmpty(){
        return raiz==null;
    }

    private NodoAVL<T> busca(NodoAVL<T> arbolito, T elementito){
        if(arbolito == null)
          return arbolito;
        if(arbolito.getDato().compareTo(elementito)<0)
          return busca(arbolito.getDer(), elementito);
        if(arbolito.getDato().compareTo(elementito)>0)
          return busca(arbolito.getIzq(), elementito);
        return arbolito;
    }
    public boolean contains(T elem){
        return busca(raiz, elem)!=null;
    }


    private NodoAVL<T> rotaDer(NodoAVL<T> x) {
        NodoAVL<T> y = x.getIzq();
        NodoAVL<T> T2 = y.getDer();
        NodoAVL<T> p=x.getPapa();
 
        // rotacion
        y.setDer(x);
        x.setIzq(T2);
        x.setPapa(y);
        if(T2!=null)
            T2.setPapa(x);
        
 
        // actualizaAltura
        x.actualizaAltura();
        x.actualizaFe();
        y.actualizaAltura();
        y.actualizaFe();

        if(x==raiz){
            raiz=y;
            raiz.actualizaAltura();
            raiz.actualizaFe();
            y.setPapa(null);
        }
        else{
            p.cuelga(y);
            p.actualizaAltura();
            p.actualizaFe();
        }
 
        return y;
    }

    private NodoAVL<T> rotaIzq(NodoAVL<T> x) {
        NodoAVL<T> y = x.getDer();
        NodoAVL<T> T2 = y.getIzq();
        NodoAVL<T> p=x.getPapa();
 
        // rotacion
        y.setIzq(x);
        x.setDer(T2);
        x.setPapa(y);
        if(T2!=null)
            T2.setPapa(x);
        
 
        // actualizaAltura
        x.actualizaAltura();
        x.actualizaFe();
        y.actualizaAltura();
        y.actualizaFe();

        if(x==raiz){
            raiz=y;
            raiz.actualizaAltura();
            raiz.actualizaFe();
            y.setPapa(null);
        }
        else{
            p.cuelga(y);
            p.actualizaAltura();
            p.actualizaFe();
        }
 
        return y;
    }

    private NodoAVL<T> insertaBB(T elem){
        NodoAVL<T> actual=raiz,anterior=raiz,res=null;
        if(raiz==null){
          raiz=new NodoAVL<T>(elem);
          return raiz;
        }
     
       while(actual!=null){
         anterior=actual;
         if(elem.compareTo(actual.getDato())<=0)
           actual=actual.getIzq();
         else
           actual=actual.getDer();
         }
         res=new NodoAVL<T>(elem);
         anterior.cuelga(res);
         return res;
        
      }

      private NodoAVL<T> rota(NodoAVL<T> subArbol){
        switch(subArbol.getFe()){
            case 2:
                if(subArbol.getDer().getFe()==-1){
                    rotaDer(subArbol.getDer());
                    return rotaIzq(subArbol);
                }else{
                    return rotaIzq(subArbol);
                }
            case -2:
                if(subArbol.getIzq().getFe()==1){
                    rotaIzq(subArbol.getIzq());
                    return rotaDer(subArbol);
                }else{
                    return rotaDer(subArbol);
                }
            default:
                return subArbol;
        }
        
    }

    public void inserta(T dato){
        if(contains(dato))
            return;

        NodoAVL<T> actual=insertaBB(dato); // metodo inserta binary search tree que regrese NODO
        NodoAVL<T> papa=actual.getPapa();
        int feV=0;
        boolean f=false;

        while(!f && papa!=null){
            if(papa==raiz)
                raiz.setFe(raiz.getFe()+1);
            feV=papa.getFe();
            papa.actualizaAltura();
            papa.actualizaFe();
            if(Math.abs(papa.getFe())>1){
                papa=rota(papa); // funcion rotaciones
            }
            if(feV==-1 || feV==1){
                f=papa.getFe()==0;
            }
            papa=papa.getPapa();
        }
        
    }

    private NodoAVL<T> borraBB(T elem){
        NodoAVL<T> d=busca(raiz, elem);
        NodoAVL<T> aux,papa=d.getPapa();
        Iterator<T> it =iteratorInOrden();
        T suIn,temp;
        if(d.getDer()!=null && d.getIzq()!=null){
            suIn=(T) it.next();
            while(it.hasNext() && suIn.compareTo(elem)<=0){
                suIn=(T) it.next();
            }
            aux=busca(d, suIn);
            temp=d.getDato();
            d.setDato(suIn);
            aux.setDato(temp);
            if(aux.getDer()==null){
               aux.getPapa().setIzq(null);
               return aux.getPapa();
            }else{
                aux.getPapa().cuelga(aux.getDer());
            }
            return aux.getPapa().getDer();
        }else{
            if(d.getDer()!=null){
                d.getDer().setPapa(papa);
                papa.cuelga(d.getDer());
                return d.getDer();
            }else {
                if(d.getIzq()!=null){
                    d.getIzq().setPapa(papa);
                    papa.cuelga(d.getIzq());
                    return d.getIzq();
                }
            }
        }

        if(d.getDato().compareTo(papa.getDato())<=0)
                papa.setIzq(null);
        else
                papa.setDer(null);

        return d;

    }

    public void borra(T elem){
        NodoAVL<T> actual;
        int hant,hact;

        if(busca(raiz, elem)==null)
            return;

        actual=borraBB(elem);//el nodo de cuyo papa comienzo a actualizar

        if(actual.getDer()!=null || actual.getIzq()!=null){
            actual=actual.getDer();
        }else{
            if(actual.getDer()!=null){
                actual=actual.getDer();
            }else{
                if(actual.getIzq()!=null){
                    actual=actual.getIzq();
                }
            }
        }

        hant=actual.getH();
        hact=actual.getH()+1;

        actual.actualizaAltura();
        actual.actualizaFe();
        
        while(actual!=raiz && hant!=hact){
            actual=actual.getPapa();
            hant=actual.getH();
            actual.actualizaAltura();
            actual.actualizaFe();
            if(Math.abs(actual.getFe())>=1){
                actual=rota(actual);
            }
            hact=actual.getH();
        }
    }

    public NodoAVL<T> getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NodoAVL<T> raiz) {
        this.raiz = raiz;
    }

    private void preOrden(NodoAVL<T> actual,ArrayList<T> lista){
        if(actual==null)
            return;
        lista.add(actual.getDato());//esto fue visitar
        preOrden(actual.getIzq(),lista);
        preOrden(actual.getDer(),lista);
  
    }
    public Iterator<T> iteratorPreOrden(){
        ArrayList<T> lista=new ArrayList<T>();
        preOrden(raiz,lista);
        return lista.iterator();
    }
    public Iterator<T> iteratorInOrden(){
        ArrayList<T> lista=new ArrayList<T>();
        inOrden(raiz,lista);      

        return lista.iterator();
    }

    private void inOrden(NodoAVL<T> actual,ArrayList<T> lista){
        if(actual==null)
            return;
        inOrden(actual.getIzq(),lista);
        lista.add(actual.getDato());//esto fue visitar
        inOrden(actual.getDer(),lista);
    }
  
    public Iterator<T> iteratorPostOrden(){
        ArrayList<T> lista=new ArrayList<T>();
        postOrden(raiz,lista);
        return lista.iterator();
    }
    private void postOrden(NodoAVL<T> actual,ArrayList<T> lista){
        if(actual==null)
            return;
        postOrden(actual.getIzq(),lista);
        postOrden(actual.getDer(),lista);
        lista.add(actual.getDato());//esto fue visitar
    }

    public void imprimeArbol(){
        if (raiz == null)
          return;
      
        Queue<NodoAVL<T>> q = new LinkedList<>();
        q.add(raiz);
        q.add(null);
        while (!q.isEmpty()) {
      
            NodoAVL<T> curr = q.poll();
            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
                }
            } else {
                if (curr.getIzq() != null)
                    q.add(curr.getIzq());
                
                if (curr.getDer() != null)
                    q.add(curr.getDer());
        
                System.out.print(curr.getDato().toString() + " ");
            }
        }
    }

}
