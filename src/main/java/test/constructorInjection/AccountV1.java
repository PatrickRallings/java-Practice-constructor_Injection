package test.constructorInjection;


import java.text.DecimalFormat;

public class AccountV1 implements Account{

    DecimalFormat f;
    String name;
    double balance;

    public AccountV1(String name, double balance){
        this.name = name;
        this.balance = balance;
        f = new DecimalFormat("#.00");
    }

    @Override
    public String getAccountInfo() {
        return getName()+"\n"+f.format(getBalance());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void addBalance(double amount) {
        balance += amount;
    }

    @Override
    public void removeBalance(double amount) {
        balance -= amount;
    }
}
