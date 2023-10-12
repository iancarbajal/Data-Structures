/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.Iterator;

/**
 *
 * @author ianca
 * @param <T>
 */
public interface ListaADT<T> {
    
    public Iterator<T> iterator();
    public boolean estaVacia();
    public T quitaPrimero();
    public T quitaUltimo();
    public T quita(T Dato);
    @Override
    public String toString();
    public boolean contiene(T dato);
    public int calculaTamanio();
    public T obtienePrimero();
    public T obtieneUltimo();
    
    
}
