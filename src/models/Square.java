package models;

public class Square {
    private int squareId;
    private int levelId;
    private int positionX;
    private int positionY;
    private char type;
    private char number;
    private char direction;

    public Square(int squareId, int levelId, int positionX, int positionY, char type, char number, char direction) {
        this.squareId = squareId;
        this.levelId = levelId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.type = type;
        this.number = number;
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getNumber() {
        return number;
    }

    public void setNumber(char number) {
        this.number = number;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSquareId() {
        return squareId;
    }

    public void setSquareId(int squareId) {
        this.squareId = squareId;
    }
}
