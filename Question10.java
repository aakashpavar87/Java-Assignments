import java.util.*;
public class Question10 {
    public static void main(String[] args) {
        System.out.println("\\t\\tName : Aakash Pavar Roll No: 3057");
        StringBuffer sb = new StringBuffer("Hello World,");

        System.out.println("Appended Text to Original String : "+ sb.append("Welcome to JAVA")); 
        System.out.println("Inserted Text at 12th Position in Original String : "+ sb.insert(12," From ")); 
        System.out.println("Replaced 12th index word : " + sb.replace(6, 12, "Universe"));
        sb.setCharAt(0, 'h');
        System.out.println("Setted char at 0th pos : " + sb);
        sb.delete(2, 5);
        System.out.println("Deleted char from 2nd pos to 4th pos: " + sb);
        sb.deleteCharAt(10);
        System.out.println("Deleted char from 10th pos: " + sb);
        sb.reverse();
        System.out.println("Reversed String : " + sb);
        String result = sb.toString();
        System.out.println("Modified String : " + result);
        int len = result.length();
        System.out.println("Length of String : "+len);
        int capacity = sb.capacity();
        System.out.println("Capacity of String : "+capacity);    
    }
}
