import java.util.Random;

public class Defensores extends Agentes{
    Random rand = new Random();
    public Defensores(){
        
        this.Tamaño = 1;
        this.Recurso = false;
        this.Amenaza = 1;
        this.EspaciosAmenaza = 10;
        this.Movimiento = "Izquierda";
        this.PosicionX=rand.nextInt(700+1);;//Donde aparezcan
        this.PosicionY=rand.nextInt(700+1);;
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
        DetectarRecurso();
    }
    public void AtacarAmenaza(){
        DetectarRecurso();
    }

    public void DetectarAmenaza(){
        AtacarAmenaza();
    }
    public void AtacarRecurso(){
        DetectarRecurso();
    }
    
    public void MoverAgente(){
        DetectarAmenaza();
        DetectarRecurso();
        DetectarAgente();
    }
}
