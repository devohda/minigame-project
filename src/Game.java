import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Game extends JPanel{

    private JButton btnHap;
    private JButton btnGeul;
    private JTextField userinput;
    private JLabel lblScore;
    private int _score;

    private renewScore update; //actionListener class

    public Game() {
        setPreferredSize(new Dimension(500,700));
        setBackground(new Color(223, 255, 188));
        setLayout(null);

        btnHap = new JButton("합");
        btnGeul = new JButton("결");
        userinput = new JTextField(5);
        lblScore = new JLabel("점수 : 0");
        _score = 0;

        update = new renewScore();
        btnHap.addActionListener(update);
        btnGeul.addActionListener(update);


        lblScore.setBounds(10,0,50,50);
        btnGeul.setBounds(50, 635, 70,30);
        btnHap.setBounds(180,635,70,30);
        userinput.setBounds(260,635, 160, 30);

        add(lblScore);
        add(btnHap);
        add(btnGeul);
        add(userinput);
    }//constructor

    private Card[] boardInfo;
    public void init(){

        setGameBoardInfo(); //게임 초기화
        GameBoardPanel gameBoard = new GameBoardPanel(boardInfo);
        gameBoard.setBounds(0,100,500,500);
        add(gameBoard);

        calculateHap();
    }

    /*******************************/
    /******** 게임 판 만들기 *********/
    /*******************************/


    public void setGameBoardInfo(){

        boardInfo = new Card[9];
        for (int i = 0; i < 9; i++) {
            Card tmp = new Card();

            boolean duplicated = false;
            //중복 없는 카드판 만들기
            for(int j = 0 ; j < i; j++){
                if(tmp.getCardColor() == boardInfo[j].getCardColor()){
                    if (tmp.getShape() == boardInfo[j].getShape()) {
                        if (tmp.getBackgroundColor() == boardInfo[j].getBackgroundColor()){
                            System.out.println("same~!");
                            duplicated = true;
                            break;
                        }
                    }
                }
            }
            if(!duplicated) boardInfo[i] = tmp;
            else i--;
        }
    }//setGameBoardInfo()


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
    private ArrayList <HashSet> hapset;

    public void calculateHap(){
        hapset = new ArrayList<>();
        hapNum = 0;

        //카드 세 개의 조합이 합인 것 찾기
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++){
                for(int k = j + 1; k < 9 ; k++){
                    if(isHap(boardInfo[i],boardInfo[j],boardInfo[k])){
                        HashSet<Integer> set = new HashSet<Integer>(3);
                        set.add(i+1);
                        set.add(j+1);
                        set.add(k+1);
                        hapset.add(set);
                        hapNum++;
                    }
                }
            }
        }


        //합 개수 맞나 검증용
        /*if(hapNum == 0){
            System.out.println("NONE");
        }
        else{
            for(HashSet obj : hapset){
                System.out.println(obj);
            }
        }*/
        
    }

    /*******************************/
    /********* 점수 계산하기 *********/
    /*******************************/
    private int cnt = 0;
    class renewScore implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnGeul){ //결 누른 경우
                System.out.println("click");
                cnt += 3;

            }
            else if(e.getSource() == btnHap){ //합을 누른 경우
                cnt--;
            }
            lblScore.setText("점수 : " + cnt);
        }
    }


}//Game


