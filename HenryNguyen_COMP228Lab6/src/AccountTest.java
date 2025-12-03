import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(50000);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, 25, "deposit"));
        transactions.add(new Transaction(account, 50, "deposit"));
        transactions.add(new Transaction(account, 75, "withdraw"));

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(transactions.get(0));
        executorService.execute(transactions.get(1));
        executorService.execute(transactions.get(2));

        executorService.shutdown();
        
        System.out.println(account.total);

    }
}