package mypackage;
import java.util.Scanner;
public abstract class Account{
    public Scanner sc = new Scanner(System.in);
    public String AccNO;
    public float balance;
    public Account(String acc,float bal) {
        AccNO = acc;
        balance = bal;
    }
    public void get_data() {
        System.out.println("Your Account No : " + AccNO);
        System.out.println("Your Account Balance : " + balance);
    }
    private void set_data(String newAcc,float bal) {
        AccNO = newAcc;
        balance = bal;
    }
    public float get_balance() {
        return balance;
    }
    public void deposit() {
        System.out.print("Enter amount for deposit : ");
        float amt = sc.nextFloat();
        balance += amt;
        System.out.println("Depositted " + amt + " in your account no " + AccNO);
        System.out.println("Now your balance is : " + get_balance());
    }
    public void withdraw() {
        System.out.print("Enter amount for withdraw : ");
        float amt = sc.nextFloat();
        if(amt > balance) {
            throw new ArithmeticException("You can not withdraw, more than balance");
        }else{
            balance -= amt;
            System.out.println("Withdrawn " + amt + " from your account no " + AccNO);
            System.out.println("Now your balance is : " + get_balance());
        }
    }
}