import java.util.Iterator;
public interface ArbolAVLADT<T extends Comparable<T>> {
    public void inserta(T elem);
    public void borra(T elem);
    public boolean isEmpty();
    public boolean contains( T elem);
    public Iterator<T> iteratorPreOrden();
    public Iterator<T> iteratorPostOrden();
    public Iterator<T> iteratorInOrden();
}
