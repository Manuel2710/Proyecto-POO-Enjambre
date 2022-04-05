public class Interacciones {
    public static void main(String[] args) throws Exception {
        Recolectores demo = new Recolectores();   
        Defensores demo2 = new Defensores();  
        lista Lista =new lista();
        Lista.insertar(demo);
        Lista.insertar(demo2);
        Lista.mostrar();
    }
}