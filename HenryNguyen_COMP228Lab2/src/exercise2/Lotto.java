package exercise2;
import javax.swing.*;
import java.util.Random;

public class Lotto {
   private final int[] randomIntegers = new int[3];
   private final Random rand =  new Random();
   private int sum = 0;

   public Lotto() {
        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = rand.nextInt(9)+1;
            sum += randomIntegers[i];
        }
   }

   public int[] getRandomIntegers() {
       return randomIntegers;
   }

   public int getSum() {
       return sum;
   }

}
