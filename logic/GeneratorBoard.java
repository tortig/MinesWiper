package logic;

public interface GeneratorBoard {

    // generate play field X*Y , and count of bombs
    Cell[][] generate(int resX, int resY, int numBombs);

    // get a bomb count on the field
    int getNumBombs();
}
