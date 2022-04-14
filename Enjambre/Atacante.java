import java.util.Random;

public class Atacante extends Objetos{
    Random rand = new Random();
    public Atacante(){
        this.Vida=10;
        this.PosicionX=rand.nextInt(50+1);//Donde aparezcan
        this.PosicionY=rand.nextInt(50+1);
        
        
    }
    public void PerderVida(){
        Vida=Vida-1;
        VolverAparecer();
    }
    public void VolverAparecer(){
        if (Vida==0){
            Vida =10;
            PosicionX=rand.nextInt(50+1);
            PosicionY=rand.nextInt(50+1);
        }
    }

    public int getPosicionX(){
        return PosicionX;
    }
    public int getPosicionY(){
        return PosicionY;
    }
}