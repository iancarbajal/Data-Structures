/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ianca
 */
public class IteradorArreglo<T> implements Iterator<T>{
    
    private int actual;
    private T[] datos;
    private int total;
    
    public IteradorArreglo(T[] datos, int total){
        this.datos=datos;
        this.total=total;
        this.actual=0;
    }

    @Override
    public boolean hasNext() {
        return actual<total;
    }

    @Override
    public T next() {
        if(hasNext()){
            T res= datos[actual];
            actual++;
            return res;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
