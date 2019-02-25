import java.awt.*;

public class Enemy extends Sprite{

    public Enemy(Color color, int x, int y, int width, int height){
        super(color, x, y, width, height);
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
