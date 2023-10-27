package GTU;

import java.util.Scanner;

class Supplier {
    protected int sup_id;
    protected String sup_name;
    protected String address;
    protected String[] product_name;
    protected double[] price_of_product;
    protected double total_price;

    public Supplier(int sup_id, String sup_name, String address, String[] product_name, double[] price_of_product) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.address = address;
        this.product_name = product_name;
        this.price_of_product = price_of_product;
    }

    public void calculate_total_price() {
        total_price = 0;
        for (double price : price_of_product) {
            total_price += price;
        }
    }

    public void displaySupplierDetails() {
        System.out.println("Supplier ID: " + sup_id);
        System.out.println("Supplier Name: " + sup_name);
        System.out.println("Address: " + address);
        System.out.println("Product Details:");
        for (int i = 0; i < product_name.length; i++) {
            System.out.println("Product Name: " + product_name[i]);
            System.out.println("Price: " + price_of_product[i]);
        }
        System.out.println("Total Price: " + total_price);
    }
}

class book_supplier extends Supplier {
    private int[] discount;

    public book_supplier(int sup_id, String sup_name, String address, String[] product_name, double[] price_of_product, int[] discount) {
        super(sup_id, sup_name, address, product_name, price_of_product);
        this.discount = discount;
    }

    @Override
    public void calculate_total_price() {
        total_price = 0;
        for (int i = 0; i < price_of_product.length; i++) {
            double discounted_price = price_of_product[i] - (price_of_product[i] * discount[i] / 100);
            total_price += discounted_price;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Supplier ID: ");
        int sup_id = scanner.nextInt();

        System.out.print("Enter Supplier Name: ");
        String sup_name = scanner.next();

        System.out.print("Enter Address: ");
        String address = scanner.next();

        String[] product_name = new String[3];
        double[] price_of_product = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Product Name " + (i + 1) + ": ");
            product_name[i] = scanner.next();
            System.out.print("Enter Price of Product " + (i + 1) + ": ");
            price_of_product[i] = scanner.nextDouble();
        }

        Supplier supplier = new Supplier(sup_id, sup_name, address, product_name, price_of_product);
        supplier.calculate_total_price();
        supplier.displaySupplierDetails();

        System.out.print("Enter Discount for Book Supplier: ");
        int[] discount = new int[3];
        for (int i = 0; i < 3; i++) {
            discount[i] = scanner.nextInt();
        }

        book_supplier bookSupplier = new book_supplier(sup_id, sup_name, address, product_name, price_of_product, discount);
        bookSupplier.calculate_total_price();
        bookSupplier.displaySupplierDetails();
    }
}