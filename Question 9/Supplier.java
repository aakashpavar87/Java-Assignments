package Mypackage;

import java.util.Scanner;

public class Supplier {
    private int sup_id;
    private String sup_name;
    private String address;
    private String[] product_name;
    private double[] price_of_product;
    private double total_price;

    public Supplier(int sup_id, String sup_name, String address) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.address = address;
        this.product_name = new String[3];
        this.price_of_product = new double[3];
    }

    public void calculate_total_price() {
        try {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                System.out.print("Enter product name: ");
                product_name[i] = scanner.nextLine();

                System.out.print("Enter price of product: ");
                price_of_product[i] = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                total_price += price_of_product[i];
            }
        } catch (Exception e) {
            System.out.println("Error occurred while scanning data.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Supplier ID: " + sup_id +
                "\nSupplier Name: " + sup_name +
                "\nAddress: " + address +
                "\nProduct Name: " + String.join(", ", product_name) +
                "\nTotal Price: " + total_price;
    }
}