package models;

import models.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseClass {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/private_school?serverTimezone=UTC";

    public static final String USERNAME = "root";
    public static final String PASSWORD = "2851993Or";

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM STUDENTS";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("stu_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_Name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                Float tuitionFees = resultSet.getFloat("tuition_fees");

                Student student = new Student(studentId, firstName, lastName, dateOfBirth, tuitionFees);
                students.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (preparedStatement != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public List<Trainer> getAllTrainers() throws ClassNotFoundException, SQLException {
        List<Trainer> trainers = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM TRAINERS";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int trainerId = resultSet.getInt("tr_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String subject = resultSet.getString("subject");

                Trainer trainer = new Trainer(trainerId, firstName, lastName, subject);
                trainers.add(trainer);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

        return trainers;
    }

    public List<Assignment> getAllAssignments() throws ClassNotFoundException, SQLException {
        List<Assignment> assignments = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM ASSIGNMENTS";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int assignmentId = resultSet.getInt("asm_id");
                String Title = resultSet.getString("titlee");
                String description = resultSet.getString("description");
                Float oralMark = resultSet.getFloat("oral_mark");
                Float totalMark = resultSet.getFloat("total_mark");

                Assignment assignment = new Assignment(assignmentId, Title, description, oralMark, totalMark);
                assignments.add(assignment);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

        return assignments;
    }

    public List<Course> getAllCourses() throws ClassNotFoundException, SQLException {
        List<Course> courses = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM COURSES";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                String title = resultSet.getString("title");
                String stream = resultSet.getString("stream");
                String type = resultSet.getString("type");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");

                Course course = new Course(courseId, title, stream, type, startDate, endDate);
                courses.add(course);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

        return courses;
    }

    public void getStudentspercourse() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " SELECT S.FIRST_NAME,S.LAST_NAME,C.TITLE\n"
                    + "FROM STUDENTS S\n"
                    + "INNER JOIN STUDENT_COURSE ST\n"
                    + "ON S.STU_ID=ST.STU_ID\n"
                    + "INNER JOIN COURSES C\n"
                    + "ON C.COURSE_ID=ST.COURSE_ID\n"
                    + "ORDER BY ID;";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_Name");
                String title = resultSet.getString("title");

                System.out.println(" First name: " + firstName + ", Last name: " + lastName + ", Title: " + title);
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

    public void getTrainerspercourse() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " SELECT TR.FIRST_NAME,TR.LAST_NAME,C.TITLE,C.STREAM,C.TYPE\n"
                    + "FROM TRAINERS TR\n"
                    + "INNER JOIN TRAINER_COURSE TC\n"
                    + "ON TR.TR_ID=TC.ID\n"
                    + "INNER JOIN COURSES C\n"
                    + "ON C.COURSE_ID=TC.COURSE_ID;";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_Name");
                String title = resultSet.getString("title");

                System.out.println(" First name: " + firstName + ", Last name: " + lastName + ", Title: " + title);
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

    public void getAssignmentspercourse() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " SELECT ASS.TITLEE,ASS.DESCRIPTION,C.TITLE,C.STREAM,C.TYPE\n"
                    + "FROM ASSIGNMENTS ASS\n"
                    + "INNER JOIN ASSIGNMENT_COURSE AC\n"
                    + "ON ASS.ASM_ID=AC.ASM_ID\n"
                    + "INNER JOIN COURSES C\n"
                    + "ON C.COURSE_ID=AC.COURSE_ID\n"
                    + "ORDER BY ID;";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String Title = resultSet.getString("titlee");
                String title = resultSet.getString("title");
                String stream = resultSet.getString("stream");
                String type = resultSet.getString("type");

                System.out.println("course title : " + title + " Assignment Title: " + Title + " stream: " + stream + " Type: " + type);
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

    public void getAssignmentsPerCoursePerStudent() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " SELECT ass.titlee,c.title,c.stream,s.first_name,s.last_name \n"
                    + "FROM ASSIGNMENTS ASS,ASSIGNMENT_COURSE AC,COURSES C,STUDENTS S,STUDENT_COURSE ST\n"
                    + "WHERE ASS.ASM_ID=AC.ASM_ID\n"
                    + "AND C.COURSE_ID=AC.COURSE_ID\n"
                    + "AND S.STU_ID=ST.STU_ID;";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String Title = resultSet.getString("titlee");
                String title = resultSet.getString("title");
                String stream = resultSet.getString("stream");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_Name");

                System.out.println("course title : " + title + " Assignment Title: " + Title + " stream: " + stream + " first name: " + firstName + " last name:  " + lastName);
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

    public List<Student> getStudentsMoreThanOneCourse() throws SQLException {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT s.first_name,s.last_name,count(sc.course_id)as numberofcourse\n"
                    + "FROM students s,student_course sc\n"
                    + "WHERE s.stu_id=sc.id\n"
                    + "GROUP BY sc.stu_id\n"
                    + "HAVING count(sc.course_id)>1; ";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_Name");

                System.out.println("first_name: " + firstName + "last name: " + lastName);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (preparedStatement != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public boolean checkIfStudentNameExists(String firstName, String lastName) {
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

            while (resultSet.next()) {
                String count = resultSet.getString(1);
                String coun = resultSet.getString(2);

                if ((count == firstName && coun==lastName)) {
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

        return studentNameExists;
    }
    
    public boolean checkIfCourseNameExists(String title, String stream) {
        boolean courseNameExists = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " SELECT title,stream FROM STUDENTS WHERE title = ?,stream=? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, stream);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String count = resultSet.getString(1);
                String coun = resultSet.getString(2);

                if ((count == title && coun==stream)) {
                    courseNameExists = true;
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

        return courseNameExists;
    }

    public int insertCourseToStudent(int studentId, int courseId) {
        int rowsAffected = 0;
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            Class.forName(JDBC_DRIVER);

    connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    
    String ifExists="SELECT STU_ID,COURSE_ID FROM STUDENT_COURSE WHERE STUD_ID= ? AND COURSE_ID=?";
    
     preparedStatement = connection.prepareStatement(ifExists);
     preparedStatement.setInt(1,studentId);
     preparedStatement.setInt(2,courseId);
     resultSet = preparedStatement.executeQuery();
     
    if (!resultSet.next()){     
     String query = " INSERT INTO STUDENT_COURSE(STUD_ID, COURSE_ID) VALUES (?,?) ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);

            rowsAffected = preparedStatement.executeUpdate();}

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
         closing(connection,  preparedStatement, resultSet);
        }
        return rowsAffected;
    }
    
    

    private void closing(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
     public int insertCourseToTrainer(int trainerId, int courseId) {
        int rowsAffected = 0;
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            Class.forName(JDBC_DRIVER);

    connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    
    String ifExists="SELECT TR_ID,COURSE_ID FROM TRAINER_COURSE WHERE TR_ID= ? AND COURSE_ID=?";
    
     preparedStatement = connection.prepareStatement(ifExists);
     preparedStatement.setInt(1,trainerId);
     preparedStatement.setInt(2,courseId);
     resultSet = preparedStatement.executeQuery();
     
    if (!resultSet.next()){     
     String query = " INSERT INTO TRAINER_COURSE(TRAINER_ID, COURSE_ID) VALUES (?,?) ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, trainerId);
            preparedStatement.setInt(2, courseId);

            rowsAffected = preparedStatement.executeUpdate();}

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
         closing(connection,  preparedStatement, resultSet);
        }
        return rowsAffected;
    }
    
}
