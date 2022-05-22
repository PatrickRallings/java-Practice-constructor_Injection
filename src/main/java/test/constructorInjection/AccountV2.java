package test.constructorInjection;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AccountV2  implements Account{

ArrayList<String> actionHistory;
    String name;
    double balance;
    DecimalFormat f = new DecimalFormat("#.00");

    public AccountV2(String name, double balance){
        this.name = name;
        this.balance = balance;
        actionHistory = new ArrayList<String>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    private void addActionHistory(String action){
        actionHistory.add(action);
    }

    public String getActionHistory(){
        StringBuilder s = new StringBuilder();
        for(String action: actionHistory){
            s.append(action).append("\n");
        }
        return s.toString();
    }

    @Override
    public void addBalance(double amount) {
        balance += amount;
        addActionHistory(getName()+", you added $" + f.format(amount) + " to your balance.");
    }

    @Override
    public void removeBalance(double amount) {
        balance -= amount;
        addActionHistory(getName()+", you removed $" + f.format(amount) + " from your balance.");
    }

    @Override
    public String getAccountInfo() {
        return getName()+"\n"+f.format(getBalance())+"\nHistory:\n"+getActionHistory();
    }
}
