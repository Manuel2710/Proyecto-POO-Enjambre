import java.awt.*;
import javax.swing.*;
public class pintar extends JComponent{
    private int x;
    private int y;
    public pintar(int x1, int y1){
        x=x1;
        y=y1;
    }

    protected void Paint(Graphics g){;
        g.drawLine(x,y,x,y);
    }
}
