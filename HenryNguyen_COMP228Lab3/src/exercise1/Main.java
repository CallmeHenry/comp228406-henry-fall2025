package exercise1;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        Insurance[] insuranceArr = new Insurance[2];

        for (int i = 0; i < insuranceArr.length; i++) {
            String inputType = JOptionPane.showInputDialog("Enter your insurance type: (Health or Life)");

            if (inputType.equalsIgnoreCase("Health")) {
                insuranceArr[i] = new Health("Health", 0);
            } else if (inputType.equalsIgnoreCase("Life")) {
                insuranceArr[i] = new Life("Life", 0);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Exiting program.");
                break;
            }

            String inputCost = JOptionPane.showInputDialog("Enter your insurance cost: ");
            insuranceArr[i].setInsuranceCost(Double.parseDouble(inputCost));

        }

        StringBuilder allInsurances = new StringBuilder();
        for (int i = 0; i < insuranceArr.length; i++) {
            allInsurances.append(insuranceArr[i].displayInfo());
        }

        JOptionPane.showMessageDialog(null, allInsurances.toString());
    }
}


