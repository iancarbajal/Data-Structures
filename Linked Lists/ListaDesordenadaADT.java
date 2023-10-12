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
public interface ListaDesordenadaADT<T> extends ListaADT<T> {
    public void agregaInicio(T dato);
    public void agregaFinal(T dato);
    public boolean agregaAntesQue(T ref, T dato);
    public boolean agregaDespuesQue(T ref, T dato);
}
