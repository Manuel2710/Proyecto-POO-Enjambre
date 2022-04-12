import java.util.Random;
public class Recolectores extends Agentes{
    Random rand = new Random();
    public Recolectores(){
        this.Tamaño = 1;
        this.Recurso = false;
        this.Amenaza = 1;
        this.EspaciosAmenaza = 10;
        this.Movimiento = "Derecha";
        this.PosicionX= rand.nextInt(700+1);//Donde aparezcan
        this.PosicionY= rand.nextInt(700+1);;
        this.PosicionXrecurso=0;//Ubicación default fuera del 50x50
        this.PosicionYrecurso=0;
        this.PosicionXbase=0;//Donde se encuentre la base
        this.PosicionYbase=0;
        this.posicion=0;
        this.siguiendo=0;
    }

    public void DetectarRecurso(){
        System.out.println(PosicionX);
        System.out.println(PosicionY);
    }
    public void DetectarAgente(){
        /*System.out.println("Tamaño");
        System.out.println(Tamaño);
        System.out.println("Recurso");
        System.out.println(Recurso);
        System.out.println("Amenaza");
        System.out.println(Amenaza);
        System.out.println("EspaciosAmenaza");
        System.out.println(EspaciosAmenaza);
        System.out.println("Movimiento");
        System.out.println(Movimiento);
        System.out.println("PosicionX");
        System.out.println(PosicionX);
        System.out.println("PosicionY");
        System.out.println(PosicionY);
        System.out.println("PosicionXrecurso");
        System.out.println(PosicionXrecurso);
        System.out.println("PosicionYrecurso");
        System.out.println(PosicionYrecurso);
        System.out.println("PosicionXbase");
        System.out.println(PosicionXbase);
        System.out.println("PosicionYbase");
        System.out.println(PosicionYbase);
        System.out.println("posicion");
        System.out.println(posicion);
        System.out.println("siguiendo");
        System.out.println(siguiendo);*/
    }
    public void DetectarAmenaza(){
        DetectarRecurso();
    }
    public void AtacarRecurso(){
        DetectarRecurso();
    }
    public void MoverAgente(){
        if (Amenaza==1){//No se ah encontrado una amenaza
            if (Recurso==false){//no a encontrado recurso
                if (PosicionXrecurso==900){//No le han pasado la hubicación de algún recurso
                    if (rand.nextInt(2+1)==1){
                        PosicionX=PosicionX+1;
                    }
                    else
                        PosicionY=PosicionY+1;
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

        //posiciones amenazas,recursos, agentes
    }
}
