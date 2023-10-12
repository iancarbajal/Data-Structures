public class NodoAVL<T extends Comparable<T>> {
    private NodoAVL<T> der,izq,papa;
    private int fe,h;
    private T dato;


    public NodoAVL(T dato) {
        this.dato=dato;
        der=null;
        izq=null;
        papa=null;
        fe=0;
        h=0;
    }

    public void actualizaAltura(){
        if(izq==null){
            if(der==null){
                h=0;
            }
            else{
                h=der.getH()+1;
            }
        }
        else {
            if(der==null){
                h=izq.getH()+1;
            }
            else{
                if(izq.getH()>=der.getH())
                    h=izq.getH()+1;
                else
                    h=der.getH()+1;
            }
        }
    }

    public void actualizaFe(){
        if(izq==null){
            if(der==null){
                fe=0;
            }
            else{
                fe=der.getH()+1;
            }
        }
        else {
            if(der==null){
                fe=-izq.getH()-1;
            }
            else{
                fe=der.getH()-izq.getH();
            }
        }
    }

    public void cuelga(NodoAVL<T> actual){
        if (actual==null)
          return;
        if(actual.getDato().compareTo(this.dato)<=0)
          izq=actual;
        else
          der=actual; 
        actual.setPapa(this);
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoAVL<T> getDer() {
        return this.der;
    }

    public void setDer(NodoAVL<T> der) {
        this.der = der;
    }

    public NodoAVL<T> getIzq() {
        return this.izq;
    }

    public void setIzq(NodoAVL<T> izq) {
        this.izq = izq;
    }

    public NodoAVL<T> getPapa() {
        return this.papa;
    }

    public void setPapa(NodoAVL<T> papa) {
        this.papa = papa;
    }

    public int getFe() {
        return this.fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public int getH() {
        return this.h;
    }

    public void setH(int h) {
        this.h = h;
    }


    @Override
    public String toString() {
        return "{" +
            " der='" + getDer() + "'" +
            ", izq='" + getIzq() + "'" +
            ", papa='" + getPapa() + "'" +
            ", fe='" + getFe() + "'" +
            ", h='" + getH() + "'" +
            ", dato='" + getDato() + "'" +
            "}";
    }

}
