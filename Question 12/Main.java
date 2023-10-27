import java.util.Scanner;

class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class Bill {
    private int billId;
    private double[] itemPrice;
    private int totalNumberOfItems;
    private double totalAmount;

    public Bill(int billId, double[] itemPrice, int totalNumberOfItems) {
        this.billId = billId;
        this.itemPrice = itemPrice;
        this.totalNumberOfItems = totalNumberOfItems;
    }

    public void calculateTotalAmount() throws NegativeAmountException {
        double sum = 0;
        for (double price : itemPrice) {
            sum += price;
        }
        if (sum < 0) {
            throw new NegativeAmountException("Total amount cannot be negative.");
        }
        totalAmount = sum;
    }

    public void displayBill() {
        System.out.println("Bill ID: " + billId);
        System.out.println("Total Number of Items: " + totalNumberOfItems);
        System.out.println("Total Amount: " + totalAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Bill ID: ");
        int billId = scanner.nextInt();

        System.out.print("Enter Total Number of Items: ");
        int totalNumberOfItems = scanner.nextInt();

        double[] itemPrice = new double[totalNumberOfItems];
        for (int i = 0; i < totalNumberOfItems; i++) {
            System.out.print("Enter Item Price for Item " + (i + 1) + ": ");
            itemPrice[i] = scanner.nextDouble();
        }

        Bill bill = new Bill(billId, itemPrice, totalNumberOfItems);

        try {
            bill.calculateTotalAmount();
            bill.displayBill();
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}