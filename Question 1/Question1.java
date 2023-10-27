package MyPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Person{
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int age;
    public Person(String firstName, String middleName, String lastName, String address, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person implements Comparable<Student>{
    private int rollNo;
    private String division;
    private String dateOfBirth;

    public Student(String firstName, String middleName, String lastName, String address, int age, int rollNo, String division, String dateOfBirth) {
        super(firstName, middleName, lastName, address, age);
        this.rollNo = rollNo;
        this.division = division;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", division='" + division + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student otherStudent) {
        return Integer.compare(this.rollNo, otherStudent.rollNo);
    }
}

class Employee extends Person implements Comparable<Employee>{
    @Override
    public int compareTo(Employee otherEmployee) {
        return Double.compare(this.netSalary, otherEmployee.netSalary);
    }
    private int empId;
    private double da;
    private double hra;
    private double netSalary;

    public Employee(String firstName, String middleName, String lastName, String address, int age, int empId, double da, double hra) {
        super(firstName, middleName, lastName, address, age);
        this.empId = empId;
        this.da = da;
        this.hra = hra;
        this.netSalary = calculateNetSalary();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", da=" + da +
                ", hra=" + hra +
                ", netSalary=" + netSalary +
                '}';
    }
    private double calculateNetSalary() {
        return da - hra;
    }
}

public class Question1 {

    private static Student readStudentData(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student " + i + " information:");

        // Read student data
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Middle Name: ");
        String middleName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // Consume the newline
        System.out.print("Division: ");
        String division = sc.nextLine();
        System.out.print("Date of Birth: ");
        String dateOfBirth = sc.nextLine();

        return new Student(firstName, middleName, lastName, address, age, rollNo, division, dateOfBirth);
    }

    private static Employee readEmployeeData(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee " + i + " information:");

        // Read employee data
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        System.out.print("Dearness Allowance (DA): ");
        double da = scanner.nextDouble();
        System.out.print("House Rent Allowance (HRA): ");
        double hra = scanner.nextDouble();

        return new Employee(firstName, middleName, lastName, address, age, empId, da, hra);
    }


    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Employee> employees = new ArrayList();

        try {
            // Add 5 Student objects to the list
            for (int i = 1; i <= 2; i++) {
                Student student = readStudentData(i);
                students.add(student);
            }

            // Sort the Student objects by rollNo
            Collections.sort(students);

            // Add 5 Employee objects to the list
            for (int i = 1; i <= 2; i++) {
                Employee employee = readEmployeeData(i);
                employees.add(employee);
            }

            // Sort the Employee objects by netSalary
            Collections.sort(employees);

            // Display sorted student information
            System.out.println("Sorted Student Information:");
            for (Student student : students) {
                System.out.println(student);
            }

            // Display sorted employee information
            System.out.println("Sorted Employee Information:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


    }
}