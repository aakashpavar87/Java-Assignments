import MyPackage.Rectangle;
import java.util.Scanner;
public class Main extends Rectangle{
    public Main() {
        super();
    }
    public Main(float w,float l) {
        super(w,l);
    }
    public Main(float l) {
        super(l);
    }
    public Main(Main r) {
        super(r);
    }
    public String toString() {
        return "Width That Entered in Rectangle : " + width + '\n' + "Length That Entered in Rectangle : " + length + '\n';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main r1 = new Main();//Default Constructor
        r1.set_data();

        System.out.print("Enter length for Creating Square!!! : ");
        float length = sc.nextFloat();
        Main r2 = new Main(length);
        
        System.out.print("Enter Width & length for Creating Rectangle!!! : ");
        float l = sc.nextFloat();
        float w = sc.nextFloat();
        Main r3 = new Main(l, w);

        System.out.println("Copy Constructor Calling !!!!!");
        Main r4 = new Main(r3);

        System.out.println("---------------------------------");
        System.out.println("Default Constructor Applying !!! ");
        System.out.println(r1.toString());
        r1.area();
        r1.perimeter();
        
        System.out.println("---------------------------------");
        System.out.println("Single Parameter Constructor Applying !!! ");
        System.out.println(r2.toString());
        r2.area();
        r2.perimeter();
        
        System.out.println("---------------------------------");
        System.out.println("Parameterized Constructor Applying !!! ");
        System.out.println(r3.toString());
        r3.area();
        r3.perimeter();
        
        System.out.println("---------------------------------");
        System.out.println("Copied Constructor Applying !!! ");
        System.out.println(r4.toString());
        r4.area();
        r4.perimeter();
        System.out.println("---------------------------------");
    }
}
