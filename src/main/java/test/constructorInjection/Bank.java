package test.constructorInjection;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class Bank {
    DecimalFormat f;
    ArrayList<Account> accountList;
    Transfer transfer;

    public Bank(Transfer injectedTransfer){
        this.f = new DecimalFormat("#.00");
        this.accountList = new ArrayList<Account>();
        this.transfer = injectedTransfer;
    }

    public void addAccount(Account account){
        accountList.add(account);
    }

    private boolean checkForAccount(String name){
        boolean found = false;
        for (Account account : accountList) {
            if (account.getName().equalsIgnoreCase(name)) {
                found = true;
            }
        }
        return found;
    }

    public int findAccountIndex(String name){
        int index = -1;
        for (int i = 0; i < accountList.size(); i++){
            if (accountList.get(i).getName().equalsIgnoreCase(name)){
                index = i;
            }
        }
        return index;
    }

    public Account getAccount(String name){
        return accountList.get(findAccountIndex(name));
    }

    public String transfer(String sender, String receiver, double amount){
        String s = "";
        if ((checkForAccount(sender) && checkForAccount(receiver)) && !sender.equalsIgnoreCase(receiver)){
            transfer.completeTransfer(getAccount(sender), getAccount(receiver), amount);
            s = "Transfer complete.";
        } else {
            s = "Transfer unable to be completed. Check account names and try again.";
        }
        return s;
    }

    public String checkBalance(String name){
        String s = "";
        if(checkForAccount(name)){
            s += "Welcome, "+name+" your balance is currently $"+f.format(getAccount(name).getBalance());
        } else {
            s += "Sorry, I could not find your account.";
        }
        return s;
    }

    public String depositFunds(String name, double amount){
        String s = "";
        if(checkForAccount(name)){
            getAccount(name).addBalance(amount);
            s += name+", after adding $"+f.format(amount)+", your new balance is $"+f.format(getAccount(name).getBalance());
        } else {
            s += "Sorry, I could not find your account.";
        }
        return s;
    }

    public String withdrawFunds(String name, double amount){
        String s = "";
        if(checkForAccount(name)){
            getAccount(name).removeBalance(amount);
            s += name+", after withdrawing $"+f.format(amount)+", your new balance is $"+f.format(getAccount(name).getBalance());
        } else {
            s += "Sorry, I could not find your account.";
        }
        return s;
    }
}
