package views;

import managers.DatabaseManager;
import models.LeaderBoard;

import java.util.List;

public class LeaderBoardMenu {
    public void leaderBoard(int level) {
        System.out.printf("Leader Board level %d\n", level);
        System.out.println();
        System.out.println();

        DatabaseManager db = new DatabaseManager();

        List<LeaderBoard> leaderBoard = db.getLeaderBoard(1);

        for(LeaderBoard lb : leaderBoard) {
            System.out.println(lb.toString());
        }
    }
}
