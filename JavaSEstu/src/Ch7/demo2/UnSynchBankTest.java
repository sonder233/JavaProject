package Ch7.demo2;

public class UnSynchBankTest {
    public static final int N_ACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new Bank(N_ACCOUNTS,INITIAL_BALANCE);
        for (int i = 0; i < N_ACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = ()->{
                try {
                    while (true){
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY*Math.random()));
                    }
                }catch (InterruptedException exception){
                    exception.printStackTrace();
                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}
