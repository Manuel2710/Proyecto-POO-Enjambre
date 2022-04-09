import java.util.ArrayList;

public class Interacciones {
    public static void main(String[] args) throws Exception {
        ArrayList<Agentes> misAgentes = new ArrayList<>();  
        int x;
        for(x=0;x<20;x++){
            misAgentes.add(new Recolectores());
            misAgentes.add(new Defensores());
            System.out.println("Vuelta: " + x);
            misAgentes.get(x).DetectarRecurso();
        }
        
    }
}