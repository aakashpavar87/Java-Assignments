import java.util.Scanner;

import mypackage.Account;
class Savings extends Account{
    public int interestRate;
    public Savings(String acc,float bal,int intrate) {
        super(acc,bal);
        interestRate = intrate;
    }
    public float calc_interest() {
        return get_balance() * (interestRate/100);
    }
    public int check_rate() {
        return interestRate;
    }
    public void apply_interest() {
        float int_amt = calc_interest();
        System.out.println("Hey you have earned interest on your savings worth Rs. " + int_amt);
        balance += int_amt;
        System.out.println("Now you have Balance : " + get_balance() + "Rs.");
    }
}
class Current extends Account{
    public float overDraftLimit;
    public float o_d;
    public Current(String acc,float bal,float lim) {
        super(acc,bal);
        overDraftLimit = lim;
    }
    public void withdraw() {
        System.out.print("Enter amount for withdraw : ");
        float amt = sc.nextFloat();
        if(amt > o_d) {
            System.out.println("Hey you can not withdraw more than Over-draft !!");
            throw new ArithmeticException("Please enter appropriate amount !!");
        }
        if(amt > balance) {
            if(o_d <= overDraftLimit) {
                balance -= amt;
                o_d += amt;
                overDraftLimit -= amt;
            }
            else{
                System.out.println("You have reached your over draft limit!!!!\nPlease add balance :(");
                return ;
            }
        }else{
            balance -= amt;
            System.out.println("Withdrawn " + amt + " from your account no " + AccNO);
            System.out.println("Now your balance is : " + get_balance());
        }
    }
}
public class Bank{
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter Your Saving Account Details : ");
            String acc_num = sc.next();
            float bal = sc.nextFloat();
            int rate = sc.nextInt();
            Savings sa = new Savings(acc_num, bal, rate);
            System.out.println("Please Enter Current Account Details : ");
            acc_num = sc.next();
            bal = sc.nextFloat();
            float lim = sc.nextFloat();
            Current ca = new Current(acc_num,bal,lim);
            boolean end_program = false;

            while(!end_program) {
                System.out.println("---------Welcome To Bank of Java---------------");
                System.out.println("1. Deposit in savings account");
                System.out.println("2. Withdraw in savings account");
                System.out.println("3. Calculate Interest in savings account");
                System.out.println("4. Deposit in current account");
                System.out.println("5. Withdraw in current account");
                System.out.println("6. Check Over-draft in current account");
                System.out.println("7. Check details of current account");
                System.out.println("8. Check details of savings account");
                System.out.println("9. exit from bank !");

                int choice = sc.nextInt();
                switch(choice) {
                    case 1:
                    sa.deposit();
                    break;
                    case 2:
                    sa.withdraw();
                    break;
                    case 3:
                    sa.apply_interest();
                    break;
                    case 4:
                    ca.deposit();
                    break;
                    case 5:
                    ca.withdraw();
                    break;
                    case 6:
                    System.out.println("Your total Over-Draft is worth : "+ca.o_d+"Rs.");
                    break;
                    case 7:
                    ca.get_data();
                    System.out.println("Your total Over-Draft is worth : "+ca.o_d+"Rs.");
                    break;
                    case 8:
                    sa.get_data();
                    System.out.println("Interest Rate : " + sa.check_rate() + "%");
                    break;
                    case 9:
                    end_program = true;
                    break;
                }

            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}