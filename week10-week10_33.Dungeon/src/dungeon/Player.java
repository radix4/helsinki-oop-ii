package dungeon;

public class Player{
    private int x;
    private int y;
    private Game game;
    private int moves;

    public Player(int x, int y, Game game, int numberOfMoves) {
        this.x = x;
        this.y = y;
        this.game = game;
        this.moves = numberOfMoves;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMoves(){
        return moves;
    }

    public void move(){
        moves--;
    }

    public boolean zeroMovesLeft(){
        return moves == 0;
    }



    public void execute(char c){
        int newX = x;
        int newY = y;

            if (c == 'w'){
                newY++;
            }else if (c == 's'){
                newY--;
            }else if (c == 'd'){
                newX++;
            }else if (c == 'a'){
                newX++;
            }else {
                //ignore
            }

        if(game.isMoveLegal(newX,newY)){
            x = newX;
            y = newY;
        }

    }


}