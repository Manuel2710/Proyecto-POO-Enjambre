import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class TelaPrincipal extends JFrame{
    private ListaPixeles pixeles;

    public TelaPrincipal(){
        pixeles = new ListaPixeles();
        JButton crearpixel = new JButton("Interactuar");

        crearpixel.addActionListener (new ActionListener () {    
            @Override
            public void actionPerformed (ActionEvent e) {
                int dx = 1;
                int dy = 1;
                int x = (int) (pixeles.getWidth() * Math.random());
                int y = (int) (pixeles.getHeight() * Math.random());
                Pintar q = new Pintar(x, y, dx, dy);
                pixeles.Agregar(q);
            }
        });
    /*
        JButton undo = new JButton("Undo");
            undo.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                pixeles.Eliminar();
            }
        });
*/
        add(pixeles);
        add(crearpixel,BorderLayout.NORTH);
        //add(undo,BorderLayout.SOUTH);
    }
    public static void main(String[] args){
        JFrame fAPP = new TelaPrincipal();
        fAPP.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fAPP.setSize(600,500);
        fAPP.setVisible(true);
    }
}
