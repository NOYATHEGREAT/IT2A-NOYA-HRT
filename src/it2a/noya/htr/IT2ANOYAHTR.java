
package it2a.noya.htr;

import java.util.Scanner;
public class IT2ANOYAHTR {
    
    public void addPatients(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Patient First Name: ");
        String fname = sc.next();
        System.out.print("Patient Last Name: ");
        String lname = sc.next();
        System.out.print("Patient Date of Birth:  ");
        String dateOfbirth = sc.next();
        System.out.print("Patient Status: ");
        String status = sc.next();
        System.out.print("patient Contact: ");
        String contact = sc.next();
        System.out.print("patient Treatment/Diagnosis: ");
        String TreatDiag = sc.next();
        System.out.print("patient AdmissionDate: ");
        String Admission = sc.next();
        System.out.print("patient Discharge: ");
        String Discharge = sc.next();
        
        String sql = "INSERT INTO Student (s_fname, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, status);


    }
    public static void main(String[] args) {
        
        
    }
    
}
