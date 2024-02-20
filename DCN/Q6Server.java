import java.io.*;
import java.net.*;
// import java.math.*;

public class Q6Server {
    public static double area(double s)
    {
        return s*s;
    }
    public static double areas(double r)
    {
        return Math.PI*r*r;
    }
    public static double area(double w,double l)
    {
        return w*l;
    }
    public static double area(double p,double b,double h)
    {
        return p*b*h;
    }
   public static void main(String[] args) {
    try{
        ServerSocket ss = new ServerSocket(1234);
        Socket cs = ss.accept();
        BufferedReader in = new BufferedReader( new InputStreamReader(cs.getInputStream()));
        PrintWriter out = new PrintWriter(cs.getOutputStream(),true);
        System.out.println("Server is Listening....");
        while (true) {
            
                String receiveData = in.readLine();
                System.out.println("Client Says :"+receiveData);
                String[] data = receiveData.split(":");
                if (receiveData.equals("e")) {
                    break;
                }
                if (data[0].equals("a")) {
                    double r= Double.parseDouble(data[1]);
                    double response = areas(r);
                    String sendData = "Server Says Area of Circle is :"+response;
                    out.println(sendData);
                }
                else if (data[0].equals("b")) {
                    double l= Double.parseDouble(data[1]);
                    double w= Double.parseDouble(data[2]);
                    double response = area(l,w);
                    String sendData = "Server Says Area of Rectangle is :"+response;
                    out.println(sendData);

                }
                else if (data[0].equals("c")) {
                    double r= Double.parseDouble(data[1]);
                    double response = area(r);
                    String sendData = "Server Says Area of Square is :"+response;
                    out.println(sendData);
                }
                else if (data[0].equals("d")) {
                    double b= Double.parseDouble(data[1]);
                    double h= Double.parseDouble(data[2]);
                    double response = area(0.5,b,h);
                    String sendData = "Server Says Area of Rectangle is :"+response;
                    out.println(sendData);
                }
                
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
   }
}
