import java.awt.Color;
import java.awt.Graphics;
public class Pintar {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int who;

    public Pintar(int x, int y, int dx, int dy, int who) {
        this.x =x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.who=who;
    }

    public void PintarPixel (Graphics g) {
        switch (who){/*Sé que se deberia evitar este tipo de codigo pero era esto o
                        escribir otros 6 archivos con practicamente el mismo codigo*/
            case 0:
                g.setColor (Color.BLACK) ;
                g.drawRect(x, y, dx, dy);
                break;
            case 1:
                g.setColor (Color.RED) ;
                g.drawRect(x, y, dx, dy);
                break;
            case 2:
                g.setColor (Color.GREEN) ;
                g.drawRect(x, y, dx, dy);
                break;
            case 3:
                g.setColor (Color.BLUE) ;
                g.drawRect(x, y, dx, dy);
                break;
        }
        
}

}
