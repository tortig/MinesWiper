package gui;

import logic.*;
import java.util.Random;

public class GUIGeneratorBoard implements GeneratorBoard{

    private int numBombs;

    private Cell[][] cells;

    public int getNumBombs() {
        return numBombs;
    }

    // generate play field
    public Cell[][] generate(int resX, int resY, int numBombs) {

        this.numBombs = numBombs; // bombs count
        this.cells = new Cell[resX][resY]; // count of cells

        boolean[][] bombs = new boolean[resX][resY]; // in what cell a bombs

        // random inject bombs in cells
        if (numBombs < resX*resY) {

            int numGeneratedBombs = 0;
            Random rand = new Random();

            while (numGeneratedBombs < this.numBombs) {

                int x = rand.nextInt(resX);
                int y = rand.nextInt(resY);

                if (!bombs[x][y]) {

                    bombs[x][y] = true;
                    numGeneratedBombs++;

                }
            }
        }

        //fill the cell array
        for (int x = 0; x < cells.length; x++) {

            for (int y = 0; y < cells[0].length; y++) {

                cells[x][y] = new GUICell(bombs[x][y]);

            }
        }

        // set around property for cells
        this.setCellsAround();

        return this.cells;
    }

    // set around property for all cells
    private void setCellsAround() {

        for (int x = 0; x < cells.length; x++) {

            for (int y = 0; y < cells[0].length; y++) {

                cells[x][y].setAround(countCellAround(x, y));

            }
        }
    }

    // calculate for cell count of bombs around of it
    private int countCellAround(int x, int y) {

        int counter = 0;

        for (int inX = x-1; inX <= x+1; inX++) {

            for(int inY = y-1; inY <= y+1; inY++) {

                if(inX < 0 || inY < 0 || inX >= cells.length || inY >= cells[0].length) {

                    continue;

                } else
                    if (cells[inX][inY].isBomb())
                        counter++;

            }
        }

        return counter;
    }

}