package models;

public class GameSession {
    private int sessionID;
    private int levelID;
    private int playerID;
    private int sessionDuration;

    public GameSession(int sessionID, int levelID, int playerID, int sessionDuration) {
        this.sessionID = sessionID;
        this.levelID = levelID;
        this.playerID = playerID;
        this.sessionDuration = sessionDuration;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(int sessionDuration) {
        this.sessionDuration = sessionDuration;
    }
}
