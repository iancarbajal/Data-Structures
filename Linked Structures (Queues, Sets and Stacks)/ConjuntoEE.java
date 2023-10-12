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
public class ConjuntoEE<T> implements ConjuntoADT<T>{
    EE elementos;

    public ConjuntoEE() {
        elementos=new EE();
    }
    
    
    
    @Override
    public Iterator<T> iterator() {
        return elementos.iterator();
    }

    @Override
    public boolean agrega(T dato) {
        elementos.agregaFinal(dato);
        return true;
    }

    @Override
    public T quita(T dato) {
        Iterator<T> it=elementos.iterator();
        boolean r=true;
        T aux,res;
        aux= null;
        
        if(elementos.estaVacia())
            throw new ExcepcionColeccionVacia("Conjunto Vacio");
        
        while(it.hasNext() && r){
            aux=it.next();
            if(aux.equals(dato)){
                elementos.eliminaAnteriorA(it.next());
                r=false;
            }
        }
        return aux;
        
        
        
    }

    @Override
    public boolean contiene(T elemento) {
        Iterator<T> it=elementos.iterator();
        boolean b=true;
        T aux;
        
        while(it.hasNext() && b){
            aux=it.next();
            if(aux.equals(elemento)){
                b=false;
            }
        }
        return !b;
    }

    @Override
    public int getCardinalidad() {
        return elementos.calculaTamanio();
    }

    @Override
    public boolean esVacio() {
        return elementos.estaVacia();
    }
    
}
