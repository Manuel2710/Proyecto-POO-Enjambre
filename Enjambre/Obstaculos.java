import java.util.Random;
public class Obstaculos {
    int PosicionX;
    int PosicionY;
    Random rand = new Random();
    public Obstaculos(){
        int PosicionX=rand.nextInt(50+1);
        int PosicionY=rand.nextInt(50+1);
    }

    public int getPosicionX(){
        return PosicionX;
    }

    public int getPosicionY(){
        return PosicionY;
    }
}
