import java.awt.Color;
import java.awt.Graphics;
public class Pintar {
    private int x;
    private int y;
    private int dx;
    private int dy;

    public Pintar(int x, int y, int dx, int dy) {
        this.x =x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void desenhar (Graphics g) {
        g.setColor (Color. BLACK) ;
        g.drawRect(x, y, dx, dy);
}
}
