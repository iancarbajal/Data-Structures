public class Main {
    public static void main(String[] args) throws Exception {
        ArbolAVL<Integer> ar=new ArbolAVL<Integer>();

        ar.inserta(30);
        ar.inserta(2);
        ar.inserta(0);
        ar.inserta(100);
        ar.inserta(90);
        ar.inserta(40);
        ar.inserta(-100);
        ar.inserta(20);
        ar.inserta(1);
        ar.inserta(-110);
        ar.inserta(10);

        ar.borra(2);
        ar.borra(10);

        ar.imprimeArbol();
    }
}
