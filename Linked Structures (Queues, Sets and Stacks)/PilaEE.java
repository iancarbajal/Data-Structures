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
 * @param <T>
 */
public class PilaEE<T> implements PilaADT<T>{
    private EE elementos;
    private T tope;

    public PilaEE() {
        elementos=new EE();
        tope=null;
    }
    @Override
    public boolean isEmpty(){
        return elementos.estaVacia();
    }
    @Override
    public void push(T dato){
        elementos.agregaInicio(dato);
        tope=dato;
    }
    @Override
    public T pop(){
        T r=(T) elementos.quitaPrimero();
        Iterator<T> it=elementos.iterator();
        tope=it.next();
            
        return r;
    }

    @Override
    public T peek() {
        return tope;
    }

    public String toString(){
        return elementos.toString();
    }
    
    
}
