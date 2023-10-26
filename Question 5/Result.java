import mypackage.Classify;
import mypackage.another.Exam;
import java.util.Scanner;

public class Result implements Exam, Classify {
    public String student_name;
    public int roll;
    public float[] subject_marks = new float[5];
    public float Average_Marks;
    public String is_pass;

    public boolean Pass(float mark) {
        if (mark > 33) {
            return true;
        } else {
            return false;
        }
    }

    public float calc_average() {
        float sum = 0;
        int count = 0;
        for (float subject : subject_marks) {
            sum += subject;
            count++;
        }
        Average_Marks = sum / count;
        return Average_Marks;
    }

    public String Division(float average) {
        if (average >= 60) {
            return "First";
        } else if (average < 60 && average >= 50) {
            return "Second";
        } else if (average < 50) {
            return "No Division";
        } else {
            return "Fail";
        }
    }

    public void set_data(String name, int rno) {
        student_name = name;
        roll = rno;
    }

    public void get_data() {
        System.out.println("Student Name : " + student_name);
        System.out.println("Student Roll No : " + roll);
    }

    public void collect_marks() {
        // float[] st_marks = new float[5];
        int i = 0;
        System.out.println("Enter Marks of Java , CG , Clip , TC and SE : ");
        for (float mark : subject_marks) {
            Scanner sc = new Scanner(System.in);
            mark = sc.nextFloat();
            if (mark < 0 || mark > 100) {
                throw new ArithmeticException("Please Enter Appropriate Marks !!!");
            }
            subject_marks[i] = mark;
            i++;
        }
    }

    public static void main(String[] args) {
        try {

            System.out.println("How many students do you want to add : ");
            Scanner sc = new Scanner(System.in);
            int student_num = sc.nextInt();
            Result[] students = new Result[student_num];
            for (int i = 0; i < student_num; i++) {
                students[i] = new Result();
                System.out.println("Enter Details of Student Name and Roll : ");
                String name = sc.next();
                int rno = sc.nextInt();
                students[i].set_data(name, rno);
                students[i].collect_marks();

            }
            System.out.println("Printing details of Students !!!!");
            System.out.println("------------------------------");
            for (Result student : students) {
                student.get_data();
                System.out.println("Here are marks of each subject : ");
                for (int i = 0; i < student.subject_marks.length; i++) {
                    System.out.println("Subject No " + (i + 1) + " : " + student.subject_marks[i]);
                }
                System.out.println("------------------------------");
                for (int i = 0; i < student.subject_marks.length; i++) {
                    if (student.Pass(student.subject_marks[i])) {
                        System.out.println("Yes, You are passed in exam number : " + (i + 1));
                    } else {
                        System.out.println("You are failed in exam number : " + (i + 1));
                    }
                }
                System.out.println("------------------------------");
                float avg = student.calc_average();
                System.out.println("Average of Marks : " + avg);
                System.out.println("------------------------------");
                System.out.println("Your division is : " + student.Division(avg));
                System.out.println("------------------------------");
            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }

}
