import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Q3Client {
    public static void main(String[] args) throws Exception {
        Socket ss = new Socket("localhost", 1234);
        PrintWriter out = new PrintWriter(ss.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter a set of numeric values separated by comma: ");
            String msg = scan.nextLine();
            out.println(msg);

            String primeNumbers = in.readLine();
            if (primeNumbers.equals("0")) {
                System.out.println("No prime numbers found in the set.");
            } else {
                System.out.println("Prime numbers from the set: " + primeNumbers);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
            in.close();
            out.close();
            ss.close();

        }
    }
}
