import java.util.*;

//Interface for bank account operations
interface IBankAccount{
    double getBalance();
    void deposit(double amount);
    boolean withdraw(double amount);
}

//Interface for ATM Operations
interface IATM{
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
    void showMenu();
}

//Class to represent user's bank account
class BankAccount implements IBankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance=initialBalance;
    }

    @Override
    public double getBalance(){
        return balance;
    }

    @Override
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Amount successfully deposited: "+amount+" Rs.");
        }else{
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public boolean withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Amount successfully withdrawn: "+amount+" Rs.");
            return true;
        }else if (amount>balance) {
            System.out.println("Insufficient balance.Amount cannot be withdrawn");
            return false;
        }else{
            System.out.println("Please enter correct amount");
            return false;
        }
    }
}

//Class to represent the ATM machine
class ATM implements IATM{
    private IBankAccount account;

    public ATM(IBankAccount account){
        this.account = account;
    }

    @Override
    public void checkBalance(){
        System.out.println("Current balance: "+account.getBalance()+" Rs.");
    }

    @Override
    public void deposit(double amount){
        account.deposit(amount);
    }

    @Override
    public void withdraw(double amount){
        account.withdraw(amount);
    }

    @Override
    public void showMenu(){
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("Welcome to the ATM Machine . Please select from the below option: ");
            System.out.println("1.Check Balance");
            System.out.println("2.Deposit Amount");
            System.out.println("3.Withdraw Amount");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            
            int choice=sc.nextInt();

            switch(choice){
                case 1 : checkBalance();
                         break;

                case 2 : System.out.println("Enter amount to deposit: ");
                         double depositAmount=sc.nextDouble();
                         deposit(depositAmount);
                         break;
               
                case 3 : System.out.println("Enter amount to withdraw: ");
                         double withdrawAmount=sc.nextDouble();
                         withdraw(withdrawAmount);
                         break;  
                         
                case 4 : System.out.println("Thank you for choosing our ATM.");
                         sc.close();
                         return;
                         
                default : System.out.println("Invalid choice.Please try again.");         
                         
            }
        }
    }
}


//Main class to run the ATM program
public class ATMSystem {
    public static void main(String[] args) {
        IBankAccount account=new BankAccount(1000.00);
        IATM atm=new ATM(account);
        atm.showMenu();
    }
}
