import javax.swing.*;

public class Game extends JFrame {

    Board board;

    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Stalin Shapes");
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
        board.init();
    }

    public static void main(String[] args){
        new Game();
    }

}
