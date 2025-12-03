
public class Transaction implements Runnable {
    private final Account account;
    private final double amount;
    private final String input;

    public Transaction(Account account, double amount, String input) {
        this.account = account;
        this.amount = amount;
        this.input = input;
    }


    public void run() {
           if ("deposit".equals(input)) {
               account.deposit(amount);
           }
           else if ("withdraw".equals(input)) {
               account.withdraw(amount);
           }
    }
}
