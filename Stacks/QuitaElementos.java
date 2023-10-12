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
public class QuitaElementos {
    
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
