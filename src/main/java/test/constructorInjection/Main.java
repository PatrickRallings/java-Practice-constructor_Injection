package test.constructorInjection;

public class Main {
    public static void main(String[] args) {

// Below is abstraction for creating and transfer using the first version of accounts and transfers
//        Transfer transfer = new TransferV1();
//        Bank bank = new Bank(transfer);
//        bank.addAccount(new AccountV1("Patrick", 500.00));
//        bank.addAccount(new AccountV1("Clay", 100.00));
//        System.out.println(bank.checkBalance("Patrick"));
//        System.out.println(bank.checkBalance("Clay"));
//        System.out.println(bank.transfer("Patrick", "Clay", 400));
//        System.out.println(bank.checkBalance("Patrick"));
//        System.out.println(bank.checkBalance("Clay"));


//Below utilizes the second version for accounts and transfers
// this is possible because the Bank class was created using constructor injections
        Transfer transfer = new TransferV2();
        Bank bank = new Bank(transfer);
        bank.addAccount(new AccountV2("Patrick", 500.00));
        bank.addAccount(new AccountV2("Clay", 100.00));
        System.out.println(bank.checkBalance("Patrick"));
        System.out.println(bank.checkBalance("Clay"));
        System.out.println(bank.transfer("Patrick", "Clay", 400));
        System.out.println(bank.checkBalance("Patrick"));
        System.out.println(bank.checkBalance("Clay"));
        System.out.println(bank.depositFunds("Patrick", 69.00));
        System.out.println(bank.getAccount("Patrick").getAccountInfo());
    }
}