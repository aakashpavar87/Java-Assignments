class Person{
    protected String name;
    protected int age;
    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }else{
            System.out.println("Enter Valid age.");
            return;
        }
    }
    public void introduce() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}
class Student extends Person{
    protected int studentID;
    public void introduce() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Student ID : " + studentID);
    }
    public void study() {
        System.out.println("Roll No : " + studentID + " is Studying.");
    }
} 
public class Question4 {
    public static void main(String[] args) {
        
    }
}
