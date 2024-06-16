package com.example.studentdata;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
// List to store the student objects
public class AddData {
    private ArrayList<Student> students = new ArrayList<>();
    public void addStudent(int id, String firstName, String lastName, int mathMark1, int mathMark2, int mathMark3, int englishMark1, int englishMark2, int englishMark3) {
        Student student = new Student(id, firstName, lastName);
        student.mathMarks = new AssignmentMarks("Mathematics-", mathMark1, mathMark2, mathMark3);
        student.englishMarks = new AssignmentMarks("English-", englishMark1, englishMark2, englishMark3);
        students.add(student);
    } 
    // Method to read student data from a file
    public boolean readFile(String filename) {
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(",");
                // Parse into variables
                if (words.length == 9) {
                    int id = Integer.parseInt(words[0]);
                    String firstName = words[1];
                    String lastName = words[2];
                    int mathMark1 = Integer.parseInt(words[3]);
                    int mathMark2 = Integer.parseInt(words[4]);
                    int mathMark3 = Integer.parseInt(words[5]);
                    int englishMark1 = Integer.parseInt(words[6]);
                    int englishMark2 = Integer.parseInt(words[7]);
                    int englishMark3 = Integer.parseInt(words[8]);
                    addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! Coulnt read file");
            return false;
        }
        return true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}