public class Account {
    public double total;

    public Account(int total) {
        this.total = total;
    }

    public synchronized void deposit(double amount) {
        total += amount;
        System.out.println("Deposited " + amount);
    }

    public synchronized void  withdraw(double amount) {
        total -= amount;
        System.out.println("Withdrawn " + amount);
    }

}
