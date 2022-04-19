import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ListaPixeles extends JPanel {
        private List<Pintar> pintar;

        public ListaPixeles() {
            pintar = new ArrayList<Pintar>();
    }

        public void Agregar(Pintar x) {
            pintar.add (x);
            repaint();
    }

        public void Eliminar() {
            pintar.remove (pintar.size() - 1);
            repaint ();
            }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            for (Pintar x: pintar){
                x.desenhar(g);
        }
    }    
    }

