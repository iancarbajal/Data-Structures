package util;

public class AlgoritmosO{

    public static <T extends Comparable<T> > void seleccionD(T [] datos){
        int pm;
		
		for(int i=0;i<datos.length;i++) {
			pm=i;
            for (int j = i+1; j < datos.length; j++)
                if (datos[j].compareTo(datos[pm])<0)
                    pm = j;
            T temp = datos[i];
            datos[i] = datos[pm];
            datos[pm] = temp;
		}
    }

    public static <T extends Comparable<T> > void insertionD(T [] datos){
        int i, j;

        for (i=1; i<datos.length; i++){
            j = i;
            while (j>0 && datos[j].compareTo(datos[j-1])<0){
                T temp = datos[j];
                datos[j] = datos[j-1];
                datos[j-1] = temp;
                j--;
            }
        }
    }

    public static <T extends Comparable<T> > void bubbleS(T [] datos){
        for (int j=datos.length-1; j>0; j--) {
            for(int i=0; i<j; i++){
                if(datos[i].compareTo(datos[i+1]) > 0){
                    T temp = datos[i];
                    datos[i] = datos[i+1];
                    datos[i+1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T> > void quickSort(T [] datos){
        quickSort(datos, 0, datos.length-1);
    }
    private static <T extends Comparable<T> > void quickSort(T [] datos, int min, int max){
        int pos;
        if(min<max){
            pos=partition(datos,min,max);
            if(pos-min<=max-pos+1){
                quickSort(datos, min, pos);
                min=pos+1;
            }
            else{
                quickSort(datos, pos+1, max);
                max=pos;
            }   
        }       
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {

        T pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j].compareTo(pivot)<0)
            {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
  
        return i+1;
    }

    public static <T extends Comparable<T>> void mergeSort(T [] datos){
        mergeSort(datos,datos.length);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        T[] l = (T[]) new Comparable[mid];
        T[] r = (T[]) new Comparable[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        int right=n-mid;
        int left=mid;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].compareTo(r[j])<= 0) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}