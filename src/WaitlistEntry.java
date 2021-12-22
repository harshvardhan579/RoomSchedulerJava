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
import java.sql.Date;
import java.sql.Timestamp;


public class WaitlistEntry {
    private static Connection connection;
    private static String Faculty;
    private static Date date;
    private static int Seats;
    private static Timestamp timestamp;
    
    public WaitlistEntry(String F, Date d, int S, Timestamp t) {
        this.Faculty = F;
        this.date = d;
        this.Seats = S;
        this.timestamp = t;
    }
    
    public static String getFaculty() {
        return Faculty;
    }
    
    public static Date getDate() {
        return date; 
    }
    
    public static int getSeats() {
        return Seats;
    }
    
    public static Timestamp getTimestamp() {
        return timestamp;
    }
}
