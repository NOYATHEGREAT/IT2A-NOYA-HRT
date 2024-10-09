package it2a.noya.htr;

import java.util.Scanner;

public class IT2ANOYAHTR {

    public static void main(String[] args) {
        config conf = new config();
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("1. ADD PATIENT");
            System.out.println("2. VIEW PATIENT");
            System.out.println("3. UPDATE PATIENT");
            System.out.println("4. DELETE PATIENT");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            IT2ANOYAHTR sample = new IT2ANOYAHTR();
            switch (action) {
                case 1:
                    sample.addPatients(conf);  
                    break;
                case 2:
                    conf.viewRecords();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
            System.out.print("Do you want to continue? (Y/N): ");
            response = sc.next();

        } while (response.equalsIgnoreCase("y"));

        sc.close();
    }

    public void addPatients(config conf) {
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

       
        String sql =("INSERT INTO Patients (p_id, p_fname, p_lname, p_email, p_status) VALUES (?, ?, ?, ?, ?)");
        conf.addRecord(sql, id, fname, lname, email, status);
    }
}

