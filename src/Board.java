import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private List<Sprite> actors = new ArrayList<>();
    private int BULLETS = 0;
    private int ENEMIES = 20;
    private long lastMoment, currentMoment;

    public Board() {
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.black);
        timer = new Timer(1000 / 60, this);
        timer.start();
        lastMoment = System.currentTimeMillis();
    }

    public void init() {
        actors.clear();
        actors.add(0, new Friendly(Color.green, getWidth() / 2, getHeight() / 2, 15));
        for (int i = 0; i < ENEMIES; i++) {
            actors.add(new Enemy(Color.pink, getWidth() / 2, getHeight() / 2, 20, 10));
        }
    }

    public void shootBullet() {
        currentMoment = System.currentTimeMillis();
        if (currentMoment - lastMoment > 250) {
            actors.add(new Bullet(Color.white, actors.get(0).x + actors.get(0).width / 3, actors.get(0).y, 5, 8));
            lastMoment = System.currentTimeMillis();
        }
    }

    public void setPlayerPos(int x, int y) {
        actors.get(0).setPosition(x, y);
    }

    public void checkCollisions() {
//        for(int i = 0; i < actors.size()-1; i++){
//            for(int j = i+1; j < actors.size(); j++){
//                if(actors.get(i).collidesWith(actors.get(j)) && i!=j){
//                    if(actors.get(i) instanceof Friendly && actors.get(j) instanceof Enemy){
//                        actors.get(i).bounce();
//                        actors.get(j).bounce();
//                    }
//                }
//            }
//        }
        for (int i = 1; i < ENEMIES + 1; i++) {
            if (actors.get(0).collidesWith(actors.get(i))) {
                init();
            }
        }
        for (int i = 1; i < ENEMIES + 1; i++) {
            for (int j = ENEMIES + 1; j < actors.size(); j++) {
                if (actors.get(i).collidesWith(actors.get(j))) {
                    actors.remove(j);
                    actors.remove(i);
                    ENEMIES--;
                    if (ENEMIES == 0) {
                        System.out.println("You win");
                        System.exit(0);
                    }
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < actors.size(); i++) {
            actors.get(i).paint(g);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i < actors.size(); i++) {
            actors.get(i).move(getHeight(), getWidth());
        }
        checkCollisions();
        repaint();
    }
}
