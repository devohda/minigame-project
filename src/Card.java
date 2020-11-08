import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Card {

    private CardColor cardColor;
    private Shape shape;
    private BackgroundColor backgroundColor;

    //constructor
    public Card(){
        setCardColor();
        setShape();
        setBackgroundColor();
    }

    public void getCardInfo(){
        System.out.println("color is " + cardColor);
        System.out.println("shape is " + shape);
        System.out.println("backGround color is " + backgroundColor);
    }

    //set 함수
    //랜덤으로 배경색, 모양, 도형의 색 결정
    Random random = new Random();
    
    public void setCardColor(){ //
        CardColor cardColorSet[] = CardColor.values();
        cardColor = cardColorSet[random.nextInt(3)];
    }
    public void setShape(){
        Shape shapeSet[] = Shape.values();
        shape = shapeSet[random.nextInt(3)];
    }
    public void setBackgroundColor(){
        BackgroundColor backgroundColorSet[] = BackgroundColor.values();
        backgroundColor = backgroundColorSet[random.nextInt(3)];
    }
    
    //get 함수
    public CardColor getCardColor(){
        return cardColor;
    }
    public Shape getShape(){
        return shape;
    }
    public BackgroundColor getBackgroundColor() {
        return backgroundColor;
    }


    //카드 그리기(GUI)
    class Figure extends JPanel{

        public void paintComponent(Graphics paint){

            super.paintComponent(paint); //패널 내 잔상 지우기
            
            //카드 배경 칠하기
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
            
            // 도형 색깔 결정하기
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
            
            //도형 그리기
            switch (shape){

                case CIRCLE -> { //원 그리기
                    paint.fillOval(15,15,70,70);
                }
                case SQUARE -> { // 사각형 그리기
                    paint.fillRect(15,15,70,70);
                }
                case TRIANGLE -> { //삼각형 그리기
                    int x[] = { 15, 50, 85 };
                    int y[] = { 85, 15, 85 };
                    paint.fillPolygon( x, y, 3 );
                }
            }
        }
    }

    public Figure drawCard(){
        return new Figure();
    }
}