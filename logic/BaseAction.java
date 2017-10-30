package logic;

public class BaseAction implements UserAction {

    private final GameLogic logic;
    private final Board board;
    private final GeneratorBoard generator;

    public  Environment env;

    //-----------------------------------------------
    BaseAction(GameLogic logic, Board board, GeneratorBoard generator) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }

    //--------------------------------------------------------------
    public void newGame() {
        final Cell[][] cells = generator.generate(6, 6, 9);

        this.board.drawBoard(env, cells);
        this.logic.loadBoard(env, cells);
    }

    //----------------------------------------------------------
    public void select(int x, int y, boolean bomb) {
        this.logic.suggest(x, y, bomb);

        if (this.logic.shouldBang(x, y))
            this.board.drawBang();

        if (this.logic.finish())
            this.board.drawWin();
    }

}
