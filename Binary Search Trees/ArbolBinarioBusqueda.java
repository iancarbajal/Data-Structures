import java.util.*;

public class 
ArbolBinarioBusqueda<T extends Comparable<T>> implements BinarySearchTreeADT<T>{ 
  
NodoBB<T> raiz ;
int cont;
public ArbolBinarioBusqueda(){
  raiz=null;
  cont=0;
}
public ArbolBinarioBusqueda(T elem){
    raiz=new NodoBB<T>(elem);
    cont=1;
}

//////

public boolean isEmpty(){
    return cont==0;
  }
  
  public int size(){
    return cont;
  }
  


  public Iterator<T> iteratorPreOrden(){
    ArrayList<T> lista=new ArrayList<T>();
    preOrden(raiz,lista);
    return lista.iterator();

  }
  private void preOrden(NodoBB<T> actual,ArrayList<T> lista){
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
    private void inOrden(NodoBB<T> actual,ArrayList<T> lista){
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
  private void postOrden(NodoBB<T> actual,ArrayList<T> lista){
      if(actual==null)
          return;
      postOrden(actual.getIzq(),lista);
      postOrden(actual.getDer(),lista);
      lista.add(actual.getElem());//esto fue visitar

      
  }



///////  
public boolean contains(T elem){
      return busca(raiz, elem)!=null;
}
private NodoBB<T> busca(NodoBB<T> arbolito, T elementito){
  if(arbolito == null)
    return arbolito;
  if(arbolito.getElem().compareTo(elementito)<0)
    return busca(arbolito.getDer(), elementito);
  if(arbolito.getElem().compareTo(elementito)>0)
    return busca(arbolito.getIzq(), elementito);
  return arbolito;
}
private NodoBB<T> search(NodoBB<T> tree, T element){
        if(tree == null)
            return null;
        
        NodoBB<T> aux;
        if(tree.getElem().compareTo(element) == 0){
            return tree;
        } else {
            if(tree.getElem().compareTo(element) > 0){
                aux = search(tree.getIzq(), element);
                return aux;
            } else {
                aux = search(tree.getDer(), element);
                return aux;
            }
        }
    }
 public void inserta(T elem){
   NodoBB<T> actual=raiz,anterior=raiz;
   if(raiz==null){
     raiz=new NodoBB<T>(elem);
     cont++;
     return;
   }

  while(actual!=null){
    anterior=actual;
    if(elem.compareTo(actual.getElem())<=0)
      actual=actual.getIzq();
    else
      actual=actual.getDer();
    }
    anterior.cuelga(new NodoBB<T>(elem));
    cont++;
   
 }

 private NodoBB insertaABB(T elem){
  NodoBB<T> actual=raiz,anterior=raiz;
  if(raiz==null){
    raiz=new NodoBB<T>(elem);
    cont++;
    return;
  }

 while(actual!=null){
   anterior=actual;
   if(elem.compareTo(actual.getElem())<=0)
     actual=actual.getIzq();
   else
     actual=actual.getDer();
   }
   anterior.cuelga(new NodoBB<T>(elem));
   cont++;
  
}

 public void inserta(T dato){
    NodoBB<T> actual=insertaABB(dato),papa;
    boolean f=false;
    if(busca(raiz, dato)!=null)
      return;

    while(!f && actual!=raiz){
      papa=actual.getPapa();
      if(actual.getElem().compareTo(papa.getElem())<0)
        papa.fe--;
      else
        papa.fe++;

      if(papa.fe==0)
        f=true;
      if(Math.abs(papa.fe)>1){
        ?=rota(?);
      }
      actual=papa;
    }
    
    
 }


}//fin clase
