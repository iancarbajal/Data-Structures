/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author ianca
 */
public class ManejadorPilas {
    
    public static <T> int cuentaElementos(PilaADT<T> pila){
        PilaADT<T> aux= new PilaA();
        int c=0;
        
        while(!pila.isEmpty()){
            aux.push(pila.pop());
            c++;
        }
        while(!aux.isEmpty())
            pila.push(aux.pop());
        
        return c;
    }
    
    public static <T> void invierteOrden(PilaADT<T> pila){
        int c=cuentaElementos(pila);
        T [] elementos=(T[]) new Object[c];
        
        for(int i=0; i<c;i++)
            elementos[i]=pila.pop();
        
        for(int j=0; j<c;j++)
            pila.push(elementos[j]);
        
    } 
    
    public static <T> boolean contiene(PilaADT<T> p1,PilaADT<T> p2){ // p1 contiene a p2
        boolean r,b;
        T [] datos;
        PilaADT<T> aux=new PilaA();
        int cant,c,h;
        
        cant=cuentaElementos(p2);
        datos= (T[]) new Object[cant];
        c=0;
        r=false;
        
        for(int i=0;i<cant;i++)
            datos[i]=p2.pop();
        
        while(!p1.isEmpty() && c!=cant){
            b=true;
            h=0;
            while(h<cant && b){
                if(datos[h].equals(p1.peek())){
                    c++;
                    b=false;
                }
                h++;
            }
            aux.push(p1.pop());
        }
        if(c==cant)
            r=true;
        
        for(int k=0;k<cant;k++)
            p2.push(datos[k]);
        
        while(!aux.isEmpty())
            p1.push(aux.pop());
        
        return r;
    }
    
    public static <T> void quitaElementos(PilaADT<T> pila,int n){
        int numElementos=0;
        PilaADT<T> aux= new PilaA();
        
        while(!pila.isEmpty()){
            aux.push(pila.pop());
            numElementos++;
        }
        
        while(!aux.isEmpty())
            pila.push(aux.pop());
        
        if(n<=numElementos){
            for(int i=0;i<n;i++)
                pila.pop();
        }
        
        
    }
}
