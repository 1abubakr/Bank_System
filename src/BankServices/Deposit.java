package BankServices;

public class Deposit extends Operation {
    protected Deposit(int date, double balance) {
        super(date, balance);
    }

    @Override
    public String toString() {
        return super.getDate() + " , " + super.getBalance() + "+";
    }
}
