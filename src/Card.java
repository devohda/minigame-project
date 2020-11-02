import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Card {

    private CardColor cardColorSet[] = CardColor.values();
    private Shape shapeSet[] = Shape.values();
    private BackgroundColor backgroundColorSet[] = BackgroundColor.values();

    public CardColor cardColor;
    public Shape shape;
    public BackgroundColor backgroundColor;

    Random random = new Random();

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
    private void setCardColor(){
        int index = random.nextInt(3);
        cardColor = cardColorSet[index];
    }
    private void setShape(){
        int index = random.nextInt(3);
        shape = shapeSet[index];
    }
    private void setBackgroundColor(){
        int index = random.nextInt(3);
        backgroundColor = backgroundColorSet[index];
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

   
    public JPanel makeCard(Graphics paint){
        JPanel cardPanel = new JPanel();
        cardPanel.setSize(new Dimension(10,100));


        switch (backgroundColor){
            case WHITE -> {
                cardPanel.setBackground(Color.WHITE);
            }
            case GRAY -> {
                cardPanel.setBackground(Color.GRAY);
            }
            case BLACK -> {
                cardPanel.setBackground(Color.BLACK);
            }
        }

        //cardPanel.setBackground(Color.pink);
        /*cardPanel.paintComponents(paint);
        paint.setColor(new Color(30,105,41));
        paint.fillOval(0,0,50,50);*/

        return cardPanel;
    }


}