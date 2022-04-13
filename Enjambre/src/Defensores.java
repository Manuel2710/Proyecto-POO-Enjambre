import java.util.Random;

public class Defensores extends Agentes{
    Random rand = new Random();
    public Defensores(){
        
        this.Recurso = false;
        this.Amenaza = 1;
        this.EspaciosAmenaza = 10;
        this.Movimiento = "Izquierda";
        this.PosicionX=rand.nextInt(50+1);//Donde aparezcan
        this.PosicionY=rand.nextInt(50+1);
        this.PosicionXrecurso=60;//Ubicación default fuera del 50x50
        this.PosicionYrecurso=60;
        this.PosicionXbase=0;//Donde se encuentre la base
        this.PosicionYbase=0;
        this.posicion=0;
        this.siguiendo=0;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean getRecurso(){
        return Recurso;
    }
    public int getAmenaza(){
        return Amenaza;
    }
    public int getEspaciosAmenaza(){
        return EspaciosAmenaza;
    }
    public String getMovimiento(){
        return Movimiento;
    }
    public int getPosicionX(){
        return PosicionX;
    }
    public int getPosicionY(){
        return PosicionY;
    }
    public int getPosicionXrecurso(){
        return PosicionXrecurso;
    }
    public int getPosicionYrecurso(){
        return PosicionYrecurso;
    }

    public void setPosicionXrecurso(int n){
        PosicionXrecurso=n;
    }
    public void setPosicionYrecurso(int n){
        PosicionYrecurso=n;
    }

    public void setposicion(int n){
        posicion=n;
    }
    public void setsiguiendo(int cod){
        siguiendo=cod;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int DetectarRecurso(int x,int y){
        return -1;
    }
    public int DetectarAgente(int x,int y){
        return -1;
    }
    public void AtacarAmenaza(){
        //Ataca la amenaza
    }

    public int DetectarAmenaza(int x,int y){
        AtacarAmenaza();
        return -1;
    }
    public void AtacarRecurso(){
        //Ataca el recuros
    }
    
    public void MoverAgente(){
        if (Amenaza==1){//No se ah encontrado una amenaza
            if (Recurso==false){//no a encontrado recurso
                if (PosicionXrecurso==60){//No le han pasado la hubicación de algún recurso
                    while (true){//Evita que se salgan de pantalla
                        switch (rand.nextInt(4+1)){
                            case 1:
                                if (PosicionX>0){
                                PosicionX=PosicionX-1;
                                Movimiento="Izquierda";
                                break;
                                }
                            case 2:
                                if (PosicionX<50){
                                PosicionX=PosicionX+1;
                                Movimiento="Derecha";
                                break;
                                }
                            case 3:
                                if (PosicionY>0){ 
                                PosicionY=PosicionY-1;
                                Movimiento="Arriba";
                                break;
                                }
                            case 4:
                                if (PosicionY<50){
                                PosicionY=PosicionY+1;
                                Movimiento="Abajo";
                                break;
                                }
                        }
                    }
                }
                else
                {
                    if (PosicionXrecurso>PosicionX){
                        PosicionX=PosicionX+1;
                    }
                    if (PosicionXrecurso<PosicionX){
                        PosicionX=PosicionX-1;
                    }
                    if (PosicionXrecurso==PosicionX){
                        if (PosicionYrecurso>PosicionY){
                            PosicionY=PosicionY+1;
                        }
                        if (PosicionYrecurso<PosicionY){
                            PosicionY=PosicionY-1;
                        }
                    }
                }
            }
            else{
                if (PosicionXbase>PosicionX){
                    PosicionX=PosicionX+1;
                }
                if (PosicionXbase<PosicionX){
                    PosicionX=PosicionX-1;
                }
                if (PosicionXbase==PosicionX){
                    if (PosicionYbase>PosicionY){
                        PosicionY=PosicionY+1;
                    }
                    if (PosicionYbase<PosicionY){
                        PosicionY=PosicionY-1;
                    }
                }
            }
        }
        else{//En caso de amenaza
            switch (Movimiento){
                case "Izquierda":
                    PosicionX=PosicionX-1;
                case "Derecha":
                    PosicionX=PosicionX+1;
                case "Arriba":
                    PosicionY=PosicionY-1;
                case "Abajo":
                    PosicionY=PosicionY+1;
            }
            EspaciosAmenaza=EspaciosAmenaza-1;
        }
    }
}
