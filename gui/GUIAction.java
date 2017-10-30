package gui;

import logic.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUIAction implements UserAction, ActionListener, MouseListener{

    private final GeneratorBoard generator;

    private final GUIBoard board;

    private final GameLogic logic;

    public GUIAction(GeneratorBoard generator, GUIBoard board, GameLogic logic) {

        this.generator = generator;
        this.board = board;
        this.logic = logic;
        this.board.addMouseListener(this);

    }

    // start new game
    public void newGame() {

        int RESOLUTION_X = 6;
        int RESOLUTION_Y = 6;
        int NUM_BOMBS = 9;

        // create a cells object
        final Cell[][] cells = generator.generate(RESOLUTION_X, RESOLUTION_Y, NUM_BOMBS);

        //create a Environment for game
        final Environment env = new Environment(generator.getNumBombs());

        //set the env in board and draw it
        this.board.drawBoard(env, cells);

        //set the env in logic
        this.logic.loadBoard(env, cells);
    }

    // check the choose of player
    public void select(int x, int y, boolean bomb) {

        if(!this.logic.finalized()) {

            // suggest or open the cell
            this.logic.suggest(x, y, bomb);
            // check for blasting
            this.logic.shouldBang(x, y);
            // check for finish
            this.logic.finish();
            // repaint the play board
            this.board.repaint();

        }
    }

    public void actionPerformed(ActionEvent e) {
        this.newGame();
    }

    public void mouseClicked(MouseEvent e) {
        boolean bomb = (e.getButton() != 1);
        this.select(board.getCellOnX(e.getX()),board.getCellOnY(e.getY()), bomb);
        board.repaint();
    }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }
}