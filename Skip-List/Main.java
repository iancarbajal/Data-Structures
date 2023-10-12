import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        SkipList<Integer> sl =new SkipList<>();
        ArrayList<Integer> li=new ArrayList<>();
        long promDu=0;
        Random generador= new Random(7857857);

        for(int j=1;j<50;j++){
            long startTime = System.nanoTime();
            for(int i=1; i<=1000000;i++)
                sl.inserta(generador.nextInt());
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);

            promDu+=duration;
        }
        promDu= promDu/50;

        
        System.out.println(promDu/1000.0+" microsegundos.");

        for(int j=1;j<50;j++){
            long startTime = System.nanoTime();
            for(int i=1; i<=1000000;i++)
                li.add(generador.nextInt());
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);

            promDu+=duration;
        }
        promDu= promDu/50;

        
        System.out.println(promDu/1000.0+" microsegundos.");


    }
}
