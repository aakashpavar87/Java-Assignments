package MyPackage;


class Person1{
    private String firstName;
    private String lastName;
    private int age;

    public Person1(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void  display (){
        System.out.println("First Name : "+getFirstName());
        System.out.println("Last Name : "+getLastName());
        System.out.println("Age : "+getAge());
    }
}

class Employee1 extends Person1{
    private int empId;
    private String designation;
    private double salary;

    public Employee1(String firstName, String lastName, int age, int empId, String designation, double salary) {
        super(firstName, lastName, age);
        this.empId = empId;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public void  display (){
        System.out.println("First Name : "+getFirstName());
        System.out.println("Last Name : "+getLastName());
        System.out.println("Age : "+getAge());
        System.out.println("Employee Id : "+getEmpId());
        System.out.println("Employee designation : " + getDesignation());
        System.out.println("Employee salary : "+ getSalary());
    }
}

class Student1 extends Person1{
    private int rollNo;
    private String address;
    private double percentage;

    public Student1(String firstName, String lastName, int age, int rollNo, String address, double percentage) {
        super(firstName, lastName, age);
        this.rollNo = rollNo;
        this.address = address;
        this.percentage = percentage;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getAddress() {
        return address;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public void  display (){
        System.out.println("First Name : "+getFirstName());
        System.out.println("Last Name : "+getLastName());
        System.out.println("Age : "+getAge());
        System.out.println("Student Roll No : "+getRollNo());
        System.out.println("Student Address : "+getAddress());
        System.out.println("Student Age : " + getAge());
    }
}
public class Question2 {
    public static void main(String[] args) {
        Student1 s1 = new Student1("Aakash","Pavar",19,3057,"Ahmedabad",81.4);
        Employee1 e1 = new Employee1("Bhavesh","Pandey",21,3001,"ADMIN",91.45);

        try {
            if(s1.getAge()>=1){
                s1.display();
            }
            if (e1.getAge()>=1) {
                e1.display();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}