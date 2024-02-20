
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Q2Client {
    public static void main(String[] args) {
        try{
            DatagramSocket ss = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverport=9876;

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter The Number : ");
            String msg =  scan.nextLine();
            
            byte[] sendData = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverport);
            ss.send(sendPacket);

            byte[] receiveData = new byte[4000];
            DatagramPacket recieverPacket = new DatagramPacket(receiveData, receiveData.length);
            ss.receive(recieverPacket);

            String receivedMsg = new String(recieverPacket.getData(),0,recieverPacket.getLength());
            // String receivedMsg = new String(receiveData, 0, receiveData.length);
            System.out.println("Server Says Cube of " + msg + " is " + receivedMsg);
            
            ss.close();
            scan.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
