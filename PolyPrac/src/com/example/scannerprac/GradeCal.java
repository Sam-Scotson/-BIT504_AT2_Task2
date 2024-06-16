package com.example.scannerprac;
import java.util.Scanner;

public class GradeCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int marks;

        System.out.println("Enter your marks: ");
        marks = scanner.nextInt();
        scanner.close();
        if (marks < 0 || marks > 100) {
            System.out.println("You have entered marks out of the range of [0 to 100]. Please enter marks within this range to calculate your grade!");
            return;
        }

        String grade;
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 80) {
            grade = "B";
        } else if (marks >= 70) {
            grade = "C";
        } else if (marks >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Your grade is: " + grade);
    }
}