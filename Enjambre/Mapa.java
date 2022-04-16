import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mapa implements ActionListener {
    JFrame ventana;
    JButton Interactuar;
    JPanel PanelBoton;
    Interacciones Interaccion = new Interacciones();

    public Mapa(){
        ventana = new JFrame("Simulación");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarComponentes();
    
        ventana.pack();
        ventana.setVisible(true);
    }
    private void agregarComponentes(){
        Interactuar = new JButton("Interactuar");
        Interactuar.addActionListener(this);

        PanelBoton = new JPanel();
        PanelBoton.setLayout(new GridLayout(15, 1));

        PanelBoton.add(Interactuar);

        ventana.add(PanelBoton, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(Interactuar)){
            Interaccion.MoverAgente();
            Interaccion.DetectarAgente();
            Interaccion.DetectarAmenaza();
            Interaccion.DetectarRecurso();
            Interaccion.DetectarObstaculo();
        }
        
    }
}
