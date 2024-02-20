import java.net.*;
import java.io.*;

/**
 * Q1
 */
public class Q1Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the Number :");
        String str = br.readLine();
        dout.writeUTF(str);
        dout.flush();
        String str2 = din.readUTF();
        System.out.println("Server says Square of : " + str+" is "+str2);

        dout.close();
        s.close();
    }
}