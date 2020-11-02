public class GeulHab {

    public static void main(String[] args) {
        /*Card gameBoard[][];
        gameBoard = new Card[3][3];

        for (int i = 0; i < 3; i++){
            gameBoard[i] = new Card[3];
            for (int j = 0; j < 3; j++){
                gameBoard[i][j] = new Card();
                gameBoard[i][j].getCardInfo();
                System.out.println();

                System.out.println(gameBoard[i][j].cardColor);
            }

        }*/
        Game game = new Game();
        game.getFrame();
    }
}