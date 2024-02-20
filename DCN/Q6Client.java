import java.io.*;
import java.net.*;


public class Q6Client {
    public static void main(String[] args) {
        try{
            Socket ss = new Socket("localhost",1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            PrintWriter out = new PrintWriter(ss.getOutputStream(),true);
            BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Options:");
                System.out.println("a. Circle");
                System.out.println("b. Rectangle");
                System.out.println("c. Square");
                System.out.println("d. Triangle");
                System.out.println("e. exit");
                System.out.print("Enter your choice: ");
                
                String option = inputData.readLine();

                if (option.equals("e")) {
                    out.println(option);
                    break;
                }

                if (option.equals("a")) {
                    System.out.print("Enter Radious For Circle :");
                    String r = inputData.readLine();
                    String sendData = option+":"+r;
                    out.println(sendData);
                }
                else if (option.equals("b")) {
                    System.out.print("Enter Value Of height For Rectangle :");
                    String l = inputData.readLine();
                    System.out.print("Enter Value Of Width For Rectangle :");
                    String w = inputData.readLine();
                    String sendData = option+":"+l+":"+w;
                    out.println(sendData);

                }
                else if (option.equals("c")) {
                    System.out.print("Enter Value Of Side For Square :");
                    String s = inputData.readLine();
                    String sendData = option+":"+s;
                    out.println(sendData);
                }
                else if (option.equals("d")) {
                    System.out.print("Enter Value Of Base For Triangle :");
                    String b = inputData.readLine();
                    System.out.print("Enter Value Of height For Triangle :");
                    String h = inputData.readLine();
                    String sendData = option+":"+b+":"+h;
                    out.println(sendData);
                }

               String response = in.readLine();
               System.out.println("Server Says : "+response);
                
            }
        }
        catch(Exception e)
        {

        }
    }
}
