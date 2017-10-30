package gui;

import logic.*;
import java.awt.*;

public class GUICell implements Cell<Graphics> {

    // size of cells
    static final int PADDING = 82;

    // icons mapping
    private final String PATH = "C:\\Users\\Alvina\\workspace\\MinerGameGui\\src\\main\\java\\icons\\";

    // bomb in cell
    private boolean bomb;

    // count of bombs around of cell
    private int around;

    // cell mark like bomb
    private boolean suggestBomb = false;

    // cell is opened
    private boolean open = false;


    public GUICell(boolean bomb) {

        this.bomb = bomb;
    }

    public void setAround(int around) {
        this.around = around;
    }

    public int getAround() {
        return around;
    }

    public boolean isBomb() {

        return this.bomb;
    }

    public boolean isSuggestBomb() {

        return this.suggestBomb;
    }

    public boolean isOpen() {

        return this.open;
    }

    public void suggestBomb() {

        if (!this.open)
            this.suggestBomb = !this.suggestBomb;
    }

    public void open() {

        if (!this.suggestBomb)
            this.open = true;
    }

    //------------------------------------------------
    public Image getImg(){
        Image img = Toolkit.getDefaultToolkit().getImage(this.PATH+"unverified.png");
        if(this.suggestBomb){
            img = Toolkit.getDefaultToolkit().getImage(this.PATH+"suggestBomb.png");
        }else if (this.open){
            img = this.getEmptyImg();
        }
        return img;
    }

    //------------------------------------------------------
    public Image getEmptyImg() {
        Image img = Toolkit.getDefaultToolkit().getImage(this.PATH+"empty.png");
        switch (this.around){
            case 0: break;
            case 1: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"1.png");
            break;
            case 2: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"2.png");
            break;
            case 3: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"3.png");
            break;
            case 4: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"4.png");
            break;
            case 5: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"5.png");
            break;
            case 6: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"6.png");
            break;
            case 7: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"7.png");
            break;
            case 8: img = Toolkit.getDefaultToolkit().getImage(this.PATH+"8.png");
            break;
        }
        return img;
    }

    //----------------------------------------------------------
    public Image getGameOverImg() {

        Image img = this.getEmptyImg();

        if (this.isBomb() && this.isOpen()) {
            img = Toolkit.getDefaultToolkit().getImage(this.PATH+"gameOverBomb.png");
        } else
            if(this.isBomb() && this.isSuggestBomb()) {
                img = Toolkit.getDefaultToolkit().getImage(this.PATH+"suggestBomb.png");
            } else
                if(this.isBomb() && !this.isSuggestBomb()) {
                    img = Toolkit.getDefaultToolkit().getImage(this.PATH+"finishBomb.png");
                } else
                    if(!this.isBomb() && this.isSuggestBomb()) {
                        img = Toolkit.getDefaultToolkit().getImage(this.PATH+"falseSuggestBomb.png");
        }

        return img;
    }

    //-----------------------------------------------------
    public Image getFinishImg() {

        Image img = this.getEmptyImg();

        if (this.isBomb() && this.isSuggestBomb()) {
            img = Toolkit.getDefaultToolkit().getImage(this.PATH+"suggestBomb.png");
        }

        return img;
    }
}