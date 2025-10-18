package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Mortgage[] mortgages = new Mortgage[3];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter current interest rate: ");
        double currentInterestRate = input.nextDouble();
        input.nextLine();

        for (int i = 0; i < mortgages.length; i++) {

            System.out.print("Enter type (business or personal): ");
            String type = input.nextLine();

            System.out.print("Enter mortgage number: ");
            String number = input.nextLine();

            System.out.print("Enter customer name: ");
            String name = input.nextLine();

            System.out.print("Enter mortgage amount: ");
            double amount = input.nextDouble();
            input.nextLine();

            System.out.print("Enter term: ");
            int term = input.nextInt();
            input.nextLine();

            if (type.equalsIgnoreCase("business")) {
                mortgages[i] = new BusinessMortgage(number, name, amount, currentInterestRate, term);
            } else {
                mortgages[i] = new PersonalMortgage(number, name, amount, currentInterestRate, term);
            }
        }

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println(mortgages[i].getMortgageInfo());
        }

    }
}
