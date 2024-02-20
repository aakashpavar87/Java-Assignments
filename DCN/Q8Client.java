import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Q8Client {
    public static void main(String[] args) {
        try{
            DatagramSocket ss = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverport=9876;

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a sentence: ");
            String msg =  scan.nextLine();
            
            byte[] sendData = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverport);
            ss.send(sendPacket);

            byte[] receiveData = new byte[4000];
            DatagramPacket recieverPacket = new DatagramPacket(receiveData, receiveData.length);
            ss.receive(recieverPacket);

            String receivedMsg = new String(recieverPacket.getData(),0,recieverPacket.getLength());
            System.out.println("Toggle case response from server: " + receivedMsg);
            
            ss.close();
            scan.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
