package managers;

import models.Level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TypeTranslator {
    public Map<int[], String> toMap(char[][][] board){
        Map<int[], String> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j][0] == ' ')
                    continue;
                String stringCell = String.valueOf(board[i][j][0]) + board[i][j][1] + board[i][j][2];
                map.put(new int[]{i, j}, stringCell);
            }
        }

        return map;
    }

    public char[][][] toArray(Map<int[], String> map, Level level){
        char[][][] array = new char[level.getSizeX()][level.getSizeY()][3];

        for (Map.Entry<int[], String> entry : map.entrySet()) {
            int[] coordinates = entry.getKey();
            int x = coordinates[0];
            int y = coordinates[1];
            char one = entry.getValue().charAt(0);
            char two = entry.getValue().charAt(1);
            char three = entry.getValue().charAt(2);
            array[x][y][0] = one;
            array[x][y][1] = two;
            array[x][y][2] = three;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j][0] != ' '){
                    array[i][j][0] = ' ';
                    array[i][j][1] = ' ';
                    array[i][j][2] = ' ';
                }
            }
        }
        return array;
    }
}
