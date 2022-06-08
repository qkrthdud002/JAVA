public class DepositThread implements Runnable{
    private final String name;
    private final Bank1 bank;
    private int amount;

    public DepositThread(String name, Bank1 bank, int i){
        this.name = name;
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run(){
        bank.deposit(name, amount);
    }


}