import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mapa implements ActionListener {
    JFrame ventana;
    JButton Interactuar;
    JPanel PanelBoton;
    //Interacciones Interaccion = new Interacciones();
    ArrayList<Agentes> misAgentes = new ArrayList<>();
    ArrayList<Atacante> misAtacantes = new ArrayList<>();
    ArrayList<Recursos> misRecursos = new ArrayList<>(); 
    ArrayList<Obstaculos> misObstaculos = new ArrayList<>();
    int x;
    int j;
    int x1;
    int y1;
    int cont;
    int cod;
    int cantAgent;
    int cantObj;

    public Mapa(){
        ventana = new JFrame("Simulación");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarComponentes();
        ventana.setSize(500,500);
        ventana.setResizable(false);
        ventana.setVisible(true);
        cont =1;
        cod = -1;
        cantAgent=10;
        cantObj=2;
        //Mapa demo = new Mapa(); 
        for(x=0;x<cantAgent;x++){
            misAgentes.add(new Recolectores());
            misAgentes.add(new Defensores());

        }

        for(x=0;x<cantObj;x++){
            misAtacantes.add(new Atacante());
            misRecursos.add(new Recursos());
            misObstaculos.add(new Obstaculos());
        }
        cantAgent=cantAgent*2;//Como se agregaron de 2 en 2 se debe duplicar para correr toda la lista
        for(x=0;x<cantAgent;x++){
            misAgentes.get(x).setposicion(x);
            
        }

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
        if(e.getSource().equals(Interactuar)){
            for(x=0;x<cantAgent;x++){
                misAgentes.get(x).MoverAgente();
                if (misAgentes.get(x).getPosicionX()==0 & misAgentes.get(x).getPosicionY()==0){
                    misAgentes.get(x).Base();
                    

                }
                pintar punto= new pintar(misAgentes.get(x).getPosicionX(),misAgentes.get(x).getPosicionY());
                
            }
            for(x=0;x<cantAgent;x++){//Detectar agente
                for(j=0;j<cantAgent;j++){
                    if (j!=x){
                        cod = misAgentes.get(j).DetectarCercanias(misAgentes.get(x).getPosicionX(),misAgentes.get(x).getPosicionY());
                        if (cod!=-1){
                            break;
                        }
                    }
                }
                if (cod!=-1){
                    //Se pasan todos los datos del agente cercano para comparar los datos en el metodo
                    misAgentes.get(x).DetectarAgente(misAgentes.get(j).getRecurso(), misAgentes.get(j).getAmenaza(), misAgentes.get(j).getEspaciosAmenaza(), misAgentes.get(j).getMovimiento(), misAgentes.get(j).getPosicionXrecurso(), misAgentes.get(j).getPosicionYrecurso(),misAgentes.get(x).getPosicionXAmenaza(),misAgentes.get(x).getPosicionYAmenaza(),misAgentes.get(x).getsiguiendo(), cod);
                    cod=-1;
                }
                    
            }
            cod=-1;
            for(j=0;j<cantAgent;j++){//Detectar atacante
                for(x=0;x<cantObj;x++){
                    cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX(),misAtacantes.get(x).getPosicionY());
                        if (cod!=-1){
                            misAtacantes.get(x).PerderVida();
                            misAgentes.get(j).DetectarAmenaza();
                            cont=cont+1;
                            cod=-1;
                        }
                        else{
                            if (cont!=1){
                                misAgentes.get(j).AmenazaNoDetectada();
                            }
                        }
                    }
                    cont=0;             
            }
            cod=-1;
            for(j=0;j<cantAgent;j++){//Detectar recurso
                for(x=0;x<cantObj;x++){
                    cod = misAgentes.get(j).DetectarCercanias(misRecursos.get(x).getPosicionX(),misRecursos.get(x).getPosicionY());
                        if (cod!=-1){
                            misRecursos.get(x).PerderVida();
                            misAgentes.get(j).DetectarRecurso(misRecursos.get(x).getPosicionX(),misRecursos.get(x).getPosicionY());
                            cod=-1;
                        }
                }
                    
            }
            cod=-1;
            for(j=0;j<cantAgent;j++){//Detectar obstaculo
                for(x=0;x<cantObj;x++){
                    cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX(),misObstaculos.get(x).getPosicionY());
                        if (cod!=-1){
                            misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX(),misObstaculos.get(x).getPosicionY());
                            cod=-1;
                        }
                }
                    
            }
        }
        
    }
}
