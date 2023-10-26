import MyPackage.Exam;
import MyPackage.Classify;

public class Result implements Exam,Classify{
    public String student_name;
    public int roll;
    static class Subjects{

        public float Java;
        public float Cg;
        public float Tc;
        public float Clip;
        public float Se;
    }
    public Result(float marks[]) {
        for (float subject : Subjects) {
            int i = 0;
            subject = marks[i];
            i++;
        }
    }
    public float Average_Marks;
    public boolean Pass(float marks){
        try {
            if(marks < 0) {
                throw new Exception();
            }
            if(marks > 100) {
                throw new Exception();
            }

            if (marks > 50) {
                return true;
            } else {
                return false;
            }
        }
        catch(Exception e) {
            System.out.println("You can't Enter Appropriate Marks !!!! ");
        }
    }
    public float calc_average() {
        float sum = 0;
        int count = 0;
        for(float subject : Subjects) {
            sum += subject;
            count ++;
        }
        Average_Marks = sum / count;
        return Average_Marks;
    }
    public String Division(float average) {
        if(average >= 60) {
            return "First";
        } else if (average < 60 && average >= 50) {     
            return "Second";
        } else if (average < 50) {
            return "No Division";
        }
    }
    public static void main(String[] args){
        
    }

}
