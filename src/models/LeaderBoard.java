package models;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class LeaderBoard {
    private int level;
    private String playerName;
    private int time;

    public LeaderBoard(String playerName, int level, int time) {
        this.playerName = playerName;
        this.level = level;
        this.time = time;
    }

    @Override
    public String toString() {
        return format("%-20s %.1f", playerName, (double)time/60);
    }
}
