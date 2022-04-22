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
    int cont;
    int cod;
    int cantAgent;
    int cantObj;

    public Mapa(){
        pixeles = new ListaPixeles();
        JButton crearpixel = new JButton("Interactuar");
        cont =1;
        cod = -1;
        cantAgent=20;
        cantObj=6;

        //Genera los agentes
        for(x=0;x<cantAgent;x++){
            misAgentes.add(new Recolectores());
            misAgentes.add(new Defensores());

        }
        //Genera los Objetos
        for(x=0;x<cantObj;x++){
            misAtacantes.add(new Atacante());
            misRecursos.add(new Recursos());
            misObstaculos.add(new Obstaculos());
        }
        cantAgent=cantAgent*2;//Como se agregaron de 2 en 2 se debe duplicar para correr toda la lista
        
        //Se asigna la posición de los agentes dentro de la lista
        for(x=0;x<cantAgent;x++){
            misAgentes.get(x).setposicion(x);
            
        }

        //Se imprime el tablero
        for (j=0;j<51;j++){
            for(x=0;x<51;x++){
                pintar q = new pintar(x, j,5);
                pixeles.Agregar(q);
            }
        }
        x=0;
        
    
        crearpixel.addActionListener (new ActionListener () {    
            @Override
            public void actionPerformed (ActionEvent e) {
                
                //Elimina los cubos de la lista-Actualiza el tablero
                if(x>0){
                    for(x=0;x<(4+cantAgent+cantObj*12);x++){
                        pixeles.Eliminar();
                    }
                }
                //Mueve y pinta los agentes
                for(x=0;x<cantAgent;x++){
                    misAgentes.get(x).MoverAgente();
                    if (misAgentes.get(x).getPosicionX()==0 & misAgentes.get(x).getPosicionY()==0){
                        misAgentes.get(x).Base();
                    }
                    pintar q = new pintar(misAgentes.get(x).getPosicionX(), misAgentes.get(x).getPosicionY(),1);
                    pixeles.Agregar(q);
                    
                    
                }
                //Verifica la posición de los agentes
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
                //Verifica la posición de los atacantes
                cod=-1;
                for(j=0;j<cantAgent;j++){//Detectar atacante
                    for(x=0;x<cantObj;x++){
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX1(),misAtacantes.get(x).getPosicionY1());
                            if (cod!=-1){//Si estan a la par
                                //Establece el comportamiento (Ataca o huye)
                                misAgentes.get(j).DetectarAmenaza(misAtacantes.get(x).getPosicionX1(),misAtacantes.get(x).getPosicionY1());
                                if (misAgentes.get(j).getAmenaza()==3){//Si esta atacando
                                    misAtacantes.get(x).PerderVida(); 
                                }
                                cont=cont+1;//No atacar dos veces al mismo y no cancelar el ataque
                                cod=-1;
                            }
                            else{
                                if (cont<1){
                                    //Re-establece el estado de amenaza
                                    misAgentes.get(j).AmenazaNoDetectada();
                                }
                            }
                        //Se verifica en los otros 3 cubos del atacante
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX2(),misAtacantes.get(x).getPosicionY2());
                            if (cod!=-1 & cont==0){
                                misAgentes.get(j).DetectarAmenaza(misAtacantes.get(x).getPosicionX2(),misAtacantes.get(x).getPosicionY2());
                                if (misAgentes.get(j).getAmenaza()==3){
                                    misAtacantes.get(x).PerderVida(); 
                                }
                                cont=cont+1;
                                cod=-1;
                            }
                            else{
                                if (cont<1){
                                    misAgentes.get(j).AmenazaNoDetectada();
                                }
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX3(),misAtacantes.get(x).getPosicionY3());
                            if (cod!=-1 & cont==0){
                                misAgentes.get(j).DetectarAmenaza(misAtacantes.get(x).getPosicionX3(),misAtacantes.get(x).getPosicionY3());
                                if (misAgentes.get(j).getAmenaza()==3){
                                    misAtacantes.get(x).PerderVida();
                                }
                                cont=cont+1;
                                cod=-1;
                            }
                            else{
                                if (cont<1){
                                    misAgentes.get(j).AmenazaNoDetectada();
                                }
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX4(),misAtacantes.get(x).getPosicionY4());
                            if (cod!=-1 & cont==0){
                                misAgentes.get(j).DetectarAmenaza(misAtacantes.get(x).getPosicionX4(),misAtacantes.get(x).getPosicionY4());
                                if (misAgentes.get(j).getAmenaza()==3){
                                    misAtacantes.get(x).PerderVida(); 
                                }
                                cont=cont+1;
                                cod=-1;
                            }
                            else{
                                if (cont<1){
                                    misAgentes.get(j).AmenazaNoDetectada();
                                }
                            }
                        }
                        cont=0;//Sirve para que no le quite 2 o más veces vida al mismo objeto y para verificar de manera general si se encontro un atacante
                }
                cod=-1;

                //Verifica la posición de los recursos
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
                //Verifica la posición de los Obstaculos
                for(j=0;j<cantAgent;j++){//Detectar obstaculo
                    for(x=0;x<cantObj;x++){
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX1(),misObstaculos.get(x).getPosicionY1());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX1(),misObstaculos.get(x).getPosicionY1(),misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX2(),misObstaculos.get(x).getPosicionY2());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX2(),misObstaculos.get(x).getPosicionY2(),misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX3(),misObstaculos.get(x).getPosicionY3());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX3(),misObstaculos.get(x).getPosicionY3(),misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4());
                                cod=-1;
                            }
                        cod = misAgentes.get(j).DetectarCercanias(misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4());
                            if (cod!=-1){
                                misAgentes.get(j).DetectarObstaculo(misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4(),misObstaculos.get(x).getPosicionX4(),misObstaculos.get(x).getPosicionY4());
                                cod=-1;
                            }
                    }
                        
                }

                for(x=0;x<cantObj;x++){//Pintar Atacante
                    pintar q = new pintar(misAtacantes.get(x).getPosicionX1(), misAtacantes.get(x).getPosicionY1(),2);
                    pixeles.Agregar(q);
                    pintar q1 = new pintar(misAtacantes.get(x).getPosicionX2(), misAtacantes.get(x).getPosicionY2(),2);
                    pixeles.Agregar(q1);
                    pintar q2 = new pintar(misAtacantes.get(x).getPosicionX3(), misAtacantes.get(x).getPosicionY3(),2);
                    pixeles.Agregar(q2);
                    pintar q3 = new pintar(misAtacantes.get(x).getPosicionX4(), misAtacantes.get(x).getPosicionY4(),2);
                    pixeles.Agregar(q3);
                }

                for(x=0;x<cantObj;x++){//Pintar Recurso
                    pintar q = new pintar(misRecursos.get(x).getPosicionX1(), misRecursos.get(x).getPosicionY1(),3);
                    pixeles.Agregar(q);
                    pintar q1 = new pintar(misRecursos.get(x).getPosicionX2(), misRecursos.get(x).getPosicionY2(),3);
                    pixeles.Agregar(q1);
                    pintar q2 = new pintar(misRecursos.get(x).getPosicionX3(), misRecursos.get(x).getPosicionY3(),3);
                    pixeles.Agregar(q2);
                    pintar q3 = new pintar(misRecursos.get(x).getPosicionX4(), misRecursos.get(x).getPosicionY4(),3);
                    pixeles.Agregar(q3);
                }

                for(x=0;x<cantObj;x++){//Pintar Obstaculo
                    pintar q = new pintar(misObstaculos.get(x).getPosicionX1(), misObstaculos.get(x).getPosicionY1(),4);
                    pixeles.Agregar(q);
                    pintar q1 = new pintar(misObstaculos.get(x).getPosicionX2(), misObstaculos.get(x).getPosicionY2(),4);
                    pixeles.Agregar(q1);
                    pintar q2 = new pintar(misObstaculos.get(x).getPosicionX3(), misObstaculos.get(x).getPosicionY3(),4);
                    pixeles.Agregar(q2);
                    pintar q3 = new pintar(misObstaculos.get(x).getPosicionX4(), misObstaculos.get(x).getPosicionY4(),4);
                    pixeles.Agregar(q3);
                }
                //Pintar base
                pintar q = new pintar(0,0,0);
                pintar q1 = new pintar(1,0,0);
                pintar q2 = new pintar(0,1,0);
                pintar q3 = new pintar(1,1,0);
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
        ventana.setSize(530,580);
        ventana.setVisible(true);
    }
}
