import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Q3Server {
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static String getPrimeNumbers(String data) {
        String[] numbersStr = data.split(",");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String numStr : numbersStr) {
            numbers.add(Integer.parseInt(numStr));
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int num : numbers) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        if (primes.isEmpty()) {
            return "0";
        } else {
            StringBuilder result = new StringBuilder();
            for (int prime : primes) {
                result.append(prime).append(",");
            }
            return result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        Socket cs = ss.accept();
        System.out.println("client is connected");
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        Scanner scan = new Scanner(System.in);
        try {
            String msg = in.readLine();
            System.out.println("Received data from client: " + msg);

            String primeNumbers = getPrimeNumbers(msg);
            out.println(primeNumbers);

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
