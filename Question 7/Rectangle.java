package shape;
import geometry.Figure;

public class Rectangle extends Figure{
    public float width;
    public float length;
    public Rectangle(float w,float h) {
        if(w < 0 || h < 0) {
            throw new ArithmeticException();
        }else{
            width = w;
            length = h;
        }
    }
    public void area() {
        System.out.println("Area of Rectangle is : " + (width * length));
    }
    public void perimeter() {
        System.out.println("Perimeter of Rectangle is : " + (2 * (width + length)));
    }
}
