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
public class Prueba {
    
    public static void main(String[] args) {
        PilaADT<Integer> p= new PilaA();
        PilaADT<Integer> p2= new PilaA();
        
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        p.push(6);
        p.push(7);
        p.push(8);
        p.push(9);
        p.push(10);
        
        p2.push(7);
        p2.push(10);
        p2.push(5);
        p2.push(2);
        p2.push(1);
        
        p2.multiPop(7);
        System.out.println(p2.toString());
    }
    
}
