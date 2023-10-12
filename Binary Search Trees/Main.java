
import java.util.Iterator;
import java.util.Random;

class Main {
  public static void main(String[] args) {
  Iterator<Integer> it;
  ArbolBinarioBusqueda<Integer> arbol=new ArbolBinarioBusqueda<Integer>();
 ///para probar inserto numeros al azar y lo imprimo en inorden (en orden ascendente)
  Random rn = new Random();
  for(int i=0;i<20;i++)
    arbol.inserta(rn.nextInt()%100);
  it=arbol.iteratorInOrden();
  while(it.hasNext())
    System.out.println(it.next());
    
  }
}