import java.util.Random;
public class Obstaculos {
    int PosicionX;
    int PosicionY;
    Random rand = new Random();
    public Obstaculos(){
        PosicionX=rand.nextInt(50+1);
        PosicionY=rand.nextInt(50+1);
    }

    public int getPosicionX(){
        return PosicionX;
    }

    public int getPosicionY(){
        return PosicionY;
    }
}
