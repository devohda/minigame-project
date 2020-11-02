import javax.swing.*;
import javax.swing.border.Border;
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

        setGameBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Figure figure = new Figure(boardInfo[i][j].getCardColor(),boardInfo[i][j].getShape(),boardInfo[i][j].getBackgroundColor());
                figure.setBounds(300*(i) + 50, 300*(j) + 50, 200, 200);


                boardInfo[i][j].getCardInfo();
                gameBoard.add(figure);
            }
        }
        return gameBoard;
    }

    class Figure extends JPanel{

        private CardColor cardColor;
        private Shape shape;
        private BackgroundColor backgroundColor;

        public Figure(CardColor c, Shape s, BackgroundColor b){
            backgroundColor = b;
            cardColor = c;
            shape = s;
        }

        public void paintComponent(Graphics paint){

            super.paintComponent(paint);

            switch (backgroundColor){
                case WHITE -> {
                    super.setBackground(Color.WHITE);
                }
                case GRAY -> {
                    super.setBackground(Color.GRAY);
                }
                case BLACK -> {
                    super.setBackground(Color.BLACK);
                }
            }

            switch (cardColor){
                case RED -> {
                    paint.setColor(Color.RED);
                }
                case YELLOW -> {
                    paint.setColor(Color.YELLOW);
                }
                case GREEN -> {
                    paint.setColor(Color.GREEN);
                }
            }

            switch (shape){

                case CIRCLE -> {
                    paint.fillOval(0,0,100,100);
                    break;
                }
                case SQUARE -> {
                    paint.fillRect(0,0,100,100);
                    break;
                }
                case TRIANGLE -> {
                    int x[] = { 0, 50, 100 };
                    int y[] = { 100, 0, 100 };
                    paint.fillPolygon( x, y, 3 );       // 삼각형그리기
                    break;
                }
            }
        }
    }
}//Game


