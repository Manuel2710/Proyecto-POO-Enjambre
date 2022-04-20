import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mapa extends JFrame{
    private ListaPixeles pixeles;
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
        pixeles = new ListaPixeles();
        JButton crearpixel = new JButton("Interactuar");
        cont =1;
        cod = -1;
        cantAgent=10;
        cantObj=2;
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
        x=0;
        
    
        crearpixel.addActionListener (new ActionListener () {    
            @Override
            public void actionPerformed (ActionEvent e) {
                if(x>0){
                    for(x=0;x<(4+cantAgent+cantObj*12);x++){
                        pixeles.Eliminar();
                    }
                }
                for(x=0;x<cantAgent;x++){
                    misAgentes.get(x).MoverAgente();
                    if (misAgentes.get(x).getPosicionX()==0 & misAgentes.get(x).getPosicionY()==0){
                        misAgentes.get(x).Base();
                    }
                    Pintar q = new Pintar(misAgentes.get(x).getPosicionX(), misAgentes.get(x).getPosicionY(),1);
                    pixeles.Agregar(q);
                    
                    
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
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX1(),misAtacantes.get(x).getPosicionY1());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarAmenaza();
                                if (misAgentes.get(j).getAmenaza()==3){
                                    misAtacantes.get(x).PerderVida(); 
                                }
                                cont=cont+1;
                                cod=-1;
                            }
                            else{
                                if (cont!=1){
                                    misAgentes.get(j).AmenazaNoDetectada();
                                }
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX2(),misAtacantes.get(x).getPosicionY2());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarAmenaza();
                                if (misAgentes.get(j).getAmenaza()==3){
                                    misAtacantes.get(x).PerderVida(); 
                                }
                                cont=cont+1;
                                cod=-1;
                            }
                            else{
                                if (cont!=1){
                                    misAgentes.get(j).AmenazaNoDetectada();
                                }
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX3(),misAtacantes.get(x).getPosicionY3());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarAmenaza();
                                if (misAgentes.get(j).getAmenaza()==3){
                                    misAtacantes.get(x).PerderVida(); 
                                }
                                cont=cont+1;
                                cod=-1;
                            }
                            else{
                                if (cont!=1){
                                    misAgentes.get(j).AmenazaNoDetectada();
                                }
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX4(),misAtacantes.get(x).getPosicionY4());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarAmenaza();
                                if (misAgentes.get(j).getAmenaza()==3){
                                    misAtacantes.get(x).PerderVida(); 
                                }
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
                        cod = misAgentes.get(j).DetectarCercanias(misRecursos.get(x).getPosicionX1(),misRecursos.get(x).getPosicionY1());
                            if (cod!=-1 & misAgentes.get(j).getRecurso()==false){
                                misRecursos.get(x).PerderVida();
                                misAgentes.get(j).DetectarRecurso(misRecursos.get(x).getPosicionX1(),misRecursos.get(x).getPosicionY1());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misRecursos.get(x).getPosicionX2(),misRecursos.get(x).getPosicionY2());
                            if (cod!=-1 & misAgentes.get(j).getRecurso()==false){
                                misRecursos.get(x).PerderVida();
                                misAgentes.get(j).DetectarRecurso(misRecursos.get(x).getPosicionX2(),misRecursos.get(x).getPosicionY2());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misRecursos.get(x).getPosicionX3(),misRecursos.get(x).getPosicionY3());
                            if (cod!=-1 & misAgentes.get(j).getRecurso()==false){
                                misRecursos.get(x).PerderVida();
                                misAgentes.get(j).DetectarRecurso(misRecursos.get(x).getPosicionX3(),misRecursos.get(x).getPosicionY3());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misRecursos.get(x).getPosicionX4(),misRecursos.get(x).getPosicionY4());
                            if (cod!=-1 & misAgentes.get(j).getRecurso()==false){
                                misRecursos.get(x).PerderVida();
                                misAgentes.get(j).DetectarRecurso(misRecursos.get(x).getPosicionX4(),misRecursos.get(x).getPosicionY4());
                                cod=-1;
                            }
                    }
                        
                }
                cod=-1;
                for(j=0;j<cantAgent;j++){//Detectar obstaculo
                    for(x=0;x<cantObj;x++){
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX1(),misObstaculos.get(x).getPosicionY1());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX1(),misObstaculos.get(x).getPosicionY1());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX2(),misObstaculos.get(x).getPosicionY2());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX2(),misObstaculos.get(x).getPosicionY2());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX3(),misObstaculos.get(x).getPosicionY3());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX3(),misObstaculos.get(x).getPosicionY3());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4());
                                cod=-1;
                            }
                    }
                        
                }

                for(x=0;x<cantObj;x++){//Pintar Atacante
                    Pintar q = new Pintar(misAtacantes.get(x).getPosicionX1(), misAtacantes.get(x).getPosicionY1(),2);
                    pixeles.Agregar(q);
                    Pintar q1 = new Pintar(misAtacantes.get(x).getPosicionX2(), misAtacantes.get(x).getPosicionY2(),2);
                    pixeles.Agregar(q1);
                    Pintar q2 = new Pintar(misAtacantes.get(x).getPosicionX3(), misAtacantes.get(x).getPosicionY3(),2);
                    pixeles.Agregar(q2);
                    Pintar q3 = new Pintar(misAtacantes.get(x).getPosicionX4(), misAtacantes.get(x).getPosicionY4(),2);
                    pixeles.Agregar(q3);
                }

                for(x=0;x<cantObj;x++){//Pintar Recurso
                    Pintar q = new Pintar(misRecursos.get(x).getPosicionX1(), misRecursos.get(x).getPosicionY1(),3);
                    pixeles.Agregar(q);
                    Pintar q1 = new Pintar(misRecursos.get(x).getPosicionX2(), misRecursos.get(x).getPosicionY2(),3);
                    pixeles.Agregar(q1);
                    Pintar q2 = new Pintar(misRecursos.get(x).getPosicionX3(), misRecursos.get(x).getPosicionY3(),3);
                    pixeles.Agregar(q2);
                    Pintar q3 = new Pintar(misRecursos.get(x).getPosicionX4(), misRecursos.get(x).getPosicionY4(),3);
                    pixeles.Agregar(q3);
                }

                for(x=0;x<cantObj;x++){//Pintar Obstaculo
                    Pintar q = new Pintar(misObstaculos.get(x).getPosicionX1(), misObstaculos.get(x).getPosicionY1(),4);
                    pixeles.Agregar(q);
                    Pintar q1 = new Pintar(misObstaculos.get(x).getPosicionX2(), misObstaculos.get(x).getPosicionY2(),4);
                    pixeles.Agregar(q1);
                    Pintar q2 = new Pintar(misObstaculos.get(x).getPosicionX3(), misObstaculos.get(x).getPosicionY3(),4);
                    pixeles.Agregar(q2);
                    Pintar q3 = new Pintar(misObstaculos.get(x).getPosicionX4(), misObstaculos.get(x).getPosicionY4(),4);
                    pixeles.Agregar(q3);
                }
                Pintar q = new Pintar(0,0,0);
                Pintar q1 = new Pintar(1,0,0);
                Pintar q2 = new Pintar(0,1,0);
                Pintar q3 = new Pintar(1,1,0);
                pixeles.Agregar(q);
                pixeles.Agregar(q1);
                pixeles.Agregar(q2);
                pixeles.Agregar(q3);
            }
        });
        add(pixeles);
        add(crearpixel,BorderLayout.NORTH);
    }
    public static void main(String[] args){
        JFrame ventana = new Mapa();
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setSize(700,700);
        ventana.setVisible(true);
    }
}
