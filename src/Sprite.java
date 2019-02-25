import java.awt.*;

public class Sprite implements Move, Paint{

    Color color;
    int x, y, width, height;
    double dx, dy;
    final int SPEED = 5;

    public Sprite(Color color, int x, int y, int width, int height){
        this.color = color;
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;
        while((int)dx == 0 || (int)dy == 0){
            double angle = 2*Math.PI*(Math.random()+1);
            double speed = (SPEED)*(Math.random()+1);
            dx = Math.cos(angle)*SPEED;
            dy = Math.sin(angle)*SPEED;
        }
    }

    public void move(int boardHeight, int boardWidth) {
        double nextLeft = x + dx;
        double nextRight = x + width + dx;
        double nextTop = y + dy;
        double nextBottom = y + height + dy;
        if(nextTop <= 0 || nextBottom > boardHeight){
            dy*=-1;
        }
        if(nextLeft <= 0 || nextRight > boardWidth){
            dx*=-1;
        }
        x += dx;
        y += dy;
    }

    public boolean collidesWith(Sprite other){
        
    }

    public Rectangle getBounds() {
        return new Rectangle(x+(int)dx,y+(int)dy,width,height);
    }

    public void paint(Graphics g) {

    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
