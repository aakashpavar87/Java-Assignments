
import java.io.*;
import java.net.*;


public class Q5Client {
    public static void main(String[] args) throws SocketException {

        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress ina = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Options:");
                System.out.println("a. Celsius to Fahrenheit");
                System.out.println("b. Fahrenheit to Celsius");
                System.out.println("c. Exit");
                System.out.print("Enter your choice: ");
                
                String option = userInput.readLine();

                if (option.equals("c")) {
                    break;
                }
                
                System.out.print("Enter temperature: ");
                double temperature = Double.parseDouble(userInput.readLine());

                String inputData = option + ":" + temperature;
                sendData = inputData.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ina, 9999);
                ds.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                ds.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Converted temperature: " + response);
            }
            ds.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
