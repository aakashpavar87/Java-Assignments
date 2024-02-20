import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Q8Server {
    public static String toToggleCase(String sentence) {
        StringBuilder toggleCase = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (Character.isUpperCase(c)) {
                    toggleCase.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    toggleCase.append(Character.toUpperCase(c));
                } else {
                    toggleCase.append(c);
                }
            }
            toggleCase.append(" ");
        }
        return toggleCase.toString();
    }

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {

            socket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Server started...");

            while (true) {
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("Recieved From Client :" + receivedMessage);

                String msg1 = toToggleCase(receivedMessage);

                byte[] sendData = msg1.getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
