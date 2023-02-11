package BankServices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Account {
    private int code;
    private String ownerName;
    private int date;
    private double balance;

    private List<Operation> operations = new ArrayList<>();
    private List<Deposit> deposits = new ArrayList<>();
    private List<Withdrawal> withdrawals = new ArrayList<>();

    public Account(int code, String ownerName, int date, double balance) {
        this.code = code;
        this.ownerName = ownerName;
        this.date = date;
        this.balance = balance;

        Deposit deposit = new Deposit(this.date, balance);
        operations.add(deposit);
        deposits.add(deposit);
    }

    public int getCode() {
        return code;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getDate() {
        return date;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return code + "," + ownerName + "," + date + "," + balance;
    }

    public List<Operation> getMovements() {
        operations.sort(new ByDateOperationComparatorreversed());
        return operations;
    }
    private static class ByDateOperationComparatorreversed implements Comparator<Operation>{

        @Override
        public int compare(Operation o1, Operation o2) {
            return o2.getDate() - o1.getDate();
        }
    }

    public List<Deposit> getDeposits() {
        deposits.sort(new ByDateOperationComparatorreversed());
        return deposits;
    }

    public List<Withdrawal> getWithdrawals() {
        withdrawals.sort(new ByDateOperationComparatorreversed());
        return withdrawals;
    }

    public void deposit(int date, double amount) {
        if (date> this.date) this.date = date;
        balance+=amount;
        Deposit deposit = new Deposit(this.date,amount);
        operations.add(deposit);
        deposits.add(deposit);
    }
    public void withdraw(int date, double amount){
        if (date > this.date) this.date = date;
        balance-=amount;
        Withdrawal withdrawal = new Withdrawal(this.date, amount);
        operations.add(withdrawal);
        withdrawals.add(withdrawal);
    }


}
