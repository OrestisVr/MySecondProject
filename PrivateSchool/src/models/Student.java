package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static models.DatabaseClass.DB_URL;
import static models.DatabaseClass.JDBC_DRIVER;
import static models.DatabaseClass.PASSWORD;
import static models.DatabaseClass.USERNAME;

public class Student {

    private int stu_id;
    private String firstName;
    private String lastName;
    private String DateOfBirth;
    private float tuitionFees;

    public Student(int stu_id, String firstName, String lastName, String DateOfBirth, float tuitionFees) {
        this.stu_id = stu_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DateOfBirth = DateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
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

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public float getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(float tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    void add(Student studentpercourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void add(List<Student> studentpercourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "stu_id=" + stu_id + ", firstName=" + firstName + ", lastName=" + lastName + ", DateOfBirth=" + DateOfBirth + ", tuitionFees=" + tuitionFees + '}';
    }

    public void inputS() throws ParseException {

        Scanner sc = new Scanner(System.in);
        boolean check = true;
        while (check = true) {
            System.out.print("\n insert the name of student: ");
            firstName = sc.next();
            //validation first name only String
            while (!firstName.matches("[a-zA-Z_]+")) {
                System.out.print("Invalid name!only characters are accepted \nplease insert the Name: ");
                firstName = sc.next();
            }
            System.out.print("\n insert the surname of student: ");
            lastName = sc.next();
            //validation last name
            while (!lastName.matches("[a-zA-Z_]+")) {
                System.out.print("Invalid name!only characters are accepted \nplease insert the surname: ");
                lastName = sc.next();
            }
            System.out.print("\n insert the date of birth (yyyy-MM-dd): ");
            String dateOfBirth = sc.next();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = formatter.parse(dateOfBirth);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            System.out.print("\n insert the tuition fees: ");
            tuitionFees = sc.nextFloat();

            
            System.out.println("\n Would you like to add more Students? YES:1 NO:2");
            int num = sc.nextInt();
            if (num == 1) {
                check = false;
            } else if (num == 2) {
                break;
            }
            Connection connection = null;
            Statement statement = null;
            try {
                Class.forName(JDBC_DRIVER);
                System.out.println("Connecting to database...");
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                System.out.println("Connection created successfully.");
                statement = connection.createStatement();

                String query = "INSERT INTO STUDENTS(FIRST_NAME, LAST_NAME,DATE_OF_BIRTH,TUITION_FEES) VALUES ('" + firstName + "', '" + lastName + "' , '" + dateDB + "','" + tuitionFees + "')";

                int result = statement.executeUpdate(query);
                System.out.println(result + " row(s) affected.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        boolean studentNameExists = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " SELECT FIRST_NAME,LAST_NAME FROM STUDENTS WHERE FIRST_NAME = ?,LAST_NAME=? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String count = resultSet.getString(1);
                String coun = resultSet.getString(2);

                if (count == firstName && coun==lastName) {
                    studentNameExists = true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
}
    

