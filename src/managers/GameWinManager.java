//package managers;
//
//import models.Board;
//import models.Square;
//
//import java.lang.reflect.Type;
//import java.util.*;
//
//public class GameWinManager {
//    Set<String> visitedSquares = new HashSet<>();
//    int width;
//    int height;
//    Board board;
//
////    private boolean checkOutsideInsideCondition() {
////        width = board.length;
////        height = board[0].length;
////        TypeTranslator typeTranslator = new TypeTranslator();
////        Map<int[],String> map =typeTranslator.toMap(board.boardSample);
////        for (Map.Entry<int[], String> entry : map.entrySet()) {
////            findBorder(3, 4, 'R');
//////            if(entry.getValue().toCharArray()[0] == 'W') {
//////                 if(findBorder(entry.getKey()[0], entry.getKey()[1], 'R')){
//////                     return true;
//////                 }
//////            }
////        }
////        return false;
////    }
//    public enum Direction {
//        UP(0, -1, 'U'),
//        DOWN(0, 1, 'D'),
//        LEFT(-1, 0, 'L'),
//        RIGHT(1, 0, 'R');
//
//        final int x;
//        final int y;
//        final char name;
//
//        Direction(int x, int y, char name) {
//            this.x = x;
//            this.y = y;
//            this.name = name;
//        }
//
//        int[] toArray() {
//            return new int[]{x, y};
//        }
//    }
//    private boolean findBorder(int cordX, int cordY, char direction) {
//        String posKey = cordX + "," + cordY;  // Key for the visited set
//        if (visitedSquares.contains(posKey)) {
//            return false;
//        }
//
//        if (cordX == 0 || cordY == 0 || cordX == width - 1 || cordY == height - 1) {
//            System.out.println("Found Border: pos["+ cordX+ "," + cordY+"]");
//            return true;
//        }
//
//        visitedSquares.add(posKey);  // Mark this position as visited
//
//        char[] cell = board.boardSample[cordX][cordY];
//
//        if (cell[0] == 'B') {
//            System.out.println("Found black Square Inside: ["+ cordX+ "," + cordY+"]");
//            return true;
//        }
//
//        Set<Direction> directions = findDirections(cell, direction);
//
//        for (Direction dir : directions) {
//            if (findBorder(cordX + dir.x, cordY + dir.y, dir.name)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//
//    private Set<Direction> findDirections(char[] cell, char dir) {
//
//        // set valid Directions based on the
//        Set<Direction> validDirections = getValidDirections(cell, dir);
//
//        int amount = getRotationAmount(cell);
//
//        validDirections = rotateDirections(amount, validDirections);
//
//
//        return validDirections;
//    }
//    public int getRotationAmount(char[] cell){
//        if(cell[1] == 'T' && cell[2] == 'L'){
//            return 1;
//        }if(cell[1] == 'T' && cell[2] == 'R'){
//            return 3;
//        }else if(cell[1] == 'D' && cell[2] == 'R'){
//            return 2;
//        }else if(cell[1] == 'D' && cell[2] == 'L'){
//            return 0;
//        }
//        if(cell[1] == 'H'){
//            return 2;
//        }
//
//        return 0;
//    }
//    public Set<Direction> getValidDirections(char[] cell, char dir) {
//        Set<Direction> validDirections = new HashSet<>();
//        if (cell[0] == 'L') {
//            // based on Vertical Line
//            if (cell[1] == 'V' || cell[1] == 'H') {
//                if (dir == 'R' || dir == 'L') {
//                    validDirections.add(Direction.UP);
//                    validDirections.add(Direction.DOWN);
//                } else if (dir == 'U') {
//                    validDirections.add(Direction.UP);
//                } else {
//                    validDirections.add(Direction.DOWN);
//                }
//            } else if ((cell[1] == 'T' || cell[1] == 'D' ) && (cell[2] == 'R' || cell[2] == 'L')){
//                //based on Down-Left corner
//                if (dir == 'U') {
//                    validDirections.add(Direction.RIGHT);
//                } else if (dir == 'D') {
//                    validDirections.add(Direction.LEFT);
//                    validDirections.add(Direction.RIGHT);
//                }else if(dir == 'R') {
//                    validDirections.add(Direction.UP);
//                    validDirections.add(Direction.DOWN);
//                }else{
//                    validDirections.add(Direction.DOWN);
//                }
//            }
//        }
//        return validDirections;
//    }
//    //90-degree rotation clockwise
//    public Set<Direction> rotateDirections(int amount, Set<Direction> curDirections) {
//        Set<Direction> newDirections = curDirections;
//        for (int i = 0; i < amount; i++) {
//            Set<Direction> tempDirection = new HashSet<Direction>();
//            for (Direction dir : newDirections) {
//                Direction newDir = switch (dir) {
//                    case UP -> Direction.RIGHT;
//                    case RIGHT -> Direction.DOWN;
//                    case DOWN -> Direction.LEFT;
//                    case LEFT -> Direction.UP;
//                    default -> dir;
//                };
//                tempDirection.add(newDir);
//            }
//            newDirections = tempDirection;
//        }
//
//        return newDirections;
//
//    }
//
//}
