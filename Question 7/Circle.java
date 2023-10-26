package shape;
import geometry.Figure;


public class Circle extends Figure{
    public float radius;
    public Circle(float r) {
        if(r < 0) {
            throw new ArithmeticException();
        }else {
            radius = r;
        }
    }
    public void area() {
        System.out.println("Area of Circle is : " + (PI * radius * radius));
    }
    public void perimeter() {
        System.out.println("Perimeter of Circle is : " + (PI * radius * 2));
    }
}
