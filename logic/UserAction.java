package logic;

public interface UserAction {

    // start game
    void newGame();

    // try to check cell in (x,y) position
    void select(int x, int y, boolean bomb);
}

