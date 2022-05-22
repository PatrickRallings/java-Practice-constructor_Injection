package test.constructorInjection;

public interface Account {
    String getAccountInfo();
    String getName();
    double getBalance();
    void addBalance(double amount);
    void removeBalance(double amount);
}
