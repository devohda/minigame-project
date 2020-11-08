import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Scanner;

public class Game{
    private JFrame frame;
    private JPanel background;



    public void getFrame(){

        frame = new JFrame();
        frame.setTitle("결합 게임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우와 함께 프로그램 종료
        //frame.setLayout(null);

        background = new JPanel();
        background.setLayout(null);
        background.setPreferredSize(new Dimension(500,500));
        background.setBackground(new Color(230,230,230));



        JPanel board = makeBoard();
        calculateHap();
        background.add(board);
        frame.getContentPane().add(background); //프레임의 컨텐트팬을 background 패널로 변경
        frame.pack();
        frame.setResizable(false); //크기 조정 불가능하게 설정
        frame.setVisible(true);

    }

    /*******************************/
    /******** 게임 판 만들기 *********/
    /*******************************/

    private Card[] boardInfo;
    public void setGameBoard(){
        boardInfo = new Card[9];
        for (int i = 0; i < 9; i++) {
            boardInfo[i] = new Card();
        }
    }//setGameBoard()



    /*******************************/
    /******** 게임 판 그리기 *********/
    /*******************************/

    public JPanel makeBoard(){

        JPanel gameBoard = new JPanel();
        gameBoard.setBackground(Color.pink);
        gameBoard.setSize(new Dimension(500,500));
        gameBoard.setLayout(null);

        setGameBoard(); //게임판 새로 만들기
        //게임판 그리기
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Card.Figure figure = boardInfo[cnt++].drawCard();
                figure.setBounds(150*(j) + 50, 150*(i) + 50, 100, 100);
                gameBoard.add(figure);
            }
        }
        return gameBoard;
    }

    /*******************************/
    /******* '합' 집합 구하기 ********/
    /*******************************/

    private boolean stateBg(Card a, Card b, Card c){

        boolean state = false;
        if ((a.getBackgroundColor() == b.getBackgroundColor()) && (b.getBackgroundColor() == c.getBackgroundColor()))
            state = true;
        if ((a.getBackgroundColor() != b.getBackgroundColor()) && (b.getBackgroundColor() != c.getBackgroundColor()) && (a.getBackgroundColor() != c.getBackgroundColor()))
            state = true;

        return state;
    }

    private boolean stateShape(Card a, Card b, Card c){

        boolean state = false;
        if ((a.getShape() == b.getShape()) && (b.getShape() == c.getShape()))
            state = true;
        if ((a.getShape() != b.getShape()) && (b.getShape() != c.getShape()) && (a.getShape() != c.getShape()))
            state = true;

        return state;
    }

    private boolean stateColor(Card a, Card b, Card c){
        boolean state = false;
        if ((a.getCardColor() == b.getCardColor()) && (b.getCardColor() == c.getCardColor()))
            state = true;
        if ((a.getCardColor() != b.getCardColor()) && (b.getCardColor() != c.getCardColor()) && (a.getCardColor()!= c.getCardColor()))
            state = true;

        return state;
    }

    private boolean isHap(Card a, Card b, Card c){
        return(stateBg(a,b,c)&&stateColor(a,b,c)&&stateShape(a,b,c));
    }

    private int hapNum;
    private int hapSet[][];

    public void calculateHap(){
        hapNum = 0;
        hapSet = new int[9*8*7][3];

        //카드 세 개의 조합이 합인 것 찾기
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++){
                for(int k = j + 1; k < 9 ; k++){
                    if(isHap(boardInfo[i],boardInfo[j],boardInfo[k])){
                        hapSet[hapNum][0] = i+1;
                        hapSet[hapNum][1] = j+1;
                        hapSet[hapNum][2] = k+1;
                        hapNum++;
                    }
                }
            }
        }

        for (int i = 0; i < hapNum ; i++){
            System.out.println("합: "+hapSet[i][0]+" "+hapSet[i][1]+" "+hapSet[i][2]);
        }
        if(hapNum == 0){
            System.out.println("NONE");
        }
    }

    /*******************************/
    /********* 점수 계산하기 *********/
    /*******************************/
    



}//Game


