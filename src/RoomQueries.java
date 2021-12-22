/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harsh
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomQueries {
    private static Connection connection;
    private static PreparedStatement getAllPossibleRooms;
    private static PreparedStatement addRooms;
    private static PreparedStatement dropRooms;
    private static ResultSet resultSet; 
    
    public static void addRooms(String Name, int Seats){
        connection = DBConnection.getConnection();
        try
        {
            addRooms = connection.prepareStatement("insert into rooms, seats room(name, seats) values (?,?)");
            addRooms.setString(1, Name);
            addRooms.setInt(2, Seats);
            addRooms.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public void dropRooms(String Name) {
        connection = DBConnection.getConnection();
        try
        {
            dropRooms = connection.prepareStatement("delete from rooms where name = (?) ");
            dropRooms.setString(1, Name);
            dropRooms.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }   
    public static ArrayList<String> getAllPossibleRooms(){
        connection = DBConnection.getConnection();
        ArrayList<String> Rooms = new ArrayList<String>();
        try
        {
            getAllPossibleRooms = connection.prepareStatement("select name from rooms order by name");
            resultSet = getAllPossibleRooms.executeQuery();
            
            while(resultSet.next()) {
                Rooms.add(resultSet.getString(1));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return Rooms;
    }
}
