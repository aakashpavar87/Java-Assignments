import java.net.*;

public class Q2Server{
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
               
                int ans = Integer.parseInt(receivedMessage);
                System.out.println("Recieved From Client :"+receivedMessage);
                String msg1=Integer.toString( ans*ans*ans);

               
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
