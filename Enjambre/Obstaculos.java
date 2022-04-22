import java.util.Random;
public class Obstaculos {
    int PosicionX1;//Posición del cubo de la izquierda superior
    int PosicionY1;
    int PosicionX2;//Posición del cubo de la derecha superior
    int PosicionY2;
    int PosicionX3;//Posición del cubo de la izquierda inferior
    int PosicionY3;
    int PosicionX4;//Posición del cubo de la derecha inferior
    int PosicionY4;
    Random rand = new Random();
    public Obstaculos(){
        PosicionX1=rand.nextInt(50+1);
        PosicionY1=rand.nextInt(50+1);
        this.PosicionX2=PosicionX1+1;
        this.PosicionY2=PosicionY1;
        this.PosicionX3=PosicionX1;
        this.PosicionY3=PosicionY1-1;
        this.PosicionX4=PosicionX1+1;
        this.PosicionY4=PosicionY1-1;
    }
    
    //Retornan las posiciones
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
