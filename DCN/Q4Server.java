
import java.io.*;
import java.net.*;
import java.util.*;

public class Q4Server {
    public static List<Integer> calculateQuartiles(List<Integer> data) {
        Collections.sort(data);
        int n = data.size();
        int q1Index = n / 4;
        int q2Index = n / 2;
        int q3Index = (3 * n) / 4;

        int q1 = data.get(q1Index);
        int q2 = data.get(q2Index);
        int q3 = data.get(q3Index);

        List<Integer> quartiles = new ArrayList<>();
        quartiles.add(q1);
        quartiles.add(q2);
        quartiles.add(q3);
        return quartiles;
    }

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9999);
            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String inputData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received data from client: " + inputData);

                String[] numbersStr = inputData.split(",");
                List<Integer> numbers = new ArrayList<>();
                for (String numStr : numbersStr) {
                    numbers.add(Integer.parseInt(numStr));
                }

                List<Integer> quartiles = calculateQuartiles(numbers);
                String quartilesStr = String.join(",", quartiles.stream().map(Object::toString).toArray(String[]::new));

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendData = quartilesStr.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
