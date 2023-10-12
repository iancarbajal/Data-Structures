/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author ianca
 * @param <T>
 */
public class PilaA<T> implements PilaADT<T>{
    private T[] elementos ;
    private int tope;
    private final int MAX=20;

    public PilaA() {
        elementos= (T[]) new Object[MAX];
        tope=-1;
    }
    public PilaA(int max) {
        elementos= (T[]) new Object[max];
        tope=-1;
    }
    @Override
    public boolean isEmpty(){
        return tope==-1;
    }
    @Override
    public T peek(){
        if(isEmpty())
            throw new ExcepcionColeccionVacia("Pila vacia. No se puede consultar");
        
        return elementos[tope];
        
    }
    @Override
    public T pop(){
        T dato;
        
        if(isEmpty())
            throw new ExcepcionColeccionVacia("Pila vacia. No se puede consultar");
        
        dato=elementos[tope];
        elementos[tope]=null;
        tope--;
        return dato;
            
    }
    
    @Override
    public void push(T dato){
        if (tope==elementos.length-1)
            aumentaCapacidad();
        tope++;
        elementos[tope]=dato;
        
    }
    
    @Override
    public void multiPop(int n){
        int numElementos=tope+1;
        
        if(n<=numElementos){
            for(int i=0;i<n;i++)
                this.pop();
        }
    }
    
    private void aumentaCapacidad(){
        T[] nuevo = (T[]) new Object[elementos.length*2];
        for (int i=0; i<=tope;i++)
            nuevo[i]=elementos[i];
        
        elementos=nuevo;
        
    }

    @Override
    public String toString() {
        StringBuilder c= new StringBuilder();
        
        c.append("\nElementos de la pila: ");
        for(int i=tope;i>=0;i--)
            c.append("\n"+elementos[i].toString());
        
        return c.toString();
    }
    
    
}
