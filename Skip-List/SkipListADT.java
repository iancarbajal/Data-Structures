public interface SkipListADT<T extends Comparable<T>> {
    public void inserta(T elem);
    public NodoSkip<T> busca(T elem);
    public void borra(T elem);
}
