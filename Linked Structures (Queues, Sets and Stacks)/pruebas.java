/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura.enlazada;

/**
 *
 * @author ianca
 */
public class pruebas {
    public static void main(String[] args) {
        EE<String> es=new EE();
        es.agregaInicio("Ian");
        es.agregaInicio("Aldo");
        es.agregaInicio("Jaqueline");
        es.agregaInicio("Gus");
        
        System.out.println(es.insertaAntesQue("Jaqueline", "Romy"));
        
        System.out.println(es.toString());
        System.out.println(es.calculaTamanio());
    }
}
