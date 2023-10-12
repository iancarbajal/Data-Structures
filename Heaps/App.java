public class App {
    public static void main(String[] args) throws Exception {
        Heap<Integer> h= new Heap<Integer>();

        h.inserta(1);
        h.inserta(6);
        h.inserta(8);
        h.inserta(4);
        h.inserta(5);
        h.inserta(7);
        h.inserta(10);
        h.inserta(3);
        h.inserta(9);
        h.inserta(2);
        h.inserta(15);

       System.out.println(h.toString());


    }
}
