package logic;

// play board draw interface
public interface Board {

    // draw a play board
    void drawBoard(Environment e, Cell[][] cells);

    // draw  when loose
    void drawBang();

    // draw when win
    void drawWin();

    // x is horizontal coordinate and y is vertical
    int getCellOnX(int x);

    int getCellOnY(int y);


}