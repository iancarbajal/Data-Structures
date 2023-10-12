/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura.enlazada;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ianca
 * @param <T>
 */
public class IteradorEE<T> implements Iterator<T> {
    private Nodo<T> actual;

    public IteradorEE(Nodo<T> actual) {
        this.actual = actual;
    }

    @Override
    public boolean hasNext() {
        return actual!=null;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
                
        T dato=actual.getDato();
        actual=actual.getSiguiente();
        return dato;
    }

    
    
}
