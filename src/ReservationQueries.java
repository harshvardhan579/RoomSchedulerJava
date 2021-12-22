
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harsh
 */
public class ReservationQueries {
    private static Connection connection;
    private static PreparedStatement getReservationsByDate;
    private static PreparedStatement getRoomReservedByDate;
    private static PreparedStatement addReservationEntry;
    private static PreparedStatement getReservationByFaculty;
    private static PreparedStatement deleteReservation;
    private static ResultSet resultSet;
    
    public static ArrayList<String> getReservationByDate(Date date){
        connection = DBConnection.getConnection();
        ArrayList<String> reservationDate = new ArrayList<String>();
        
        try
        {
            getReservationsByDate = connection.prepareStatement("select faculty,room from reservations where date = (?)");
            getReservationsByDate.setDate(1, date);
            resultSet = getReservationsByDate.executeQuery();
            
            while (resultSet.next()) {
                reservationDate.add(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\n");
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return reservationDate;
    }
    
    public static ArrayList<String> getRoomReservedByDate(Date date) {
        connection = DBConnection.getConnection();
        ArrayList<String> roomReserved = new ArrayList<String>();
        
        try
        {
            getRoomReservedByDate = connection.prepareStatement("select room from reservations where date = (?)");
            getRoomReservedByDate.setDate(1, date);
            resultSet = getRoomReservedByDate.executeQuery();
            
            while (resultSet.next()) {
                roomReserved.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return roomReserved;
    }
    
    public static void addReservationEntry(String Faculty, String Room, Date date, int Seats, Timestamp timestamp) {
        connection = DBConnection.getConnection();
        try
        {
            addReservationEntry = connection.prepareStatement("insert into reservations (faculty, room, date, Seats, timestamp) values (?,?,?,?,?)");
            addReservationEntry.setString(1, Faculty);
            addReservationEntry.setString(2, Room);
            addReservationEntry.setDate(3, date);
            addReservationEntry.setInt(4, Seats);
            addReservationEntry.setTimestamp(5, timestamp);
            addReservationEntry.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getReservationByFaculty(String Faculty){
        connection = DBConnection.getConnection();
        ArrayList<String> reservedRoom = new ArrayList<String>();
        
        try
        {
            getReservationByFaculty = connection.prepareStatement("select room, date from reservations where faculty = (?)");
            getReservationByFaculty.setString(1, Faculty);
            resultSet = getReservationByFaculty.executeQuery();
            
            while(resultSet.next())
            {
                reservedRoom.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return reservedRoom;
    }
    
    public static void deleteReservation(String Faculty){
        connection = DBConnection.getConnection();
        try
        {
            deleteReservation = connection.prepareStatement("delete from reservation where name = (?)");
            deleteReservation.setString(1, Faculty);
            deleteReservation.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

