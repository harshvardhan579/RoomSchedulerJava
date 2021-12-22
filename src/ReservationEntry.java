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

public class ReservationEntry {
    private static Connection connection;
    private static String Faculty;
    private static String Room;
    private static Date date;
    private static int Seats;
    private static Timestamp timestamp;
    
    public ReservationEntry (String F, String R, Date D, int S, Timestamp T) {
        this.Faculty = F;
        this.Room = R;
        this.date = D;
        this.Seats = S;
        this.timestamp = T;
    }
    
    public static String getFaculty() {
        return Faculty;
    }
    
    public static String getRoom() {
        return Room;
    }
    
    public static Date getDate() {
        return date; 
    }
    
    public static int Seats() {
        return Seats;
    }
    
    public static Timestamp timestamp() {
        return timestamp;
    }
}
