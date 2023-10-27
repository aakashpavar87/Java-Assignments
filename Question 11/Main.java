import java.util.Scanner;

class Bank_account {
    private int Account_id;
    private String mobile_number;
    private String account_holder_name;
    private String account_type;
    private double account_balance;
    private double Credit_limit;

    public Bank_account(int Account_id, String mobile_number, String account_holder_name, String account_type, double account_balance, double Credit_limit) {
        this.Account_id = Account_id;
        this.mobile_number = mobile_number;
        this.account_holder_name = account_holder_name;
        this.account_type = account_type;
        this.account_balance = account_balance;
        this.Credit_limit = Credit_limit;
    }

    public Bank_account() {
        // Default constructor
    }

    public void update_account() {
        // Method to update account details
    }

    @Override
    public String toString() {
        return "Account ID: " + Account_id +
                "\nMobile Number: " + mobile_number +
                "\nAccount Holder Name: " + account_holder_name +
                "\nAccount Type: " + account_type +
                "\nAccount Balance: " + account_balance +
                "\nCredit Limit: " + Credit_limit;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank_account[] accounts = new Bank_account[5];

        accounts[0] = new Bank_account(1, "1234567890", "John Doe", "Savings", 1000.0, 5000.0);
        accounts[1] = new Bank_account(2, "9876543210", "Jane Smith", "Current", 5000.0, 10000.0);
        accounts[2] = new Bank_account(3, "5555555555", "Alice Johnson", "Savings", 2000.0, 3000.0);
        accounts[3] = new Bank_account(4, "9999999999", "Bob Williams", "Current", 3000.0, 5000.0);
        accounts[4] = new Bank_account(5, "7777777777", "Eve Brown", "Savings", 4000.0, 6000.0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();

        Bank_account selectedAccount = null;
        for (Bank_account account : accounts) {
            if (account != null && account.getAccount_id() == accountId) {
                selectedAccount = account;
                break;
            }
        }

        if (selectedAccount != null) {
            System.out.println(selectedAccount);
        } else {
            System.out.println("Account not found!");
        }
    }
}