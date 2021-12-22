/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 *
 * @author harsh
 */
public class WaitlistQueries {
    private static Connection connection;
    private static PreparedStatement getWaitlistByDate;
    private static PreparedStatement getWaitlistByFaculty;
    private static PreparedStatement addWaitlistEntry;
    private static PreparedStatement deleteWaitlistEntry;
    private static ResultSet resultSet;
    
    public static ArrayList<String> getWaitlistByDate(){
        connection = DBConnection.getConnection();
        ArrayList<String> waitlistByDate = new ArrayList<String>();
        try
        {
            getWaitlistByDate = connection.prepareStatement("select faculty,date,seats from waitlist order by date");
            resultSet = getWaitlistByDate.executeQuery();
            
            while(resultSet.next()) {
                waitlistByDate.add(resultSet.getString(1)+"\t"+resultSet.getDate(2).toString()+"\t"+resultSet.getInt(3)+"\n");
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return waitlistByDate;
    }
    
    public static ArrayList<String> getWaitlistByFaculty(String Faculty) {
        connection = DBConnection.getConnection();
        ArrayList<String> waitlistByFaculty = new ArrayList<String>();
        try
        {
            getWaitlistByFaculty = connection.prepareStatement("select faculty from waitlist faculty = (?)");
            getWaitlistByFaculty.setString(1, Faculty);
            resultSet = getWaitlistByDate.executeQuery();
            
            while(resultSet.next()) {
                waitlistByFaculty.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return waitlistByFaculty;
    }
    
    public static void addWaitlistEntry(String Faculty, Date date, int Seats, Timestamp timestamp) {
        connection = DBConnection.getConnection();
        try
        {
            addWaitlistEntry = connection.prepareStatement("insert into waitlist (faculty, date, Seats, timestamp) values (?,?,?,?)");
            addWaitlistEntry.setString(1, Faculty);
            addWaitlistEntry.setDate(2, date);
            addWaitlistEntry.setInt(3, Seats);
            addWaitlistEntry.setTimestamp(4, timestamp);
            addWaitlistEntry.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static void deleteWaitlistEntry(String Faculty) {
        connection = DBConnection.getConnection();
        try
        {
            deleteWaitlistEntry = connection.prepareStatement("delete from waitlist where name = (?)");
            deleteWaitlistEntry.setString(1, Faculty);
            deleteWaitlistEntry.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
