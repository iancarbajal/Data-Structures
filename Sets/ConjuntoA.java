/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto;

import java.util.Iterator;

/**
 *
 * @author ianca
 */
public class ConjuntoA<T> implements ConjuntoADT<T> {
    private T[] elementos;
    private int cardinalidad;
    private final int MAX=50;

    public ConjuntoA() {
        this.elementos = (T[]) new Object[MAX];
        this.cardinalidad = 0;
    }
    
    public ConjuntoA( int max) {
        this.elementos = (T[]) new Object[max];
        this.cardinalidad = 0;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new IteradorArreglo(elementos,cardinalidad);
    }

    @Override
    public boolean agrega(T dato) {
        boolean r=false;
        
        if(!contiene(dato)){
            if(cardinalidad==elementos.length)
                expande();
            elementos[cardinalidad]=dato;
            cardinalidad++;
            r=true;
        }
        
        return r;
            
    }
    public void expande(){
        T[] nuevo= (T[]) new Object[elementos.length*2];
        
        for(int i=0;i<cardinalidad;i++)
            nuevo[i]=elementos[i];
        
        elementos=nuevo;
    }

    @Override
    public T quita(T dato) {
        int pos;
        T r;
        pos=buscaElemento(dato);
        
        if(pos>=0){
            r=elementos[pos];
            elementos[pos]=elementos[cardinalidad-1];
            elementos[cardinalidad-1]=null;
            cardinalidad--;
            return r;
        }
        throw new ExcepcionColeccionVacia("dato no encontrado");
        
    }
    
    private int buscaElemento(T dato){
        int i=0;
        
        while(i<cardinalidad && elementos[i].equals(dato)){   
            i++;
        }
        if(i==cardinalidad)
            i=-1;
        
        return i;
    }
    @Override
    public boolean contiene(T elemento) {
        boolean r=false;
        int i=0;
        
        while(i<cardinalidad && !r){
            if(elementos[i].equals(elemento))
                r=true;
            i++;
        }
        return r;
    }

    @Override
    public int getCardinalidad() {
        return cardinalidad;
    }

    @Override
    public boolean esVacio() {
        return cardinalidad==0;
    }
    
    @Override
    public String toString(){
        StringBuilder c=new StringBuilder();
        Iterator<T> i=this.iterator();
        
        while(i.hasNext())
            c.append(i.next().toString());
        
        return c.toString();
        
    }
    
}
