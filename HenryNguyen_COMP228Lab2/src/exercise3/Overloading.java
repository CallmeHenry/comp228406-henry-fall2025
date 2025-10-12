package exercise3;

import javax.swing.*;

public class Overloading {

    public static void print(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static void print(int s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static void print(double s) {
        JOptionPane.showMessageDialog(null, s);
    }

}
