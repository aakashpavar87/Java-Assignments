package MCA;

import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private int student_id;
    private String student_name;
    private String address;
    protected int[] marks;
    private String grade;

    Student(int student_id, String student_name, String address) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.address = address;
        this.marks = new int[3];
    }

    void calculate_grade() {
        int totalMarks = marks[0] + marks[1] + marks[2];
        int averageMarks = totalMarks / 3;

        if (averageMarks > 90) {
            grade = "A+";
        } else if (averageMarks > 80) {
            grade = "A";
        } else if (averageMarks > 70) {
            grade = "B+";
        } else if (averageMarks > 60) {
            grade = "B";
        } else {
            grade = "C";
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + student_id +
                "\nStudent Name: " + student_name +
                "\nAddress: " + address +
                "\nGrade: " + grade;
    }
}

class Subject extends Student {
    private int subject_id;
    private String subject_name;
    private boolean elective;

    Subject(int student_id, String student_name, String address, int subject_id, String subject_name, boolean elective) {
        super(student_id, student_name, address);
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.elective = elective;
    }

    int getSubject_id() {
        return subject_id;
    }

    void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    String getSubject_name() {
        return subject_name;
    }

    void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    boolean isElective() {
        return elective;
    }

    void setElective(boolean elective) {
        this.elective = elective;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSubject ID: " + subject_id +
                "\nSubject Name: " + subject_name +
                "\nElective: " + elective;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int student_id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String student_name = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Subject ID: ");
        int subject_id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Subject Name: ");
        String subject_name = scanner.nextLine();

        System.out.print("Is Elective (true/false): ");
        boolean elective = scanner.nextBoolean();

        Student student = new Subject(student_id, student_name, address, subject_id, subject_name, elective);

        System.out.print("Enter Marks for 3 Subjects: ");
        for (int i = 0; i < 3; i++) {
            student.marks[i] = scanner.nextInt();
        }

        try {
            student.calculate_grade();
            System.out.println(student.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}