package models;

import java.util.Scanner;

public class Trainer {
    private int tr_id;
    private String firstName;
    private String lastName;
    private String subject;

    public Trainer(int tr_id, String firstName, String lastName, String subject) {
        this.tr_id = tr_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }    
    
    public int getTr_id() {
        return tr_id;
    }

    public void setTr_id(int tr_id) {
        this.tr_id = tr_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Trainer{" + "tr_id=" + tr_id + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + '}';
    }

    public Trainer() {
    }
    
     public void inputT() {
        Scanner sc = new Scanner(System.in);
        
        boolean check = true;
        while (check = true) {
            System.out.println("\n Please insert the Τrainer's  name");
            firstName = sc.next();
             //validation first name only String
            while (!firstName.matches("[a-zA-Z_]+")) {
            System.out.print("Invalid name!only characters are accepted \nplease insert the Name: ");
            firstName = sc.next();}              
            System.out.println("\n Please insert the Trainer's last name");
            lastName = sc.next();
            while (!lastName.matches("[a-zA-Z_]+")) {
            System.out.print("Invalid name!only characters are accepted \nplease insert the surname: ");
            lastName = sc.next();}                       
            System.out.println("\n Please insert the subject");
            subject = sc.next();            
            System.out.println("\n Would you like to add more Trainers? YES:1 NO:2");
            int num = sc.nextInt();
            if (num == 1) {
                check = false;
            } else if (num == 2) {
                break;
            }
        }
    }
    
}
