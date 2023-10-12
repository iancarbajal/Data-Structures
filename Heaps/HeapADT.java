public interface HeapADT<T extends Comparable<T>>{
    public T buscaMin();
    public void inserta(T dato);
    public T borraMin();
    public void cambiaLlave();
}