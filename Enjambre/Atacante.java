import java.util.Random;

public class Atacante extends Objetos{
    Random rand = new Random();
    public Atacante(){
        this.Vida=10;
        this.PosicionX1=rand.nextInt(50+1);//Donde aparezcan
        this.PosicionY1=rand.nextInt(50+1);
        this.PosicionX2=PosicionX1+1;
        this.PosicionY2=PosicionY1;
        this.PosicionX3=PosicionX1;
        this.PosicionY3=PosicionY1-1;
        this.PosicionX4=PosicionX1+1;
        this.PosicionY4=PosicionY1-1;
        
        
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
            PosicionX2=PosicionX1+1;
            PosicionY2=PosicionY1;
            PosicionX3=PosicionX1;
            PosicionY3=PosicionY1-1;
            PosicionX4=PosicionX1+1;
            PosicionY4=PosicionY1-1;
        }
    }

    public int getPosicionX1(){
        return PosicionX1;
    }

    public int getPosicionY1(){
        return PosicionY1;
    }

    public int getPosicionX2(){
        return PosicionX2;
    }

    public int getPosicionY2(){
        return PosicionY2;
    }

    public int getPosicionX3(){
        return PosicionX3;
    }

    public int getPosicionY3(){
        return PosicionY3;
    }

    public int getPosicionX4(){
        return PosicionX4;
    }

    public int getPosicionY4(){
        return PosicionY4;
    }
}