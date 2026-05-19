public class Account {
    private double balance = 0;
    static double interestRate = 0;

    void deposit(double amount){
        if(amount > 0) {
            balance += amount;
        }
        else
        {
            java.lang.IO.print("Error");
        }
    }
    void withdraw(double amount){
        if(((balance - amount) >= 0) && (amount > 0))
        {
            balance -= amount;
        }
        else
        {
            java.lang.IO.print("Error");
        }
    }
    void transfer(Account toTransfer,int amount){
        if(((balance - amount) >= 0) && (amount > 0)) {
            withdraw(amount);
            toTransfer.deposit(amount);
        }
        else
        {
            java.lang.IO.print("Error");
        }
    }
    void addInterest(){
        balance += balance * (interestRate/100);
    }
    static void setInterestRate(double value) {
        interestRate = value;
    }

    double getBalance()
    {
        return balance;
    }
}
