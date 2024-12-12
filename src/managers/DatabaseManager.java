package managers;

import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class DatabaseManager implements DBConnect{
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Level getLevel(int levelID) {
        try {
            //Connect to the database
            con = DriverManager.getConnection(connectionUrl);
            //SQL querry
            String SQL = format("select l.levelId, l.sizeX, l.sizeY, s.squareid, s.levelid, s.positionx, s.positiony, s.type, s.number, s.direction from level l join square s on l.levelid = s.levelid where s.levelid = %d;", levelID);
            stmt = con.createStatement();
            //execution of the querry
            rs = stmt.executeQuery(SQL);
            int i = 0;
            Level level = null;
            while(rs.next()){
                if(i<1){
                    level = new Level(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                    level.addSquare(new Square(rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8).charAt(0), rs.getString(9).charAt(0), rs.getString(10).charAt(0)));
                    i++;
                }
                else{
                    level.addSquare(new Square(rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8).charAt(0), rs.getString(9).charAt(0), rs.getString(10).charAt(0)));
                }
            }
            return level;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<LeaderBoard> getLeaderBoard(int level){
        try {
            List<LeaderBoard> leaderBoard = new ArrayList<>();
            //Connect to the database
            con = DriverManager.getConnection(connectionUrl);
            //SQL querry
            String SQL = format("select p.playerName, g.time from GameSession g join Player p on p.playerId = g.playerId where levelId = %d  order by g.time asc;", level);
            stmt = con.createStatement();
            //execution of the querry
            rs = stmt.executeQuery(SQL);
            while(rs.next()){
                leaderBoard.add(new LeaderBoard(rs.getString(1), level, rs.getInt(2)));
            }
            return leaderBoard;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    public Board getBoard(){
//        try {
//            //Connect to the database
//            con = DriverManager.getConnection(connectionUrl);
//            //SQL querry
//            String SQL = "select boardId, levelId from board";
//            stmt = con.createStatement();
//            //execution of the querry
//            rs = stmt.executeQuery(SQL);
//            rs.next();
//            return new Board(rs.getInt(1), rs.getInt(2));
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
}
