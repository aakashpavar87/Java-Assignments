class Person {
    protected String name;
    protected int age;

    public Person(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Enter Valid age.");
            return;
        }
    }

    public void introduce() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}

class Student extends Person {
    protected int studentID;

    public Student(String name,int studentID) {
        super(name);
        this.studentID = studentID;
    }
    public void setStudentId(int sId) {
        studentID = sId;
    }

    public int getStudentId() {
        return studentID;
    }

    public void introduce() {
        System.out.println("Introducing Student.");
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Student ID : " + getStudentId());
    }

    public void study() {
        System.out.println("Roll No : " + getStudentId() + " is Studying.");
    }
}

class Teacher extends Person {
    protected String subject;

    public Teacher(String name,String subject) {
        super(name);
        this.subject = subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void introduce() {
        System.out.println("Introducing Teacher");
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Subject Teaching : " + subject);
    }

    public void teach() {
        System.out.println("Mr.|Mrs. "+name + " is teaching "+ getSubject());
    }
}

// class SchoolSystem{
    public class Question4 {
        public static void main(String[] args) {
            Student s1 = new Student("Aakash",000);
            Teacher t1 = new Teacher("Aakash Sir","Java");
            //Setting Details of Student
            s1.setAge(18);
            s1.setStudentId(2057);
            //Setting Details of Teacher
            t1.setAge(49);
            t1.setSubject("Web Technology");
            //Introduction
            s1.introduce();
            t1.introduce();
            //Special Methods
            s1.study();
            t1.teach();
        }
    }
// }