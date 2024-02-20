
import java.io.*;
import java.net.*;


public class Q4Client {
    public static void main(String[] args) {
        try {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a set of numeric values separated by comma: ");
            String numbers = userInput.readLine();

            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData = numbers.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9999);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String quartilesStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Quartiles received from server: " + quartilesStr);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

