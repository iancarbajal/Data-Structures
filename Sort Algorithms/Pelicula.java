/* Ian Carbajal
25/02/2022
Clase para almacenar los datos peliculas(movie_titles2.txt) 
*/
public class Pelicula implements Comparable<Pelicula>{
    private int numS;
    private int releaseY;
    private String name;

    public Pelicula(){
        numS=0;
        releaseY=0;
        name="vacio";
    }

    public int getNumS(){
        return numS;
    }
    public int getReleaseY(){
        return releaseY;
    }
    public String getName(){
        return name;
    }

    public void setNumS(int n){
        numS=n;
    }
    public void setReleaseY(int ry){
        releaseY=ry;
    }
    public void setName(String na){
        name=na;
    }

    public String toString(){
        return ""+numS+","+releaseY+","+name;
    }
    public int compareTo(Pelicula otra){
        return numS-otra.numS;
    }
}