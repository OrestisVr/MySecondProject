package models;

import java.sql.Connection;
import java.sql.DriverManager;
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

public class Course {
    private int course_id;
    private String title;
    private String stream;
    private String type;
    private String startDate;
    private String endDate;

    public Course(int course_id, String title, String stream, String type, String startDate, String endDate) {
        this.course_id = course_id;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
   
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", title=" + title + ", stream=" + stream + ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    public Course() {
    }
    
    public void inputC() throws ParseException {
        Scanner sc = new Scanner(System.in);        
        boolean check = true;
        while (check = true) {
            System.out.println("\n Please insert the title of the course");
            title = sc.next();            
            System.out.println("\n Plese insert the stream");
            stream = sc.next();            
            System.out.println("\n Please insert the type of course");
            type = sc.next();            
            System.out.println("\n Please insert start date in format yyyy-MM-dd");
            startDate = sc.next(); 
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = formatter.parse(startDate);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
            System.out.println("\n Please insert the end date");
            endDate = sc.next();
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date dateStr = formatter.parse(endDate);
//            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
            System.out.println("\n Would you like to add more Courses? YES:1 NO:2");
            int num = sc.nextInt();
            if (num == 1) {
                check = false;
            } else if (num == 2) {
                break;
            }
        }

        Connection connection = null;
    Statement statement = null;
    try {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        System.out.println("Connection created successfully.");
        statement = connection.createStatement();
        
        String query = "INSERT INTO COURSES(TITLE,STREAM,TYPE,START_DATE,END_DATE) VALUES ('" + title + "', '" + stream + "' , '" + type +"', '" + startDate +"', '" + endDate +"')";
        
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
    
    
}
