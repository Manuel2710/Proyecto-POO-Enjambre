import java.util.ArrayList;

public class Interacciones {
    public static void main(String[] args) throws Exception {
        ArrayList<Agentes> misAgentes = new ArrayList<>();  
        ArrayList<Atacante> misAtacantes = new ArrayList<>();  
        ArrayList<Recursos> misRecursos = new ArrayList<>(); 
        int x;
        int j;
        int cod = -1;
        int cantAgent=10;
        int cantObj=2;
        //Mapa demo = new Mapa(); 
        for(x=0;x<cantAgent;x++){
            misAgentes.add(new Recolectores());
            misAgentes.add(new Defensores());
        }

        for(x=0;x<cantObj;x++){
            misAtacantes.add(new Atacante());
            misRecursos.add(new Recursos());
        }
        cantAgent=cantAgent*2;//Como se agregaron de 2 en 2 se debe duplicar para correr toda la lista
        for(x=0;x<cantAgent;x++){
            misAgentes.get(x).setposicion(x);
        }

        ///////////////////////////////////////////////////////////////////////////////////////
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
                misAgentes.get(x).ComparacionAgentes(misAgentes.get(j).getRecurso(), misAgentes.get(j).getAmenaza(), misAgentes.get(j).getEspaciosAmenaza(), misAgentes.get(j).getMovimiento(), misAgentes.get(j).getPosicionXrecurso(), misAgentes.get(j).getPosicionYrecurso(), cod);
                cod=-1;
            }
                
        }
        cod=-1;
        ////////////////////////////////////////////////////////////////////////////
        for(x=0;x<cantAgent;x++){//Detectar agente
            for(j=0;j<cantObj;j++){
                if (j!=x){
                    cod = misAgentes.get(j).DetectarCercanias(misAtacantes.get(x).getPosicionX(),misAtacantes.get(x).getPosicionY());
                    if (cod!=-1){
                        break;
                    }
                }
            }
            if (cod!=-1){
                //Se pasan todos los datos del agente cercano para comparar los datos en el metodo
                misAtacantes.get(x).PerderVida();
                cod=-1;
            }
                
        }
        cod=-1;
        for(x=0;x<cantAgent;x++){//Detectar agente
            for(j=0;j<cantObj;j++){
                if (j!=x){
                    cod = misAgentes.get(j).DetectarCercanias(misRecursos.get(x).getPosicionX(),misRecursos.get(x).getPosicionY());
                    if (cod!=-1){
                        break;
                    }
                }
            }
            if (cod!=-1){
                //Se pasan todos los datos del agente cercano para comparar los datos en el metodo
                misRecursos.get(x).PerderVida();
                cod=-1;
            }
                
        }
        
    }
}