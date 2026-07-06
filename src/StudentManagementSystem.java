package MyProjectsWhileLearningJava;

import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    public Student(int rollNo, String name, int age, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }
     
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void displayStudent() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            student.displayStudent();
            System.out.println("-------------------");
        }
    }

    public Student searchStudent(int rollNo) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(int rollNo, String newName, int newAge, String newCourse) {
        Student student = searchStudent(rollNo);
        if (student != null){
            student.setName(newName);
            student.setAge(newAge);
            student.setCourse(newCourse);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int rollNo) {
        Student student = searchStudent(rollNo);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

}

public class StudentManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while(true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1 : {
                    System.out.println("Enter Student Details:");

                    System.out.println("Roll No : ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Name : ");
                    String name = sc.nextLine();

                    System.out.println("Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Course : ");
                    String course = sc.nextLine();

                    Student s = new Student(rollNo, name, age, course);

                    manager.addStudent(s);

                    System.out.println("Student added successfully.");
                    break;
                }

                case 2 : {
                    manager.viewAllStudents();
                    break;
                } 

                case 3 : {
                    System.out.println("Enter Roll No to search :");
                    int searchRollNo = sc.nextInt();
                    
                    Student found = manager.searchStudent(searchRollNo);

                    if (found != null) {
                        found.displayStudent();
                    } else {
                        System.out.println("Record does not exist.");
                    }

                    break;
                }

                case 4 : {
                    System.out.println("Enter Updated Student Details:");

                    System.out.println("Roll No : ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("New Name : ");
                    String newName = sc.nextLine();

                    System.out.println("New Age : ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.println("New Course : ");
                    String newCourse = sc.nextLine();

                    boolean updated = manager.updateStudent(rollNo, newName, newAge, newCourse);
                    
                    if (updated) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");   
                    }

                    break;
                }

                case 5 : {
                    System.out.println("Enter roll no to delete deatils: ");
                    int rollNo = sc.nextInt();

                    boolean deleted = manager.deleteStudent(rollNo);

                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                }

                case 6 : {
                    System.out.println("Exiting the program...");
                    sc.close();
                    return;
                }

                default : {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }
}
