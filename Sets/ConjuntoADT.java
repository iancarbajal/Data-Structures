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
 * @param <T>
 */
public interface ConjuntoADT<T> extends Iterable<T> {
    @Override
    public Iterator<T> iterator();
    public boolean agrega(T dato);
    public T quita(T dato);
    public boolean contiene(T elemento);
    public int getCardinalidad();
    public boolean esVacio();
    @Override
    public String toString();
    
    
}
