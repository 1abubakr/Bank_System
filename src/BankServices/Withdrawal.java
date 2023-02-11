package BankServices;

public class Withdrawal extends Operation{
    public Withdrawal(int date, double balance){
        super(date, balance);
    }

    @Override
    public String toString() {return super.getDate() + ","+ super.getBalance()+ "+";
    }
}
