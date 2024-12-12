package models;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int levelId;
    private int sizeX;
    private int sizeY;
    private List<Square> squares = new ArrayList<>();

    public Level(int levelId, int sizeX, int sizeY) {
        this.levelId = levelId;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public List<Square> getSquares() {
        return squares;
    }

    public void addSquare(Square square) {
        squares.add(square);
    }

    public void removeSquare(int squareId) {
        for(Square square : squares) {
            if (squareId == square.getSquareId()) {
                squares.remove(square);
                break;
            }
        }
    }
}
