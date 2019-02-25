import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private List<Sprite> actors = new ArrayList<>();
    final private int FRIENDLIES = 10;
    final private int ENEMIES = 10;

    public Board(){
        setPreferredSize(new Dimension(600,800));
        setBackground(Color.black);
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void init(){
        actors.add(0,new Friendly(Color.green, getWidth()/2, getHeight()/2, 15));
        for(int i = 1; i < FRIENDLIES; i++){
            actors.add(new Friendly(Color.red, getWidth()/2, getHeight()/2, 15));
        }
        for(int i = 0; i < ENEMIES; i++){
            actors.add(new Enemy(Color.pink, getWidth()/2, getHeight()/2, 20, 10));
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < actors.size(); i++){
            actors.get(i).paint(g);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < actors.size(); i++){
            actors.get(i).move(getHeight(),getWidth());
        }
        repaint();
    }
}
