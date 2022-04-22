import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ListaPixeles extends JPanel {
        private List<pintar> pintar;
        //Crea una lista
        public ListaPixeles() {
            pintar = new ArrayList<pintar>();
    }
        //Agrega el nuevo elemento a la lista
        public void Agregar(pintar x) {
            pintar.add (x);
            repaint();
    }
        //Elimina el ultimo elemento agregado
        public void Eliminar() {
            pintar.remove (pintar.size() - 1);
            repaint();
            }
        //llama la función para imprimir el cubo
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            for (pintar x: pintar){
                x.PintarPixel(g);
        }
    }    
    }

