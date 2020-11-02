import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{
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
        calculateHap();

        background.add(board);
        frame.getContentPane().add(background); //프레임의 컨텐트팬을 background 패널로 변경
        //frame.pack();
        frame.setVisible(true);

    }



    /*******************************/
    /******** 게임 판 만들기 *********/
    /*******************************/

    private Card[][] boardInfo;
    public void setGameBoard(){
        boardInfo = new Card[3][3];
        for (int i = 0; i < 3; i++) {
            boardInfo[i] = new Card[3];
            for (int j = 0; j < 3; j++) {
                boardInfo[i][j] = new Card();
            }
        }
    }//setGameBoard()



    /*******************************/
    /******** 게임 판 그리기 *********/
    /*******************************/

    public JPanel makeBoard(){
        JPanel gameBoard = new JPanel();
        gameBoard.setBackground(Color.pink);
        //gameBoard.setSize(new Dimension(900,900));
        gameBoard.setBounds(30,30,900,900);
        gameBoard.setLayout(null);

        setGameBoard(); //게임판 새로 만들기
        //게임판 그리기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Card.Figure figure = boardInfo[i][j].drawCard();
                figure.setBounds(300*(j) + 50, 300*(i) + 50, 200, 200);
                gameBoard.add(figure);
            }
        }
        return gameBoard;
    }

    /*******************************/
    /******* '합' 집합 구하기 ********/
    /*******************************/
    private int hapNum;
    public void calculateHap(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardInfo[i][j].getCardInfo();
            }
        }
    }
}//Game


