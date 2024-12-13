import controllers.GameController;
import managers.DatabaseManager;
import managers.TypeTranslator;
import models.Board;
import models.Level;
import views.*;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args){
        boolean successful = false;
        while(!successful){
            int noAuthAction = new MainMenuNoAuth().menu();
            switch (noAuthAction) {
                case 1:
                    successful= new Login().loginMenu();
                    break;
                case 2:
                    successful= new Register().registerMenu();
                    break;
                case 3:
                    System.out.println("[WIP]");
                    break;
                case 5:
                    return;
            }

            if(successful) {
                while(1>0){
                    int authAction = new MainMenuAuth().menu();
                    switch (authAction) {
                        case 1:
                            int levelId = new LevelSelector().levelSelector();
                            Level level = new DatabaseManager().getLevel(levelId);
                            new BoardView().play(level);
                            break;
                        case 2:
                            System.out.println("I restart game");
                            break;
                        case 3:
                            System.out.println("[WIP]");
                            break;
                        case 4:
                            new LeaderBoardMenu().leaderBoard(1);
                            break;
                        case 5:
                            return;
                    }
                }
            }
        }
    }
}
