public class Heap<T extends Comparable<T>> implements HeapADT<T> {
    private T [] datos;
    private int cont;
    private int MAX=50;

    public T [] getDatos(){
        return datos;
    }
    public Heap() {
        cont=1;
        datos=((T []) new Comparable[MAX]);
    }

    @Override
    public T buscaMin(){
        if(cont>0)
            return datos[1];
        return null;
    }

    public int getCont() {
        return this.cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }


    private void expandeCapacidad(){
        MAX=datos.length*2;
        T[] nuevo= (T[]) new Object[MAX];
        
        for(int i=1;i<datos.length;i++)
            nuevo[i]=datos[i];
        datos=nuevo;
    }

    @Override
    public void inserta(T element){

        if (cont+1>=MAX)//expandir tamaño
          expandeCapacidad();
        
        datos[cont] = element;
        //Revisa que esté en la posición correcta
        int aux = cont;
        int dad = aux;
        while(aux > 1 && datos[aux].compareTo(datos[aux>>1]) < 0){
            dad = aux >> 1;
            //Cambiamos las posiciones
            T change = datos[dad];
            datos[dad] = datos[aux];
            datos[aux] = change;
            aux = dad;
        }
        cont++;
    }

    private void arreglaHeap(int actual){
        int mC=actual;
        int izq=actual<<1;
        int der=(actual<<1)+1;

        if(izq>=cont || der>=cont){
            return;
        }
        if(datos[izq].compareTo(datos[mC])<0)
        mC=izq;
        if(datos[der].compareTo(datos[mC])<0)
            mC=der;
        if(mC!=actual){
            T temp=datos[mC];
            datos[mC]=datos[actual];
            datos[actual]=temp;
        }else{
            return;
        }

        arreglaHeap(mC);

    }

    @Override
    public T borraMin() {
        T temp;

        cont--;
        temp=datos[1];
        datos[1]=datos[cont];
        datos[cont]=null;
        arreglaHeap(1);

        return temp;

    }

    @Override
    public void cambiaLlave() {
        // TODO Auto-generated method stub
        
    }

    private int log2(int x){
        return (int) (Math.log(x) / Math.log(2));
    }
    @Override
    public String toString() {
        int altura = log2(cont);  // altura de heap

        StringBuilder hs = new StringBuilder();  // heap string builder
        for(int d = altura; d >= 0; d--) {  // número de niveles
            int numNiv = (int) Math.pow(2, d);  // numero de elem por nivel

            StringBuilder line = new StringBuilder();  // linea string builder
            for(int i = numNiv; i < (int) Math.pow(2, d + 1); i++) {
                if(d != altura) {
                    line.append(" ".repeat((int) Math.pow(2, altura - d)));
                }
                int j = altura - d;
                if(j >= 2) {
                    j -= 2;
                    while(j >= 0) {
                        line.append(" ".repeat((int) Math.pow(2, j)));
                        j--;
                    }
                }

                if(i < cont) {
                    line.append(String.format("%-2s", datos[i])); 
                } else {
                    line.append("--");
                }

                line.append(" ".repeat((int) Math.pow(2, altura - d)));
                j = altura - d;
                if(j >= 2) {
                    j -= 2;
                    while(j >= 0) {
                        line.append(" ".repeat((int) Math.pow(2, j)));
                        j--;
                    }
                }
            }
            hs.insert(0, line.toString() + "\n");
        }
        return hs.toString();
    }

    public boolean isHeap(){
        return isHeap(1);
    }
    private boolean isHeap(int i){
        if (i >= (cont - 1) >>2)
        {
            return true;
        }
        return datos[i].compareTo(datos[i<<1])<=0 && isHeap(i<<1) && isHeap(i<<1+1);
    }

}
