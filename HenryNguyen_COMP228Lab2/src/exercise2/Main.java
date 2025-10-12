package exercise2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter a number between 3 and 27:\t");
        int inputInt = Integer.parseInt(input);
        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto();
            if (inputInt == lotto.getSum()) {
                JOptionPane.showMessageDialog(null, "You won!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "You lost!");
    }
}
