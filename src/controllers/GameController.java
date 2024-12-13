package controllers;

import models.Board;
import models.Square;

import java.util.*;

public class GameController {
    private int[] previousPosition = new int[2];
    private int[] currentPosition = {0, 0};
    private boolean drawToggle = false;

    /**
     * Player movement check, Doesn't work on lines (and shouldn't), only on squares gotten from levels.
     * @param currentPosition Players current position [x, y].
     * @param map linesMap from Board model.
     * @return Boolean result of the check.
     * */
    public boolean check(int[] currentPosition, Map<int[], String> map){
        boolean isValid = true;
        for (Map.Entry<int[], String> entry : map.entrySet()) {
            int[] position = entry.getKey();
            if(entry.getValue().contains("#")){
                continue;
            }
            if (Arrays.equals(position, currentPosition)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    /**
     * (If needed, move this method to GameWinManager.) Checks for fulfillment of squares conditions.
     *
     * @param squares List of all squares.
     * @param lines HashMap of all lines.
     *
     * @return Boolean result of the check.
     * */
    public boolean squaresWinCondition(List<Square> squares, Map<int[], String> lines){
        int linesNumber = 0;
        int squareNumber = 0;
        for(Square square : squares){
            for(int i = 1; i <= square.getNumber(); i++){
                int[] pos = new int[2];
                pos[0] = square.getPositionX();
                pos[1] = square.getPositionY();
                switch (square.getDirection()){
                    case 'U':
                        pos[0] -= i;
                        if(lines.containsKey(pos)){squareNumber++;}
                        break;
                    case 'D':
                        pos[0] += i;
                        if(lines.containsKey(pos)){squareNumber++;}
                        break;
                    case 'L':
                        pos[1] -= i;
                        if(lines.containsKey(pos)){squareNumber++;}
                        break;
                    case 'R':
                        pos[1] += i;
                        if(lines.containsKey(pos)){squareNumber++;}
                        break;
                }
            }
            linesNumber = squareNumber == square.getNumber() ? linesNumber + 1 : linesNumber;
            squareNumber = 0;
        }
        return linesNumber == lines.size();
    }

    /**
     * Translates user input, and calls appropriate methods
     *
     * @param action Type of action player wants to make.
     * @param board object instance of Board model
     * */
    public void action(char action, Board board){
        switch (action){
            case 'W':
            case 'w':
                currentPosition = board.moveUp(currentPosition, previousPosition);
                previousPosition[0] = currentPosition[0] + 1;
                previousPosition[1] = currentPosition[1];
                if(drawToggle){board.drawLine(currentPosition);}
                break;
            case 'A':
            case 'a':
                currentPosition = board.moveLeft(currentPosition, previousPosition);
                previousPosition[0] = currentPosition[0];
                previousPosition[1] = currentPosition[1] + 1;
                if(drawToggle){board.drawLine(currentPosition);}
                break;
            case 'S':
            case 's':
                currentPosition = board.moveDown(currentPosition, previousPosition);
                previousPosition[0] = currentPosition[0] - 1;
                previousPosition[1] = currentPosition[1];
                if(drawToggle){board.drawLine(currentPosition);}
                break;
            case 'D':
            case 'd':
                currentPosition = board.moveRight(currentPosition, previousPosition);
                previousPosition[0] = currentPosition[0];
                previousPosition[1] = currentPosition[1] - 1;
                if(drawToggle){board.drawLine(currentPosition);}
                break;
            case 'C':
            case 'c':
                drawToggle = !drawToggle;
                if(drawToggle){board.drawLine(currentPosition);}
                break;
            case 'Z':
            case 'z':
                 board.deleteLine(currentPosition);
                 break;
            case 'X':
            case 'x':
                return;
            default:
                System.err.println("Wrong input");
        }
    }
}
