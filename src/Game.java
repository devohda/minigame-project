import javax.swing.*;
import java.awt.*;

public class Game {
    private JFrame frame;
    private JPanel background;

    public void getFrame(){

        frame = new JFrame();
        frame.setTitle("결합 게임");
        frame.setSize(new Dimension(1000,1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우와 함께 프로그램 종료
        frame.setLayout(null);

        background = new JPanel();
        background.setLayout(null);
        background.setBounds(0,0,1000,1000);
        background.setBackground(new Color(230,230,230));

        JPanel board = makeBoard();
        background.add(board);

        frame.getContentPane().add(background); //프레임의 컨텐트팬을 background 패널로 변경
        //frame.pack();
        frame.setVisible(true);

    }

    Graphics paint;
    public JPanel makeBoard(){
        JPanel gameBoard = new JPanel();
        gameBoard.setBackground(Color.pink);
        //gameBoard.setSize(new Dimension(900,900));
        gameBoard.setBounds(30,30,900,900);
        gameBoard.setLayout(null);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Card newCard = new Card();
                JPanel card = newCard.makeCard(paint);
                card.setBounds(300*(i) + 50, 300*(j) + 50, 200, 200);
                //card.setBackground(new Color(j*100,j*30,j*40));
                newCard.getCardInfo();
                gameBoard.add(card);
            }
        }
        return gameBoard;
    }


}//Game
