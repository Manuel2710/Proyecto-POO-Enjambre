import java.awt.BorderLayout;
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
                    for(x=0;x<(cantAgent+cantObj*3);x++){
                        pixeles.Eliminar();
                    }
                }
                for(x=0;x<cantAgent;x++){
                    misAgentes.get(x).MoverAgente();
                    if (misAgentes.get(x).getPosicionX()==0 & misAgentes.get(x).getPosicionY()==0){
                        misAgentes.get(x).Base();
                    }
                    Pintar q = new Pintar(misAgentes.get(x).getPosicionX(), misAgentes.get(x).getPosicionY(), 1, 1,0);
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
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX(),misAtacantes.get(x).getPosicionY());
                            if (cod!=-1){
                                System.out.println(j);
                                System.out.println("Agente");
                                System.out.println(x);
                                System.out.println("Perdio vida");
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
                                System.out.println(j);
                                System.out.println("Agente");
                                System.out.println(x);
                                System.out.println("Tomo recurso");
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

                for(x=0;x<cantObj;x++){//Pintar Atacante
                    Pintar q = new Pintar(misAtacantes.get(x).getPosicionX(), misAtacantes.get(x).getPosicionY(), 2, 2,1);
                    pixeles.Agregar(q);
                }

                for(x=0;x<cantObj;x++){//Pintar Recurso
                    Pintar q = new Pintar(misRecursos.get(x).getPosicionX(), misRecursos.get(x).getPosicionY(), 2, 2,2);
                    pixeles.Agregar(q);
                }

                for(x=0;x<cantObj;x++){//Pintar Obstaculo
                    Pintar q = new Pintar(misObstaculos.get(x).getPosicionX(), misObstaculos.get(x).getPosicionY(), 2, 2,3);
                    pixeles.Agregar(q);
                }
            }
        });
        add(pixeles);
        add(crearpixel,BorderLayout.NORTH);
    }
    public static void main(String[] args){
        JFrame fAPP = new Mapa();
        fAPP.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fAPP.setSize(200,200);
        fAPP.setVisible(true);
    }
}
