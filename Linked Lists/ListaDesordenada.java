/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author ianca
 * @param <T>
 */
public class ListaDesordenada<T> extends Lista<T> implements ListaDesordenadaADT<T>{

    public ListaDesordenada() {
        super();
    }

    @Override
    public void agregaInicio(T dato) {
        Nodo<T> nuevo= new Nodo(dato);
        nuevo.setSiguiente(primero);
        primero.setAnterior(nuevo);
        primero=nuevo;
    }

    @Override
    public void agregaFinal(T dato) {
        Nodo<T> nuevo= new Nodo(dato);
        nuevo.setAnterior(ultimo);
        ultimo.setSiguiente(nuevo);
        ultimo=nuevo;
    }

    @Override
    public boolean agregaAntesQue(T ref, T dato) {
        boolean r=false;
        Nodo<T> apuntador=primero;
        Nodo<T> nu;
        
        if(!estaVacia()){
            if(apuntador.getDato().equals(ref)){
                agregaInicio(dato);
                r=true;
            }
            else{
                nu=new Nodo(dato);
                while(apuntador.getSiguiente()!=null && !r){
                    apuntador=apuntador.getSiguiente();
                    if(apuntador.getDato().equals(ref)){
                        apuntador.getAnterior().setSiguiente(nu);
                        apuntador.setAnterior(nu);
                        nu.setSiguiente(apuntador);
                        r=true;
                    }
                }

            }
        }
        
        return r;
    }

    @Override
    public boolean agregaDespuesQue(T ref, T dato) {
        boolean r=false;
        Nodo<T> apuntador=primero;
        Nodo<T> nu;
        
        if(!estaVacia()){
            if(apuntador.getDato().equals(ref)){
                nu=new Nodo(dato);
                nu.setAnterior(primero);
                nu.setSiguiente(primero.getSiguiente());
                primero.getSiguiente().setAnterior(nu);
                primero.setSiguiente(nu);
                
                r=true;
            }
            else{
                nu=new Nodo(dato);
                while(apuntador.getSiguiente()!=null && !r){
                    apuntador=apuntador.getSiguiente();
                    if(apuntador.getDato().equals(ref)){
                        nu.setAnterior(apuntador);
                        nu.setSiguiente(apuntador.getSiguiente());
                        apuntador.getSiguiente().setAnterior(nu);
                        apuntador.setSiguiente(nu);
                        r=true;
                    }
                }

            }
        }
        
        return r;
    }
    
}
