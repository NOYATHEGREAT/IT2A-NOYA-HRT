
package it2a.noya.htr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class config {

    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:HTR-NOYA.db");
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

   public void addRecord(String sql, Object... values) {
    try (Connection conn = this.connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof Integer) {
                pstmt.setInt(i + 1, (Integer) values[i]); 
            } else if (values[i] instanceof Double) {
                pstmt.setDouble(i + 1, (Double) values[i]); 
            } else if (values[i] instanceof Float) {
            } else if (values[i] instanceof Long) {
                pstmt.setLong(i + 1, (Long) values[i]); 
            } else if (values[i] instanceof Boolean) {
                pstmt.setBoolean(i + 1, (Boolean) values[i]); 
            } else if (values[i] instanceof java.util.Date) {
                pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) values[i]).getTime())); 
            } else if (values[i] instanceof java.sql.Date) {
                pstmt.setDate(i + 1, (java.sql.Date) values[i]);
            } else if (values[i] instanceof java.sql.Timestamp) {
                pstmt.setTimestamp(i + 1, (java.sql.Timestamp) values[i]); 
            } else {
                pstmt.setString(i + 1, values[i].toString()); 
            }
        }

        pstmt.executeUpdate();
        System.out.println("Record added successfully!");
    } catch (SQLException e) {
        System.out.println("Error adding record: " + e.getMessage());
    }
}
    public void addPatients() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Patient ID: ");
        String id = sc.next();
        System.out.print("Patient First Name: ");
        String fname = sc.next();
        System.out.print("Patient Last Name: ");
        String lname = sc.next();
        System.out.print("Patient Email: ");
        String email = sc.next();
        System.out.print("Patient Status: ");
        String status = sc.next();

    
        String sql = "INSERT INTO Patients (p_id, p_fname, p_lname, p_email, p_status) VALUES (?, ?, ?, ?, ?)";
        addRecord(sql, id, fname, lname, email, status);
    }

    public void viewRecords() {
        String sql = "SELECT * FROM Patients"; 
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-20s | %-12s | %-25s | %-10s |\n", "Patient ID", "Firstname", "LastName", "Email", "Status");
            System.out.println("--------------------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("p_id");
                String fname = rs.getString("p_fname");
                String lname = rs.getString("p_lname");
                String email = rs.getString("p_email");
                String sts = rs.getString("p_status");

                System.out.printf("| %-5d | %-20s | %-12s | %-25s | %-10s |\n", id, fname, lname, email, sts);
            }

            System.out.println("--------------------------------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("Error retrieving records: " + e.getMessage());
        }
    }
}
