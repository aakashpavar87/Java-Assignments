import java.util.*;

public class Question9 {
    public static void prime(int n, int x) {
        if (n == 1 || n == 0) {
            System.out.println(n + " is not a prime number.");
        } else if (x == n) {
            System.out.println(n + " is prime");
        } else if (n % x == 0) {
            System.out.println(n + " is not prime number.");
        } else {
            prime(n, x + 1);
        }
    }

    public static void main(String args[]) {
        System.out.println("\t\tName : Aakash Pavar Roll No: 3057");
        int num, i = 2;
        System.out.print("Enter any Number to check : ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        prime(num, i);
        sc.close();
    }
}