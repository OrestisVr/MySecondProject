package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static models.DatabaseClass.DB_URL;
import static models.DatabaseClass.JDBC_DRIVER;
import static models.DatabaseClass.PASSWORD;
import static models.DatabaseClass.USERNAME;

public class Assignment {
    private int asm_id;
    private String Title;
    private String description;    
    private float oralMark;
    private float totalMark;

    public Assignment(int asm_id, String Title, String description, float oralMark, float totalMark) {
        this.asm_id = asm_id;
        this.Title = Title;
        this.description = description;        
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }    
    
    public int getAsm_id() {
        return asm_id;
    }

    public void setAsm_id(int asm_id) {
        this.asm_id = asm_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 
    public float getOralMark() {
        return oralMark;
    }

    public void setOralMark(float oralMark) {
        this.oralMark = oralMark;
    }

    public float getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return "Assignment{" + "asm_id=" + asm_id + ", title=" + Title + ", description=" + description + ", oralMark=" + oralMark + ", totalMark=" + totalMark + '}';
    }

    public Assignment() {
    }
    
    public void inputA() {
        Scanner sc = new Scanner(System.in);        
        boolean check = true;
        while (check = true) {
            System.out.println("\n Please insert the title of the Assignment");
            Title = sc.next();            
            System.out.println("\n Please insert the description of the Course");
            description = sc.next();                      
            System.out.println("\n Please insert the oral mark");
            oralMark = sc.nextFloat();            
            System.out.println("\n Please insert the total mark");
            totalMark = sc.nextFloat();            
            System.out.println("\n Would you like to add more Trainers? YES:1 NO:2");
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
        
        String query = "INSERT INTO ASSIGNMENTS(TITLEE, DESCRIPTION,ORAL_MARK,TOTAL_MARK) VALUES ('" + Title + "', '" + description + "' , '" + oralMark +"', '" + totalMark +"')";
        
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
