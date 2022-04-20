import java.util.Random;
public class Recursos extends Objetos {
    Random rand = new Random();
    public Recursos(){
        this.Vida=10;
        this.PosicionX1=rand.nextInt(50+1);//Donde aparezcan
        this.PosicionY1=rand.nextInt(50+1);
        
        
    }
    public void PerderVida(){
        Vida=Vida-1;
        VolverAparecer();
    }
    public void VolverAparecer(){
        if (Vida==0){
            Vida =10;
            PosicionX1=rand.nextInt(50+1);
            PosicionY1=rand.nextInt(50+1);
        }
    }
    public int getPosicionX(){
        return PosicionX1;
    }
    public int getPosicionY(){
        return PosicionY1;
    }
}