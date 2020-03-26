
/**
 * 1. Write base class and derived class.
 * 2. Apply the theory of polymorphism.
 * 
 * Description: Write bank Account family classes. The Account class is the 
 * base class. CheckingAccount and SavingsAccount are derived classes. Follow 
 * the given UML class diagram.
 *
 * @author: Josh Lewis
 * @version: 11/27/2018
 */
public class JoshLewisProj11
{
    public static void main(String[] args){
        
        // Declare array of 4 new accounts
        Account[] account = new Account[4];
        
        // Initialize each account element in array
        account[0] = new CheckingAccount(123456789, 5000.0);
        account[1] = new CheckingAccount(987654321, 345678.90);
        account[2] = new SavingsAccount(246810123, 8765.43);
        account[3] = new SavingsAccount(135791113, 222.33);
        
        // Make deposit & withdrawal for each account
        account[0].deposit(530);
        account[0].withdraw(5500);
        
        account[1].deposit(5000);
        account[1].withdraw(2010.90);
        
        account[2].deposit(500.07);
        account[2].withdraw(702.50);
        
        account[3].deposit(1500.15);
        account[3].withdraw(249.00);
        
        account[2].addInterest();
        
        account[3].addInterest();
        
        // Print results for each account
        System.out.println(account[0]);
        System.out.println(account[1]);
        System.out.println(account[2]);
        System.out.println(account[3]);
    }
    
    public static class Account {
        protected int id;
        protected double balance;
        
        public Account(){
            this(0,0.0);
        }
        public Account(int id, double balance){
            this.id = id;
            this.balance = balance;
        }
        public void setBalance(double balance){
            this.balance = balance;
        }
        public double getBalance(){
            return balance;
        }
        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return id;
        }
        public void deposit(double amount){
            if(amount <= 0){
                System.out.println("Invalid amount!");
                return;
            }
            balance += amount;
        }
        @Override
        public String toString(){
            String result = "Account ID: " + id + " | " + "Account balance: " + 
                            String.format("$%,.2f", balance);
            return result;
        }
        public void withdraw(double amount){
        }
        public void addInterest() {
        }
    }
    
    public static class CheckingAccount extends Account {
        public CheckingAccount(){
            super();
        }
        public CheckingAccount(int id, double balance){
            super(id, balance);
        }
        @Override
        public void withdraw(double amount){
            if(amount <= 0){
                System.out.println("Invalid amount!");
                return;
            }
            else if(amount > balance){
                System.out.println("Account balance is low.");
                return;
            }
            balance -= amount;
        }
        @Override
        public String toString(){
            String result = "Account ID: " + id + " | " + "Account balance: " + 
                            String.format("$%,.2f", balance);
            return result;
        }
    }
    
    public static class SavingsAccount extends Account {
        private double interestRate = 0.06d;

        public SavingsAccount(){
            super();
        }
        public SavingsAccount(int id, double balance){
            super(id, balance);
        }
        public void setInterestRate(double interestRate){
            this.interestRate = interestRate;
        }
        public double getInterestRate(){
            return interestRate;
        }
        @Override
        public void withdraw(double amount){
            if(amount <= 0) {
                System.out.println("Invalid amount!");
                return;
            } 
            else if(amount > (balance - 500)){
                System.out.println("Account balance is low.");
                return;
            }
            balance -= amount;
        }
        public void addInterest(){
            balance *= (1 + interestRate);
        }
        @Override
        public String toString(){
            String result = "Account ID: " + id + " | " + "Account balance: " + 
                            String.format("$%,.2f", balance);
            return result;
        }
    }
}
