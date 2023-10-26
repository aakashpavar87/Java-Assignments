package Exec;
import java.util.Scanner;
import shape.*;
//import shape.Cir.Circle;
//import shape.Rectangle;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Geometry of Java");
        System.out.println("You have to create 4 circles & 4 Rectangles !!!");
        Circle[] circles = new Circle[4];
        Rectangle[] rectangles = new Rectangle[4];
        try {
            System.out.println("C. For Creating 4 Circles.");
            System.out.println("R. For Creating 4 Rectangles.");
            System.out.print("Enter your choice : ");
            String choice = sc.next();
            switch (choice) {
                case "C":
                    for (int i = 0; i < circles.length; i++) {
                        System.out.print("Enter Radius No " + (i+1) + " : ");
                        float r = sc.nextFloat();
                        circles[i] = new Circle(r);
                    }
                    for (int i = 0; i < circles.length; i++) {
                        System.out.println("Calculating Area " + (i+1) + ": ");
                        circles[i].area();
                        System.out.println("Calculating Perimeters " + (i+1) + ": ");
                        circles[i].perimeter();
                    }
                    break;
                case "R":
                    for (int i = 0; i < rectangles.length; i++) {
                        System.out.print("Enter Width No " + (i+1) + " : ");
                        float w = sc.nextFloat();
                        System.out.print("Enter Length No " + (i+1) + " : ");
                        float l = sc.nextFloat();
                        rectangles[i] = new Rectangle(w, l);
                    }
                    for (int i = 0; i < rectangles.length; i++) {
                        System.out.println("Calculating Areas of Rectangles " + (i+1) + ": ");
                        rectangles[i].area();
                        System.out.println("Calculating Perimeters of Rectangles  " + (i+1) + ": ");
                        rectangles[i].perimeter();
                    }
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
