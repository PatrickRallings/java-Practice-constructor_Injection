package test.constructorInjection;

public class TransferV1 implements Transfer{

    @Override
    public void completeTransfer(Account sender, Account receiver, double amount) {
        sender.removeBalance(amount);
        receiver.addBalance(amount);
    }
}
