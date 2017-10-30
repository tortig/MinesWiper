package logic;

import java.awt.*;

public interface Cell<T> {

    // hau many bombs around of this cell getter
    int getAround();

    // hau many bombs around of this cell setter
    void setAround(int around);

    // check bomb in the cell
    boolean isBomb();

    // mark the cell like bomb
    void suggestBomb();

    // check the cell suggested(marked) like bomb
    boolean isSuggestBomb();

    // open the cell
    void open();

    // check the cell is opened or not
    boolean isOpen();

    Image getImg();
    Image getEmptyImg();
    Image getGameOverImg();
    Image getFinishImg();

}