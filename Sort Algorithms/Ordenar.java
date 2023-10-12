import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import util.AlgoritmosO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Ordenar {
    private ArrayList<Pelicula> datos;

    public Ordenar(){
        datos= new ArrayList<Pelicula>();
        File a=new File("movie_titles2.txt");
        try(Scanner l=new Scanner(a)){
            while(l.hasNext()){
                Pelicula aux=new Pelicula();
                String [] aux1;
                aux1=l.nextLine().split(",");

                aux.setNumS(Integer.parseInt(aux1[0]));
                aux.setReleaseY(Integer.parseInt(aux1[1]));
                aux.setName(aux1[2]);
                datos.add(aux);
            }
            l.close();

        }
        catch (FileNotFoundException fnfe) {
			System.err.println("Error"+fnfe);
			System.exit(-1);
		}
    }

    public Pelicula[] getPeliculasOrdenadas(){
        Pelicula [] aux=new Pelicula[datos.size()];
        AlgoritmosO.mergeSort(datos.toArray(aux));
        return aux;
    }

    public Pelicula[] getPeliculasOrdenadasInverso(){
        Pelicula[] newArr = new Pelicula[datos.size()];
        Pelicula[] arr=this.getPeliculasOrdenadas();
        for (var i = 0; i < arr.length; i++) {      
            newArr[i] = arr[arr.length - i - 1];
        }   
        return newArr;
    }

    public Pelicula[] getPeliculasOrdenAleatorio(){
        Pelicula [] a2= new Pelicula[datos.size()];
        Pelicula [] aux= new Pelicula[datos.size()];
        int max=datos.size()+1;

        datos.toArray(a2);
        for(int i=0; i<datos.size();i++){
            int randomNum = ThreadLocalRandom.current().nextInt(0,max);
            aux[i]=a2[randomNum];
            Pelicula temp = a2[randomNum];
            a2[randomNum] = a2[max-2];
            a2[max-2] = temp;
            max--;
        }
        return aux;

    }
}
