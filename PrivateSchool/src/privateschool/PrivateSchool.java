package privateschool;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import models.Assignment;
import models.Course;
import models.DatabaseClass;
import models.Student;
import models.Trainer;

public class PrivateSchool {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        String option = "";

        do {
            System.out.println("1.Select all Students");
            System.out.println("2.Select all Trainers");
            System.out.println("3.Select all Assignments");
            System.out.println("4.Select all Courses");
            System.out.println("5.Select all Students per course");
            System.out.println("6.Select all Trainers per course");
            System.out.println("7.Select all Assignments per course");
            System.out.println("8.Select all Assignments per course per student");
            System.out.println("9.A list of students that belong to more than one courses");
            System.out.println("10.Insert Students");
            System.out.println("11.Insert Trainers");
            System.out.println("12.Insert Assignments");
            System.out.println("13.Insert Courses");
            System.out.println("14.Insert Students per course");
            System.out.println("15.Insert Trainers per course");
            System.out.println("16.Insert assignments per student per course");
            System.out.println("q.To quit");

            Scanner scanner = new Scanner(System.in);
            option = scanner.next();

            DatabaseClass databaseClasses = new DatabaseClass();

            switch (option) {
                case "1":
                    List<Student> studentList = databaseClasses.getAllStudents();
                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    break;
                case "2":
                    List<Trainer> trainerList = databaseClasses.getAllTrainers();
                    for (Trainer trainer : trainerList) {
                        System.out.println(trainer);
                    }
                    break;
                case "3":
                    List<Assignment> assignmentList = databaseClasses.getAllAssignments();
                    for (Assignment assignment : assignmentList) {
                        System.out.println(assignment);
                    }
                    break;
                case "4":
                    List<Course> courseList = databaseClasses.getAllCourses();
                    for (Course course : courseList) {
                        System.out.println(course);
                    }
                    break;
                case "5":
                    databaseClasses.getStudentspercourse();
                    break;
                case "6":
                    databaseClasses.getTrainerspercourse();
                    break;
                case "7":
                    databaseClasses.getAssignmentspercourse();
                    break;
                case "8":
                    databaseClasses.getAssignmentsPerCoursePerStudent();
                    break;
                case "9":
                    databaseClasses.getStudentsMoreThanOneCourse();
                    break;
                case "10":
                    Student student = new Student();
                    student.inputS();
                case "11":
                    Trainer trainer = new Trainer();
                    trainer.inputT();
                case "12":
                    Assignment assignment = new Assignment();
                    assignment.inputA();
                case "13":
                    Course course = new Course();
                    course.inputC();
                case "14":
                    List<Student> students = databaseClasses.getAllStudents();

                    boolean studentExists = false;
                    int studentId = -1;

                    do {
                        System.out.println("Select the id of the student you wish to enter: ");

                        students.forEach((Student) -> {
                            System.out.println("Id: "
                                    + Student.getStu_id() + ", student: " + Student.getStu_id() + " " + Student.getFirstName() + " " + Student.getLastName());
                        });

                        studentId = scanner.nextInt();

                        for (Student s : students) {
                            if (s.getStu_id() == studentId) {
                                studentExists = true;
                                break;
                            }
                        }
                        if (!studentExists) {
                            System.out.println("This student does not exist. Select another id.");
                        }
                    } while (!studentExists);

                    List<Course> courses = databaseClasses.getAllCourses();

                    boolean courseExists = false;
                    int courseId = -1;

                    do {
                        System.out.println("Select the id of the course you wish to enter: ");

                        courses.forEach((Course) -> {
                            System.out.println("Id: "
                                    + Course.getCourse_id() + ", course: " + Course.getCourse_id() + " " + Course.getTitle() + " " + Course.getStream() + " " + Course.getType());
                        });

                        courseId = scanner.nextInt();

                        for (Course c : courses) {
                            if (c.getCourse_id() == courseId) {
                                studentExists = true;
                                break;
                            }
                        }
                        if (!courseExists) {
                            System.out.println("This course does not exist. Select another id.");
                        }
                    } while (!courseExists);

                    databaseClasses.insertCourseToStudent(studentId, courseId);

                default:
                    break;

                case "15":
                    List<Trainer> trainers = databaseClasses.getAllTrainers();

                    boolean trainerExists = false;
                    int trainerId = -1;

                    do {
                        System.out.println("Select the id of the trainer you wish to enter: ");

                        trainers.forEach((Trainer) -> {
                            System.out.println("Id: "
                                    + Trainer.getTr_id() + ", trainer: " + Trainer.getFirstName() + " " + Trainer.getLastName());
                        });

                        trainerId = scanner.nextInt();

                        for (Trainer t : trainers) {
                            if (t.getTr_id() == trainerId) {
                                trainerExists = true;
                                break;
                            }
                        }
                        if (!trainerExists) {
                            System.out.println("This trainer does not exist. Select another id.");
                        }
                    } while (!trainerExists);

                    List<Course> Courses = databaseClasses.getAllCourses();

                    boolean CourseExists = false;
                    int CourseId = -1;

                    do {
                        System.out.println("Select the id of the course you wish to enter: ");

                        Courses.forEach((Course) -> {
                            System.out.println("Id: "
                                    + Course.getCourse_id() + ", course: " + Course.getCourse_id() + " " + Course.getTitle() + " " + Course.getStream() + " " + Course.getType());
                        });

                        courseId = scanner.nextInt();

                        for (Course c : Courses) {
                            if (c.getCourse_id() == courseId) {
                                studentExists = true;
                                break;
                            }
                        }
                        if (!CourseExists) {
                            System.out.println("This course does not exist. Select another id.");
                        }
                    } while (!CourseExists);

                    databaseClasses.insertCourseToTrainer(trainerId, CourseId);
            }

        } while (!option.equals("q"));
    }

}
