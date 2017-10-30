package logic;

public class Easy implements GameLogic {

    private Cell[][] cells;

    private Environment env;

    // auto open function------------------------------------------
    public void selfOpen(int x, int y) {

        this.cells[x][y].open();

        for (int inX = x - 1; inX <= x + 1; inX++) {
            for (int inY = y - 1; inY <= y + 1; inY++) {
                if ( inX < 0 || inY < 0 ||
                        (inX == x && inY == y ) ||
                                inX >= cells.length || inY >= cells[0].length
                        ) {
                    continue;
                } else if (cells[inX][inY].getAround() == 0 && !cells[inX][inY].isOpen()) {
                    this.selfOpen(inX, inY);
                } else {
                    cells[inX][inY].open();
                }
            }
        }
    }

    // play board loading---------------------------------------------
    public void loadBoard(Environment e, Cell[][] cells) {

        this.env = e;
        this.cells = cells;

    }

    // check blast---------------------------------------------
    public boolean shouldBang(int x, int y) {

        final Cell selected = this.cells[x][y];

        if(selected.isBomb() && selected.isOpen()) {
            this.env.setGameOver(true);

            return true;
        } else
            return false;
    }

    // mark the cell-----------------------------------------------------
    public void suggest(int x, int y, boolean bomb) {

        if (bomb) {
            this.cells[x][y].suggestBomb();
            } else
                if (cells[x][y].getAround()==0 && !cells[x][y].isSuggestBomb()) {
                    this.selfOpen(x, y);
                } else
                    this.cells[x][y].open();
    }

    // mark not opened cell if it bomb---------------------------------
    private void selfSuggest() {

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if(cell.isBomb() && !cell.isSuggestBomb()) {
                    cell.suggestBomb();
                }
            }
        }
    }

    // check the success end of game-----------------------------------
    public boolean finish() {

        if(!this.minEnclosedCells()) {

            for (Cell[] row: cells) {

                for (Cell cell: row) {

                    if ( (!cell.isSuggestBomb() && cell.isBomb()) ||
                            (!cell.isOpen() && !cell.isBomb()) ||
                                (cell.isSuggestBomb() && !cell.isBomb()) )

                        return false;
                }
            }
        }

        this.env.setFinish(true);
        return true;
    }


    // final of the game-------------------------------------------------------------------
    public boolean finalized() {

        return (env.isFinish() || env.isGameOver());
    }

    // check not opened cells count equals bomb count--------------------------------
    private boolean minEnclosedCells() {

        int numEnclosed = 0;

        for (int x = 0; x < cells.length; x++) {

            for (int y = 0; y < cells[0].length; y++) {

                if(!cells[x][y].isOpen())
                    numEnclosed++;
            }
        }

        if(numEnclosed == env.getNumBombs()) {
            this.selfSuggest();
            return true;
        } else
            return false;
    }

}