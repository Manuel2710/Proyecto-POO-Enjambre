import java.awt.Color;
import java.awt.Graphics;
public class pintar {
    private int x;//Posición x
    private int y;//Posición y
    private int dx;//Dimensiones
    private int dy;
    private int who;//Color, bordes o completo

    public pintar(int x, int y, int who) {
        this.x = x*10;
        this.y = y*10;
        this.dx = 10;
        this.dy = 10;
        this.who=who;
    }
    //Pinta los cubos en la ventana
    public void PintarPixel (Graphics g) {
        switch (who){
            case 0:
                g.setColor (Color.YELLOW) ;//Base
                g.fillRect(x, y, dx, dy);
                break;
            case 1:
                g.setColor (Color.BLACK) ;//Agente
                g.fillRect(x, y, dx, dy);
                break;
            case 2:
                g.setColor (Color.RED) ;//Atacante
                g.fillRect(x, y, dx, dy);
                break;
            case 3:
                g.setColor (Color.GREEN) ;//Recurso
                g.fillRect(x, y, dx, dy);
                break;
            case 4:
                g.setColor (Color.BLUE) ;//Obstaculo
                g.fillRect(x, y, dx, dy);
                break;
            case 5:
                g.setColor (Color.BLACK) ;//Tablero
                g.drawRect(x, y, dx, dy);
                break;
        }
        
}

}
