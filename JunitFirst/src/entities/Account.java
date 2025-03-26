package entities;

public class Account {

    public static double FEE_TO_DEPOSIT = 0.02;
    private Long id;
    private double balance;

    public Account() {
    }

    public Account(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amout) {
        if (amout > 0) {
            amout -= (amout * FEE_TO_DEPOSIT);
            balance += amout;
        }
    }

    public void withdraw(double amout) {
        if (amout > 0 && amout < balance) {
            balance -= amout;
        }
        else throw new IllegalArgumentException();
    }

    public double fullWithdraw() {
        double aux = balance;
        balance -= aux;
        return aux;

    }
}
