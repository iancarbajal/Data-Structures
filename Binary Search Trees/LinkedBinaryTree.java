import java.util.*;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>{
NodoBin<T> raiz;
 int cont;
  LinkedBinaryTree(){
    raiz=null;
    cont=0;
  }
  LinkedBinaryTree(T elem){
    raiz=new NodoBin<T>(elem);
    cont=1;
  }
  public boolean isEmpty(){
    return cont==0;
  }
  public int size(){
    return cont;
  }
  public boolean contains(T elem){
      return contains(elem, raiz);
  }
  
  private boolean contains(T otro, NodoBin<T> hoja){
    if(hoja==null)
      return false;
    
    if(hoja.elem.equals(otro))
      return true;  
    
   boolean temp=contains(otro, hoja.izq);
    if(!temp)
      temp=contains(otro,hoja.der);
    return temp;    
  }


  public Iterator<T> iteratorPreOrden(){
    ArrayList<T> lista=new ArrayList<T>();


    preOrden(raiz,lista);
    return lista.iterator();

  }
  private void preOrden(NodoBin<T> actual,ArrayList<T> lista){
      if(actual==null)
          return;
      lista.add(actual.getElem());//esto fue visitar
      preOrden(actual.getIzq(),lista);
      preOrden(actual.getDer(),lista);

  }
    public Iterator<T> iteratorInOrden(){
    ArrayList<T> lista=new ArrayList<T>();
    inOrden(raiz,lista);      

    return lista.iterator();

  }
    private void inOrden(NodoBin<T> actual,ArrayList<T> lista){
      if(actual==null)
          return;
      inOrden(actual.getIzq(),lista);
      lista.add(actual.getElem());//esto fue visitar
      inOrden(actual.getDer(),lista);
  }

public Iterator<T> iteratorPostOrden(){
    ArrayList<T> lista=new ArrayList<T>();
    postOrden(raiz,lista);
    return lista.iterator();

  }
  private void postOrden(NodoBin<T> actual,ArrayList<T> lista){
      if(actual==null)
          return;
      postOrden(actual.getIzq(),lista);
      postOrden(actual.getDer(),lista);
      lista.add(actual.getElem());//esto fue visitar

      
  }

  

  

}