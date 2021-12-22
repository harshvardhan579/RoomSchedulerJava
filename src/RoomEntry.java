/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harsh
 */
public class RoomEntry {
    public static String Name;
    public static int Seats;
    
    public RoomEntry(String a, int b) {
        this.Name = a;
        this.Seats = b;
}
    public static String getName() {
        return Name;
    }
    
    public static int getSeats() {
        return Seats;
    }
}
