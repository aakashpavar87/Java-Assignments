import java.net.*;
import java.io.*;

public class Q1Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = din.readUTF();
        System.out.println("client says: " + str);
        int ans = Integer.parseInt(str);
        String str2 = Integer.toString(ans*ans);
        dout.writeUTF(str2);
        dout.flush();
      
        din.close();
        s.close();
        ss.close();
    }
}
