import java.net.*;

public class Q5Server {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9999);
            byte[] receiveData = new byte[1024];
            System.out.println("Server listening on port 9999...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received Data From Client : " + msg);

                String[] inputParts = msg.split(":");
                String option = inputParts[0];
                double temperature = Double.parseDouble(inputParts[1]);
                double convertedTemperature = 0;

                switch (option) {
                    case "a":
                        convertedTemperature = celsiusToFahrenheit(temperature);
                        break;
                    case "b":
                        convertedTemperature = fahrenheitToCelsius(temperature);
                        break;
                }
                String response = Double.toString(convertedTemperature);
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                }
        

        }
        catch(Exception e)
    {
        e.printStackTrace();
    }
}
}
