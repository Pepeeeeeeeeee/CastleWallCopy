package models;


import controllers.GameController;
import managers.TypeTranslator;

import java.util.*;

public class Board {
    char[][][] sampleBoard = new char[8][8][3];
    char[][][] boardSample = {
            // Row 0
            {{' ', ' ', ' '}, {' ', ' ', ' '}, {'L', 'T', 'L'}, {'L', 'T', 'R'}, {'B', '1', '<'}, {'L', 'T', 'L'}, {'L', 'T', 'R'}},
            // Row 1
            {{'B', ' ', ' '}, {'L', 'T', 'L'}, {'L', 'D', 'R'}, {'L', 'D', 'L'}, {'L', 'H', ' '}, {'L', 'D', 'R'}, {'L', 'V', ' '}},
            // Row 2
            {{'L', 'T', 'L'}, {'L', 'D', 'R'}, {'L', 'T', 'L'}, {'L', 'H', ' '}, {'L', 'T', 'R'}, {'W', '1', '>'}, {'L', 'V', ' '}},
            // Row 3
            {{'L', 'V', ' '}, {' ', ' ', ' '}, {'L', 'V', ' '}, {'B', '1', '>'}, {'L', 'V', ' '}, {'L', 'T', 'L'}, {'L', 'D', 'R'}},
            // Row 4
            {{'L', 'V', ' '}, {'W', '1', '^'}, {'L', 'V', ' '}, {' ', ' ', ' '}, {'L', 'V', ' '}, {'L', 'V', ' '}, {' ', ' ', ' '}},
            // Row 5
            {{'L', 'V', ' '}, {'L', 'T', 'L'}, {'L', 'D', 'R'}, {' ', ' ', ' '}, {'L', 'V', ' '}, {'L', 'V', ' '}, {'B', '1', '<'}},
            // Row 6
            {{'L', 'D', 'L'}, {'L', 'D', 'R'}, {'B', '1', '>'}, {' ', ' ', ' '}, {'L', 'D', 'L'}, {'L', 'D', 'R'}, {' ', ' ', ' '}},
    };
    private int boardID;
    private Level level;
    private char[][][] board;
    List<Square> squares = new ArrayList<>();
    private GameController gameController;
    private TypeTranslator typeTranslator = new TypeTranslator();
    private Map<int[], String> linesMap = new HashMap<>();

    /**
     * Builds the game board based on the level's configuration.
     *
     * @return A 3D character array representing the game board.
     */
    public char[][][] buildBoard(Level level, GameController gameController){
        this.gameController = gameController;
        this.level = level;

        int rows = level.getSizeX();
        int cols = level.getSizeY();
        board = new char[rows][cols][3];

        // Initialize the board with empty spaces.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 3; k++) {
                    board[i][j][k] = ' ';
                }
            }
        }

        // Populate the board with squares from the level.
        for (Square square : level.getSquares()) {
            squares.add(square);
            int x = square.getPositionX();
            int y = square.getPositionY();

            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                board[x][y][0] = square.getType();
                board[x][y][1] = (char)square.getNumber();
                board[x][y][2] = getDirectionSymbol(square.getDirection());
            }
        }

        for(Map.Entry<int[], String> entry : linesMap.entrySet()){
            char[] input = entry.getValue().toCharArray();
            int[] position = entry.getKey();
            int x = position[0];
            int y = position[1];
            addToBoard(x, y, input);
        }
        return board;
    }

    /**
     * Converts a direction character to its corresponding symbol.
     *
     * @param direction The direction character (L, R, U, D).
     * @return The corresponding direction symbol ('<', '>', '^', 'V').
     */
    private char getDirectionSymbol(char direction) {
        return switch (direction) {
            case 'L' -> '<';
            case 'R' -> '>';
            case 'U' -> '^';
            case 'D' -> 'V';
            default -> ' ';
        };
    }
//        specialSquares.clear(); // clear special squares
//        specialSquares.put(new int[]{pos[0], pos[1]}, " ## ");
    /**
     * Moves player one position up
     *
     * @param currentPosition Players current position
     * @param previousPosition Players previous position
     * @return New player position
     * */
    public int[] moveUp(int[] currentPosition, int[] previousPosition) {
        // Move player on position up
        currentPosition[0] = currentPosition[0] - 1;
        // Check if move is legal, if yes then display
        if(gameController.check(currentPosition, typeTranslator.toMap(board))){
            char[] cell = {' ', 'P', ' '};
            addToBoard(currentPosition[0], currentPosition[1], cell);
        }
        // Else print no, display player at previous position
        else{
            System.err.println("No");
            previousPosition[0] = currentPosition[0] + 1;
            previousPosition[1] = currentPosition[1];
            char[] cell = {' ', 'P', ' '};
            addToBoard(previousPosition[0], previousPosition[1], cell);
            currentPosition[0] = previousPosition[0];
            currentPosition[1] = previousPosition[1];
        }
        return currentPosition;
    }

    /**
     * Moves player one position down
     *
     * @param currentPosition Players current position
     * @param previousPosition Players previous position
     * @return New player position
     * */
    public int[] moveDown(int[] currentPosition, int[] previousPosition) {
        // Move player on position up
        currentPosition[0] = currentPosition[0] + 1;
        // Check if move is legal, if yes then display
        if(gameController.check(currentPosition, typeTranslator.toMap(board))){
            char[] cell = {' ', 'P', ' '};
            addToBoard(currentPosition[0], currentPosition[1], cell);
        }
        // Else print no, display player at previous position
        else{
            System.err.println("No");
            previousPosition[0] = currentPosition[0] - 1;
            previousPosition[1] = currentPosition[1];
            char[] cell = {' ', 'P', ' '};
            addToBoard(previousPosition[0], previousPosition[1], cell);
            currentPosition[0] = previousPosition[0];
            currentPosition[1] = previousPosition[1];
        }
        return currentPosition;
    }

    /**
     * Moves player one position left
     *
     * @param currentPosition Players current position
     * @param previousPosition Players previous position
     * @return New player position
     * */
    public int[] moveLeft(int[] currentPosition, int[] previousPosition) {
        // Move player on position up
        currentPosition[1] = currentPosition[1] - 1;
        // Check if move is legal, if yes then display
        if(gameController.check(currentPosition, typeTranslator.toMap(board))){
            char[] cell = {' ', 'P', ' '};
            addToBoard(currentPosition[0], currentPosition[1], cell);
        }
        // Else print no, display player at previous position
        else{
            System.err.println("No");
            previousPosition[1] = currentPosition[1] + 1;
            previousPosition[0] = currentPosition[0];
            char[] cell = {' ', 'P', ' '};
            addToBoard(previousPosition[0], previousPosition[1], cell);
            currentPosition[0] = previousPosition[0];
            currentPosition[1] = previousPosition[1];
        }
        return currentPosition;
    }

    /**
     * Moves player one position right
     *
     * @param currentPosition Players current position
     * @param previousPosition Players previous position
     * @return New player position
     * */
    public int[] moveRight(int[] currentPosition, int[] previousPosition) {
        // Move player on position up
        currentPosition[1] = currentPosition[1] + 1;
        // Check if move is legal, if yes then display
        if(gameController.check(currentPosition, typeTranslator.toMap(board))){
            char[] cell = {' ', 'P', ' '};
            addToBoard(currentPosition[0], currentPosition[1], cell);
        }
        // Else print no, display player at previous position
        else{
            System.err.println("No");
            previousPosition[1] = currentPosition[1] - 1;
            previousPosition[0] = currentPosition[0];
            char[] cell = {' ', 'P', ' '};
            addToBoard(previousPosition[0], previousPosition[1], cell);
            currentPosition[0] = previousPosition[0];
            currentPosition[1] = previousPosition[1];
        }
        return currentPosition;
    }

    /**
     * Draws a line between on player position on the board.
     *
     * @param currentPosition Current position [x, y].
     */
    public void drawLine(int[] currentPosition) {
        // Check if move is legal, if yes then proceed (so that the player does not become lost under the line)
        if(gameController.check(currentPosition, typeTranslator.toMap(board))){
            char[] cell = lineFormatter(currentPosition);
            addToBoard(currentPosition[0], currentPosition[1], cell);
            linesMap.put(new int[]{currentPosition[0], currentPosition[1]}, String.valueOf(cell));
        }
        else {
            System.err.println("No");
        }
        if(gameController.squaresWinCondition(squares, typeTranslator.toMap(board))){
            System.out.println("YOU PROBABLY WON!");
        }
    }

    /**
     * Deletes a line at the specified position.
     *
     * @param currentPosition The position [x, y] where the line should be deleted.
     */
    public void deleteLine(int[] currentPosition) {
        char[] cell = {' ', ' ', ' '};
        addToBoard(currentPosition[0], currentPosition[1], cell);
        removeFromMap(currentPosition);
        cell = new char[]{' ', 'P', ' '};
        addToBoard(currentPosition[0], currentPosition[1], cell);
    }

    public int getBoardID() {
        return boardID;
    }

    public void setBoardID(int boardID) {
        this.boardID = boardID;
    }

    public Level getLevel() {
        return level;
    }

    private void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Generates a string representation of the board.
     *
     * @return The string representation of the board.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //board = boardSample;
        int rows = board.length;
        int cols = board[0].length;
        int cellWidth = 4; // 1 cell for wall, 3 cells for content

        for (int i = 0; i < rows; i++) {
            // Draw horizontal grid lines
            for (int j = 0; j <= cols * cellWidth; j++) {

                char[] cell = board[i][(j-1)/cellWidth];
                if(cell[0] == 'L'){
                    if((j%cellWidth == 2) && (cell[1] == 'V' || cell[1] == 'D')){
                        sb.append('#');
                    }else
                        sb.append('-');
                }else{
                    sb.append(j % cellWidth == 0 ? "+" : "-");
                }

            }
            sb.append("\n");

            // Draw vertical grid lines and content
            for (int j = 0; j < cols; j++) {
                sb.append("|");
                if(board[i][j][0] != 'L')
                    sb.append(board[i][j][0]).append(board[i][j][1]).append(board[i][j][2]);
                else
                    sb.append(renderLine(board[i][j]));
            }
            sb.append("|\n");
        }

        // Draw bottom border
        for (int j = 0; j <= cols * cellWidth; j++) {
            sb.append(j % cellWidth == 0 ? "+" : "-");
        }

        return sb.toString();
    }

    private char[] renderLine( char[] chars) {
        if(chars[1] == 'T' || chars[1] == 'D'){
            if(chars[2] == 'L')
                return new char[]{' ','#','#'};
            else
                return new char[]{'#','#',' '};
        }

        if(chars[1] == 'H')
            return new char[]{'#','#','#'};
        if(chars[1] == 'V')
            return new char[]{' ','#',' '};

        return chars;

    }

    public char[][][] getBoard() {
        return board;
    }

    public void addToBoard(int x, int y, char[] cell) {
        this.board[x][y] = cell; //char[3]
    }

    /**
     * Removes an entry from a map using a key.
     *
     * @param key int array of player position [x, y]
     * */
    public void removeFromMap(int[] key){
        Map<int[], String> map = new HashMap<>();
        for(Map.Entry<int[], String> entry : linesMap.entrySet()){
            int[] mapKey = entry.getKey();
            String mapValue = entry.getValue();
            if(!Arrays.equals(mapKey, key)){
                map.put(mapKey, mapValue);
            }
        }
        linesMap.clear();
        linesMap = map;
    }


    /**
     * (This is currently broken. pls fix) Formats a line to correct format
     *
     * @param currentPosition The position [x, y] where the line will be placed.
     *
     * @return Char array containing the line format
     * */
    public char[] lineFormatter(int[] currentPosition) {
        int i = 0;
        int[] twoLinesAgo = new int[2];
        int[] oneLineAgo = new int[2];
        for(Map.Entry<int[], String> entry : linesMap.entrySet()){
            if(i == linesMap.size() - 2){
                twoLinesAgo = entry.getKey();
            }
            else if (i == linesMap.size() - 1){
                oneLineAgo = entry.getKey();
            }
            i++;
        }

        if((currentPosition[0] < oneLineAgo[0] && currentPosition[0] < twoLinesAgo[0])
                || (currentPosition[0] > oneLineAgo[0] && currentPosition[0] > twoLinesAgo[0])){
            return new char[]{' ','#',' '};
        }
        else if((currentPosition[0] == oneLineAgo[0] && currentPosition[0] == twoLinesAgo[0])
                && ((currentPosition[1] < oneLineAgo[1] && currentPosition[1] < twoLinesAgo[1])
                || (currentPosition[1] > oneLineAgo[1] && currentPosition[1] > twoLinesAgo[1]))){
            return new char[]{'#','#','#'};
        }
        else if ((currentPosition[1] > oneLineAgo[1] && currentPosition[0] > twoLinesAgo[0]) || (currentPosition[1] < oneLineAgo[1] && currentPosition[0] < twoLinesAgo[0])){

            return new char[]{' ','#','#'};
        }
        else{
            return new char[]{'#','#',' '};
        }
    }
}


