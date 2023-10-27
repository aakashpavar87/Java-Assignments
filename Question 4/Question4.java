package MyPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Shape {
    abstract double area();

    @Override
    public String toString() {
        return "This is a shape.";
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "This is a triangle.";
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "This is a rectangle.";
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "This is a circle.";
    }
}

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base,height,width,length,radius;

        System.out.print("Enter base for Triangle : ");
        base = sc.nextDouble();
        System.out.print("Enter height for Triangle : ");
        height = sc.nextDouble();
        Shape triangle = new Triangle(base, height);

        System.out.print("Enter length for Rectangle : ");
        length = sc.nextDouble();
        System.out.print("Enter width for Rectangle : ");
        width = sc.nextDouble();
        Shape rectangle = new Rectangle(length, width);
        System.out.print("Enter Radius for Circle : ");
        radius = sc.nextDouble();
        Shape circle = new Circle(radius);

        Shape[] shapes = {triangle, rectangle, circle};

        for (Shape shape : shapes) {
            try {
                System.out.println(shape.toString());
                System.out.println("Area: " + shape.area());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}