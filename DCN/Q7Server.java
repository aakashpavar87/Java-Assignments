import java.io.*;
import java.net.*;

public class Q7Server {
    public static String toCamelCase(String sentence) {
        StringBuilder camelCase = new StringBuilder();
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // if (i == 0) {
            //     camelCase.append(words[i].toLowerCase());
            // } else {
            //     camelCase.append(words[i].substring(0, 1).toUpperCase())
            //             .append(words[i].substring(1).toLowerCase()).append(" ");
            // }
            camelCase.append(words[i].substring(0, 1).toUpperCase())
                    .append(words[i].substring(1).toLowerCase()).append(" ");
        }
        return camelCase.toString();
    }

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server listening on port 9999...");
        try {

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String sentence = in.readLine();
                System.out.println("Received sentence from client: " + sentence);

                String camelCase = toCamelCase(sentence);
                out.println(camelCase);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                serverSocket.close();;
            }
        }
        
    }
}
