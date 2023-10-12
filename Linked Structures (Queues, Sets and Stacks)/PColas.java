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
public class PColas {
    public static void main(String[] args) {
        ColaADT<String> p=new ColaEE();
        p.agrega("Hola");
        p.agrega("como");
        p.agrega("estas?");
        
        System.out.println(p.imprimeCola());
        p.quita();
        System.out.println(p.consultaPrimero());
    }
}
