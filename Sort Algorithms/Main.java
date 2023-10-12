import java.lang.reflect.Array;
import java.util.Arrays;

import util.AlgoritmosO;

public class Main {

    public static <T> void printA(T [] datos){
        for (int i=0;i<datos.length;i++)
            System.out.println(datos[i].toString());
    }
    
    public static void main(String[] args) {
        Ordenar a = new Ordenar();
        Pelicula[] orden=a.getPeliculasOrdenadas(); //orden numero serie 
        Pelicula[] ordenInverso=a.getPeliculasOrdenadasInverso();
        Pelicula[] ordenAleatorio=a.getPeliculasOrdenAleatorio();
        Integer[] ene ={100,1000,5000,10000,17770};

        // n=100;n=1000;n=5000;n=10000;n=17770

        Pelicula[][] o={Arrays.copyOf(orden, 100),
                        Arrays.copyOf(orden, 1000),
                        Arrays.copyOf(orden, 5000),
                        Arrays.copyOf(orden, 10000),
                        Arrays.copyOf(orden,orden.length),
                        Arrays.copyOf(ordenInverso, 100),
                        Arrays.copyOf(ordenInverso, 1000),
                        Arrays.copyOf(ordenInverso, 5000),
                        Arrays.copyOf(ordenInverso, 10000),
                        Arrays.copyOf(ordenInverso,17770),
                        Arrays.copyOf(ordenAleatorio, 100),
                        Arrays.copyOf(ordenAleatorio, 1000),
                        Arrays.copyOf(ordenAleatorio, 5000),
                        Arrays.copyOf(ordenAleatorio, 10000),
                        Arrays.copyOf(ordenAleatorio,17770)};


        //cambiar limite for para tener orden 
        // i=0;i<5 orden
        //i=5; i<10 ordenInverso
        //i=10;i<15 ordenAleatorio
        System.out.println("selection sort \nn,micro segundos");
        int c=0;
        for(int i=5;i<10;i++){
            long startTime = System.nanoTime();
            AlgoritmosO.seleccionD(o[i]);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);

            
            System.out.println(ene[c++]+","+duration/1000.0);
        }
        System.out.println("insertion sort \nn,micro segundos");
        c=0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            AlgoritmosO.insertionD(o[i]);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);

            System.out.println(ene[c++] + "," + duration/1000.0);
        }
        c=0;
        System.out.println("quick sort \nn,micro segundos");
        for(int i=0;i<5;i++){
            long startTime = System.nanoTime();
            AlgoritmosO.quickSort(o[i]);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);

            
            System.out.println(ene[c++]+","+duration/1000.0);
        }
        c=0;
        System.out.println("merge sort \nn,micro segundos");
        for(int i=0;i<5;i++){
            long startTime = System.nanoTime();
            AlgoritmosO.mergeSort(o[i]);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);

            
            System.out.println(ene[c++]+","+duration/1000.0);
        }

    }
}
