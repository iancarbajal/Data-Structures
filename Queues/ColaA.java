/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;


/**
 *
 * @author ianca
 * @param <T>
 */
public class ColaA<T> implements ColaADT<T> {
    private T[] datos;
    private int fin;
    private int frente;
    private final int MAX=20;

    
    public ColaA() {
        datos= (T[]) new Object[MAX];
        frente=-1;
        fin=-1;
    }
    public ColaA(int max) {
        datos= (T[]) new Object[max];
        frente=-1;
        fin=-1;
    }
    @Override
    public boolean estaVacia(){
        return frente==-1 && fin==-1;
    }
    @Override
    public T consultaPrimero(){
        if(estaVacia())
            throw new ExcepcionColeccionVacia("Cola sin Elementos");
        return datos[frente];
        
    }
    @Override
    public void agrega(T dato){
        if(frente==0 && fin==datos.length || (frente+1)==fin)
            expandeCapacidad();
        fin=(fin+1)%datos.length;
        datos[fin]=dato;
        if(frente==-1)
            frente=0;
    }
    public void expandeCapacidad(){
        T[] nuevo= (T[]) new Object[datos.length*2];
        
        for(int i=0;i<datos.length;i++)
            nuevo[i]=datos[(frente+1)%datos.length];
        
        frente=0;
        fin=datos.length-1;
                
        datos=nuevo;
        
    }
    @Override
    public T quita(){
        if(estaVacia())
            throw new ExcepcionColeccionVacia("Cola sin Elementos");
        T resultado=datos[frente];
        if(frente==fin){
            frente=-1;
            fin=-1;
        }
        else
            frente=(frente+1)%datos.length;
        
        return resultado;
    }
    
    @Override
    public String imprimeCola(){
        StringBuilder c=new StringBuilder();
        int i=frente;
        
        if(!this.estaVacia()){
            while(i!=fin){
                c.append("").append(datos[i]);
                i= i++ %datos.length;
            }
        }
            
        
        return c.toString();
    }   
}
