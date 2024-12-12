package models;

public class Player {
    private int playerID;
    private String playerName;
    private String password;

    public Player(int playerID, String playerName, String password) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Player(){}

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
