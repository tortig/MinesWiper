package gui;

import javax.swing.*;
import java.awt.*;
import logic.*;

public class GUIBoard extends JPanel implements Board {

    // game information object
    private Environment env;

    // cells array
    private Cell[][] cells;

    //--------------------------------------------------
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (this.cells != null) {
            for (int x = 0; x != this.cells.length; x++) {
                for (int y = 0; y != cells[0].length; y++) {
                    g.drawImage(this.getCellImage(x, y), x* GUICell.PADDING, y* GUICell.PADDING, this);
                }
            }
        }
    }

    // return the right icon for cell
    private Image getCellImage(int x, int y) {

        Image img = cells[x][y].getImg();

        if (env.isGameOver()) {
            img = cells[x][y].getGameOverImg();
        } else
            if (env.isFinish()) {
                img = cells[x][y].getFinishImg();
            }

        return img;
    }

   // initialize the field and paint
    public void drawBoard(Environment e, Cell[][] cells) {
        this.env = e;
        this.cells = cells;
        this.repaint();
    }

    public void drawBang() {
    }

    public void drawWin() {
    }

    // take a number of cell using X coordinate
    public int getCellOnX(int x) {
        return  x / GUICell.PADDING;
    }

    // take a number of cell using Y coordinate
    public int getCellOnY(int y) {
        return  y / GUICell.PADDING;
    }

}