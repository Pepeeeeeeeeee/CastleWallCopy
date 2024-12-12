package views;

import controllers.GameController;
import models.Board;
import models.Level;

import java.util.Map;
import java.util.Scanner;

public class BoardView {
    private Scanner scanner = new Scanner(System.in);
    private GameController gameController = new GameController();
    private Board board;
    public void play(Level level){
        this.board = new Board();
        while(scanner.hasNext()){
            char action = scanner.next().charAt(0);
            board.buildBoard(level, gameController);
            gameController.action(action, board);
            System.out.println(board);
        }
    }
}
