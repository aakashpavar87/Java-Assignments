import java.io.*;
import java.net.*;

public class Q7Client {
    public static void main(String[] args) {
        try {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a sentence: ");
            String sentence = userInput.readLine();

            Socket socket = new Socket("localhost", 9999);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(sentence);

            String camelCase = in.readLine();
            System.out.println("Camel case response from server: " + camelCase);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
