import java.util.ArrayList;

public class Interacciones {
    public static void main(String[] args) throws Exception {
        ArrayList<Agentes> misAgentes = new ArrayList<>();  
        ArrayList<Objetos> misObjetos = new ArrayList<>();  
        int x;
        int j;
        boolean RecAme;//Recurso - Amenaza
        int posXRecAme;//Posición X recurso - amenaza
        int posYRecAme;//Posición Y recurso - amenaza
        int cod = -1;
        int cantAgent=10;
        int cantObj=2;
        //Mapa demo = new Mapa(); 
        for(x=0;x<cantAgent;x++){
            misAgentes.add(new Recolectores());
            misAgentes.add(new Defensores());
        }

        for(x=0;x<cantObj;x++){
            misObjetos.add(new Atacante());
            misObjetos.add(new Recursos());
        }
        cantObj=cantObj*2;
        cantAgent=cantAgent*2;//Como se agregaron de 2 en 2 se debe duplicar para correr toda la lista
        for(x=0;x<cantAgent;x++){
            misAgentes.get(x).setposicion(x);
        }

        ///////////////////////////////////////////////////////////////////////////////////////
        for(x=0;x<cantAgent;x++){//Detectar agente
            int coorX = misAgentes.get(x).getPosicionX();
            int coorY = misAgentes.get(x).getPosicionY();
            for(j=0;j<cantAgent;j++){
                if (j!=x){
                    cod = misAgentes.get(j).DetectarAgente(coorX,coorY);
                    if (cod!=-1){
                        break;
                    }
                }
            }
            if (cod!=-1){
                RecAme =  misAgentes.get(cod).getRecurso();
                if (RecAme==true){
                    RecAme=false;
                    RecAme =  misAgentes.get(x).getRecurso();
                    if (RecAme!=true){
                        posXRecAme=misAgentes.get(cod).getPosicionXrecurso();
                        posYRecAme=misAgentes.get(cod).getPosicionYrecurso();
                        misAgentes.get(x).setPosicionXrecurso(posXRecAme);
                        misAgentes.get(x).setPosicionYrecurso(posYRecAme);
                    }
                    else{
                        misAgentes.get(x).setsiguiendo(cod);
                    }
                }
                misAgentes.get(cod).getAmenaza();
                misAgentes.get(cod).getEspaciosAmenaza();
                misAgentes.get(cod).getMovimiento();

                cod=-1;
            }
        }
        
    }
}