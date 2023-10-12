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
public class Lista<T> implements ListaADT<T> {
    
    protected Nodo<T> primero;
    protected Nodo<T> ultimo;

    public Lista() {
        primero=null;
        ultimo=null;
    }
            
    
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista(primero);
    }

    @Override
    public boolean estaVacia() {
        return primero==null;
    }

    @Override
    public T quitaPrimero() {
        Nodo<T> apuntador=primero;
        T dato;
        
        if(estaVacia())
            throw new ExcepcionColeccionVacia("No hay elementos!");
        
        dato=primero.getDato();
        primero=primero.getSiguiente();
        primero.setAnterior(null);
        apuntador.setSiguiente(null);
        return dato;
        
    }

    @Override
    public T quitaUltimo() {
        if (estaVacia())
            throw new ExcepcionColeccionVacia("No hay Elementos!");
        T dato=ultimo.getDato();
        Nodo<T> apuntador=ultimo;
        ultimo=ultimo.getAnterior();
        ultimo.setSiguiente(null);
        apuntador.setAnterior(null);
        return dato;
        
    }

    @Override
    public T quita(T dato) {
        Nodo<T> apuntador=primero;
        T res=null;
        boolean b=true;
        
        if(estaVacia())
            throw new ExcepcionColeccionVacia("No hay Elementos!");
        
        if(apuntador.getDato().equals(dato))
            res=quitaPrimero();
        else{
            if(ultimo.getDato().equals(dato))
                res=quitaUltimo();
            else{
                while(apuntador.getSiguiente()!=null && b){
                    apuntador=apuntador.getSiguiente();
                    if(apuntador.getDato().equals(dato)){
                        res=apuntador.getDato();
                        b=false;
                        apuntador.getAnterior().setSiguiente(apuntador.getSiguiente());
                        apuntador.getSiguiente().setAnterior(apuntador.getAnterior());
                        apuntador.setAnterior(null);
                        apuntador.setSiguiente(null);
                    }
                }
            }
        }
        return res;
    }

    @Override
    public boolean contiene(T dato) {
        Nodo<T> apuntador=primero;
        boolean b=false;
        
        if(estaVacia())
            throw new ExcepcionColeccionVacia("No hay Elementos!");
        
        if(apuntador.getDato().equals(dato) || ultimo.getDato().equals(dato))
            b=true;
        else{
            while(apuntador.getSiguiente()!=null && !b){
                apuntador=apuntador.getSiguiente();
                if(apuntador.getDato().equals(dato)){
                    b=true;
                }
            }
        }
        return b;
    }

    @Override
    public int calculaTamanio(){
        Nodo<T> apuntador=primero;
        int r=0;
        if(!estaVacia())
            r=calculaTamanio(apuntador,1);
        
        return r;
    }
    private int calculaTamanio(Nodo<T> apuntador,int n){
        if(apuntador.getSiguiente()==null)
            return n;
        else{
            apuntador=apuntador.getSiguiente();
            return calculaTamanio(apuntador, n+1);
        }
        
    }

    @Override
    public T obtienePrimero() {
        return primero.getDato();
    }

    @Override
    public T obtieneUltimo() {
        return ultimo.getDato();
    }
    
}
