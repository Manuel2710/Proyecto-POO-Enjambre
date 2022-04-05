
public class Recolectores extends Agentes{
    
    public Recolectores(){
        Tamaño = 1;
        Recurso = false;
        Amenaza = 1;
        EspaciosAmenaza = 10;
        Movimiento = "Derecha";
        PosicionX=0;//Donde aparezcan
        PosicionY=0;
        PosicionXrecurso=0;//Ubicación default fuera del 50x50
        PosicionYrecurso=0;
        PosicionXbase=0;//Donde se encuentre la base
        PosicionYbase=0;
        posicion=0;
        siguiendo=0;
    }


    
    @Override
    public String toString() {
        return "Recolectores []" + Recurso + Movimiento;
    }



    public void DetectarRecurso(){
        System.out.println(Movimiento);
    }
    public void DetectarAgente(){

    }
    public void DetectarAmenaza(){

    }
    public void AtacarRecurso(){

    }
    public void MoverAgente(){
        
    }
}
