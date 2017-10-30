package logic;

public interface GameLogic {

    // cell auto open function
    void selfOpen(int x, int y);

    // load the play field
    void loadBoard(Environment e, Cell[][] cells);

    // blast in this cell
    boolean shouldBang(int x, int y);

    // mark cell like bomb or open it
    void suggest(int x, int y, boolean bomb);

    // check the success end of game
    boolean finish();

    // final of game
    boolean finalized();

}
