package managers;

import models.Player;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Map;

import static java.lang.String.format;

public class AuthManager implements DBConnect {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    private String hashPassword(String password){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            return new String(messageDigest.digest());
        }
        catch (NoSuchAlgorithmException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    protected Player login(String name, String password ) {
        try {
            //Connect to the database
            con = DriverManager.getConnection(connectionUrl);
            //SQL querry
            String SQL = format("select playerId, playerName from Player where playerName = '%s' and password = '%s';", name, hashPassword(password));
            stmt = null;
            stmt = con.createStatement();
            //execution of the querry
            rs = null;
            rs = stmt.executeQuery(SQL);
            rs.next();
            //return the result
            return new Player(rs.getInt(1), rs.getString(2), hashPassword(password));

        }
        catch (SQLException e) {
            System.err.println("Invalid credentials or something I guess");
        }
        return null;
    }

    public Player register(String name, String password, String passwordConfirmation) {
        try {
            if (password.equals(passwordConfirmation)) {
//                try{
//
//                }
                //Connect to the database
                con = DriverManager.getConnection(connectionUrl);
                //SQL querry
                String SQL = format("select count(playerName) from Player where playerName = '%s';", name);
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                rs.next();
                int res = rs.getInt(1);
                if(res == 0){
                    stmt = null;

                    SQL = format("insert into Player(playerName, password) values ('%s', '%s');", name, hashPassword(password));
                    stmt = con.createStatement();
                    //execution of the querry
                    int inserted = stmt.executeUpdate(SQL);
                    //return the result
                    stmt.close();
                    rs.close();
                    con.close();

                    return login(name, password);
                }
                else{
                    return null;
                }
            }
            else {
                System.err.println("No");
            }
        }
        catch(SQLException e){
            System.err.println("Invalid credentials or something I guess");
        }
        return null;
    }
}
