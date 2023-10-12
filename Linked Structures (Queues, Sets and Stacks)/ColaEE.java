/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura.enlazada;

import java.util.Iterator;

/**
 *
 * @author ianca
 */
public class ColaEE<T> implements ColaADT<T>{
    private EE elementos;

    public ColaEE() {
        elementos=new EE();
    }
    
    
    @Override
    public void agrega(T dato) {
        elementos.agregaFinal(dato);
    }

    @Override
    public T quita() {
        return (T) elementos.quitaPrimero();
    }

    @Override
    public T consultaPrimero() {
        Iterator<T> it=elementos.iterator();
        return it.next();
    }

    @Override
    public boolean estaVacia() {
        return elementos.estaVacia();
    }

    @Override
    public String imprimeCola() {
        return elementos.toString();
    }
    
}
