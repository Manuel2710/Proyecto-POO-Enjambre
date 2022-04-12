import java.util.ArrayList;

public class Interacciones {
    public static void main(String[] args) throws Exception {
        ArrayList<Agentes> misAgentes = new ArrayList<>();  
        int x;
        int y=10;
        for(x=0;x<y;x++){
            misAgentes.add(new Recolectores());
            misAgentes.add(new Defensores());
        }
        y=y*2;//Como se agregaron de 2 en 2 se debe duplicar para correr toda la lista
        for(x=0;x<y;x++){
            System.out.println("Vuelta: " + x);
            misAgentes.get(x).DetectarAgente();
        }
        
    }
}