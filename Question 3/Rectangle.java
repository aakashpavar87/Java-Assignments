package MyPackage;
import java.util.Scanner;
public class Rectangle {
    public float width;
    public float length;
    public Scanner sc = new Scanner(System.in);

    public Rectangle() {// Default Constructor
        width = length = 0;
    }

    public Rectangle(float w, float l) {
        if (w < 0 || l < 0) {
            throw new ArithmeticException();
        }else{

            width = w;
            length = l;
        }
    }

    public Rectangle(float l) {
        if (l < 0) {
            throw new ArithmeticException();
        }else{
            width = length = l;
        }
    }

    public Rectangle(Rectangle r) {
        if (r.width < 0 || r.length < 0) {
            throw new ArithmeticException();
        }else{
            this.width = r.width;
            this.length = r.length;
        }
    }

    public void set_data() {
        System.out.print("Enter Width of Rectangle : ");
        width = sc.nextFloat();
        System.out.print("Enter Length of Rectangle : ");
        length = sc.nextFloat();
    }
    public float get_width() {
        return width;
    }
    public float get_length() {
        return length;
    }
    public String toString() {
        return "Width of Rectangle : " + width + '\'' + "Length of Rectangle : " + length + '\'';
    }

    public void area() {
        System.out.println("Area of Rectangle is : " + (width * length));
    }

    public void perimeter() {
        System.out.println("Perimeter of Rectangle is : " + (2 * (width + length)));
    }
}
