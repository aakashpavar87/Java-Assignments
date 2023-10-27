import Mypackage.Supplier;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Supplier ID : ");
        int sup_id = sc.nextInt();
        System.out.print("Enter Supplier Name : ");
        String sup_name = sc.next();
        System.out.print("Enter Supplier Address : ");
        String sup_address = sc.next();

        Supplier sp = new Supplier(sup_id,sup_name,sup_address);
        sp.calculate_total_price();
        System.out.println(sp.toString());

    }
}
