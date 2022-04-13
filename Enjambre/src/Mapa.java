import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mapa implements ActionListener{
    JFrame ventana;

    ImageIcon koalaIcon;
    ImageIcon orangutanIcon;

    JLabel imagen;
    JPanel panelImagen;

    JButton botonKoala;
    JButton botonOrangutan;

    JPanel panelBotones;

    public Mapa(){
        ventana = new JFrame("Demo de GUI con Swing");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(50, 50);
        agregarComponentes();
        
        ventana.pack();
        ventana.setVisible(true);
    }

    private void agregarComponentes(){
        //koalaIcon = new ImageIcon("images/koala.jpg");
        //orangutanIcon = new ImageIcon("images/orangutan.jpg");

        //imagen = new JLabel(koalaIcon);

        panelImagen = new JPanel();
        //panelImagen.add(imagen, BorderLayout.CENTER);

        //ventana un ContentPane donde se agregan los componentes
        //ventana.add(panelImagen, BorderLayout.CENTER);

        botonKoala = new JButton("Koala");
        botonKoala.addActionListener(this);
        botonOrangutan = new JButton("Orangutan");
        botonOrangutan.addActionListener(this);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(50, 50));

        //panelBotones.add(botonKoala);
        //panelBotones.add(botonOrangutan);

        ventana.add(panelBotones, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(botonOrangutan)){
            //imagen.setIcon(orangutanIcon);
            JOptionPane.showMessageDialog(ventana, "Se cambió la imagen a orangután");
            //System.out.println("Se presionó el botón orangután");
        }

        if (e.getSource().equals(botonKoala)){
            //imagen.setIcon(koalaIcon);
            JOptionPane.showMessageDialog(ventana, "Se cambió la imagen a koala");
            //System.out.println("Se presionó el botón Koala");
        }
   
        
    }
}
