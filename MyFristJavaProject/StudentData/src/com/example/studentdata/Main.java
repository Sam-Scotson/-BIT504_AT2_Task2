package com.example.studentdata;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static AddData addData = new AddData();
    private static ArrayList<Student> students;
    public static void main(String[] args) {
        if (!addData.readFile("E:\\Java\\Study\\StudentData\\bin\\studentdata.txt")){// change to appropriate studentdata.txt directory location 
            System.out.println("Error! Please double check and update studentdata.txt location for readFile");
            System.exit(1);
        }
        students = addData.getStudents();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayIndividualStudentMarks(scanner);
                    break;
                case 2:
                    displayIndividualStudentGrades(scanner);
                    break;
                case 3:
                    displayAllStudentMarks();
                    break;
                case 4:
                    displayAllStudentGrades();
                    break;
                case 5:
                    addNewStudent(scanner);
                    break;
                case 6:
                    removeStudent(scanner);
                    break;
                case 7:
                    System.out.println("Are you sure? yes/no");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("yes")) {
                        System.out.println("Exiting");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Error! Please Try Again");
            }
        } while (option != 7);;
    }
    // Menu Option list
    private static void displayMenu() {
        System.out.println("1-Individual Student Marks");
        System.out.println("2-Individual Student Grades");
        System.out.println("3-All Student Marks");
        System.out.println("4-All Student Grades");
        System.out.println("5-Add New Student");
        System.out.println("6-Remove Student");
        System.out.println("7-Exit");
        System.out.print("Select an Option: ");
    }

    private static void displayIndividualStudentMarks(Scanner scanner) {//remember to pass the scanner object
        listStudents();
        System.out.print("Enter a StudentID: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println(student.getFullName() + "-" + student.mathMarks.getAverageMark() + "," + student.englishMarks.getAverageMark());
        } else {
            System.out.println("Not found!");
        }
    }

    private static void displayIndividualStudentGrades(Scanner scanner) {
        listStudents();
        System.out.print("Enter a StudentID: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println(student.getFullName() + "-" + student.mathMarks.getAverageGrade() + "," + student.englishMarks.getAverageGrade());
        } else {
            System.out.println("Not found!");
        }
    }

    private static void displayAllStudentMarks() {
        System.out.println("Student Marks:");
        for (Student student : students) {
            System.out.println(student.getFullName() + "-");
            System.out.println("Math Marks- " + student.mathMarks.assignment1 + "," + student.mathMarks.assignment2 + "," + student.mathMarks.assignment3);
            System.out.println("Average Math Mark- " + student.mathMarks.getAverageMark());
            System.out.println("English Marks- " + student.englishMarks.assignment1 + "," + student.englishMarks.assignment2 + "," + student.englishMarks.assignment3);
            System.out.println("Average English Mark- " + student.englishMarks.getAverageMark());
            System.out.println("-**************************-");
        }
    }

    private static void displayAllStudentGrades() {
        System.out.println("Student Grades:");
        for (Student student : students) {
            System.out.println(student.getFullName() + "-");
            System.out.println("Math Grades- " + student.mathMarks.getAssignment1Grade() + "," + student.mathMarks.getAssignment2Grade() + "," + student.mathMarks.getAssignment3Grade());
            System.out.println("Average Math Grade= " + student.mathMarks.getAverageGrade());
            System.out.println("English Grades- " + student.englishMarks.getAssignment1Grade() + "," + student.englishMarks.getAssignment2Grade() + "," + student.englishMarks.getAssignment3Grade());
            System.out.println("Average English Grade- " + student.englishMarks.getAverageGrade());
            System.out.println("-**************************-");
        }
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter a StudentID: ");
        int id = scanner.nextInt();
        System.out.print("Enter a first name: ");
        String firstName = scanner.next();
        System.out.print("Enter a last name: ");
        String lastName = scanner.next();
        System.out.print("Enter Mathematics Marks(3 numbers with spaces): ");
        int mathMark1 = scanner.nextInt();
        int mathMark2 = scanner.nextInt();
        int mathMark3 = scanner.nextInt();
        System.out.print("Enter English Marks (3 numbers with spaces): ");
        int englishMark1 = scanner.nextInt();
        int englishMark2 = scanner.nextInt();
        int englishMark3 = scanner.nextInt();
        addData.addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
        students = addData.getStudents();
        System.out.println("Added Successfully!");
    }

    private static void removeStudent(Scanner scanner) {
        listStudents();
        System.out.print("Enter the ID of a student to remove them: ");
        int id = scanner.nextInt();
        students.removeIf(student -> student.id == id);
        System.out.println("Removed successfully!");
    }

    private static void listStudents() {
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.id + "-" + student.getFullName());
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }
}