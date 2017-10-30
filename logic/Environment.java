package logic;

public class Environment {

    // success end of game
    private boolean finish;

    // loose the game
    private boolean gameOver;

    // count of bombs on the field
    private int numBombs;

    public Environment(int numBombs) {
        this.numBombs = numBombs;
        this.finish = false;
        this.gameOver = false;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public void setNumBombs(int numBombs) {
        this.numBombs = numBombs;
    }
}
