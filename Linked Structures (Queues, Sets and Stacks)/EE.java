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
public class EE<T> implements Iterable<T>{
    
    private Nodo<T> primero;

    public EE() {
        primero=null;
    }
    
    public boolean estaVacia(){
        return primero==null;
    }
    
    public void agregaInicio(T dato){
        Nodo<T> nuevo=new Nodo(dato);
        
        nuevo.setSiguiente(primero);
        primero=nuevo;
    }
    public void agregaFinal(T dato){
        if(estaVacia())
            agregaInicio(dato);
        else{
            Nodo<T> nuevo=new Nodo(dato);
            Nodo<T> apuntador=primero;
            
            while(apuntador.getSiguiente()!=null)
                apuntador=apuntador.getSiguiente();
            apuntador.setSiguiente(nuevo);
        }
            
    }
    public T quitaPrimero(){
        if(estaVacia())
            throw new ExcepcionColeccionVacia("No hay datos");
        T dato=primero.getDato();
        Nodo<T> apuntador=primero;
        primero=primero.getSiguiente();
        apuntador.setSiguiente(null);
        return dato;
    }
    
    public T quitaUltimo(){
        Nodo<T> apuntador= primero;
        Nodo<T> anterior=null;
        T res;
        
        if(estaVacia()){
            throw new ExcepcionColeccionVacia("No hay datos");
        }
        
        if(primero.getSiguiente()==null)
            res=quitaPrimero();
        else{
            while(apuntador.getSiguiente()!=null){
                anterior=apuntador;
                apuntador=apuntador.getSiguiente();
            }
            res=apuntador.getDato();
            anterior.setSiguiente(null);
            
        }
        return res;
            
    }
    
    public boolean eliminaSiguienteDe(T info){
        boolean r=false;
        Nodo<T> apuntador=primero;
        Nodo<T> sig=null;
        
        if (estaVacia())
            throw new ExcepcionColeccionVacia("NO hay datos!");
        
        if(!apuntador.getDato().equals(info)){
            while(!apuntador.getDato().equals(info) && !r){
                apuntador=apuntador.getSiguiente();
                if(apuntador.getDato().equals(info)){
                    if(apuntador.getSiguiente()!=null){
                        r=true;
                        sig=apuntador.getSiguiente();
                        apuntador.setSiguiente(sig.getSiguiente());
                        sig.setSiguiente(null);
                    }
                }
            }
            
        }
        else{
            if(apuntador.getDato().equals(info)){
                r=true;
                sig=apuntador.getSiguiente();
                apuntador.setSiguiente(sig.getSiguiente());
                sig.setSiguiente(null);
            }
                
        }
        return r;
    }
    
    public boolean eliminaAnteriorA(T info){
        boolean r=false;
        boolean pv=true;
        Nodo<T> apuntador=primero;
        Nodo<T> anteriorDato=null;
        Nodo<T> aAnterior;
        
        if (estaVacia())
            throw new ExcepcionColeccionVacia("NO hay datos!");
        
        if(!apuntador.getDato().equals(info)){
            while(apuntador.getSiguiente()!=null && !r){
                if(pv){
                    anteriorDato=apuntador;
                    apuntador=apuntador.getSiguiente();
                    if(apuntador.getDato().equals(info)){
                        primero=apuntador;
                        anteriorDato.setSiguiente(null);
                        r=true;
                    }
                    pv=false;
                }
                else{
                    aAnterior=anteriorDato;
                    anteriorDato=apuntador;
                    apuntador=apuntador.getSiguiente();
                    if(apuntador.getDato().equals(info)){
                        aAnterior.setSiguiente(apuntador);
                        r=true;
                    }
                }
            }
        }
        return r;
        
    }
    public boolean insertaAntesQue(T ref, T nuevo){
        boolean r=false;
        Nodo<T> apuntador=primero;
        Nodo<T> ant;
        Nodo<T> nu;
        
        if(!estaVacia()){
            if(apuntador.getDato().equals(ref)){
                agregaInicio(nuevo);
                r=true;
            }
            else{
                nu=new Nodo(nuevo);
                while(apuntador.getSiguiente()!=null && !r){
                    ant=apuntador;
                    apuntador=apuntador.getSiguiente();
                    if(apuntador.getDato().equals(ref)){
                        ant.setSiguiente(nu);
                        nu.setSiguiente(apuntador);
                        r=true;
                    }
                }

            }
        }
        
        return r;
    }
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
    public String toString(){
        StringBuilder c= new StringBuilder();
        
        for(Iterator<T> it= iterator(); it.hasNext();){
            c.append(it.next().toString());
            c.append("\n");
        }
        return c.toString();
    }
    @Override
    public Iterator<T> iterator(){
        return new IteradorEE<>(primero);
    }
    
}
