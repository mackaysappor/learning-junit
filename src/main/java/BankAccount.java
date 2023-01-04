import javax.print.attribute.standard.MediaSize;

public class BankAccount {
    private double balance;
    private double minBalance;
    private boolean isActive = true;

    public BankAccount(double balance, double minBalance) {
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double withdraw(double amount){
        if (balance - amount > minBalance)
        {
            balance -= amount;
            return amount;
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
        return balance += amount;
    }
}
