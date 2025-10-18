package exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameTester gameTester;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter game tester name: ");
        String name = input.nextLine();

        System.out.print("Enter game tester employment status (fulltime or parttime):  ");
        String employmentStatus = input.nextLine();
        if (employmentStatus.equalsIgnoreCase("fulltime")) {
            gameTester = new FullTimeGameTester(name, true);
        } else if (employmentStatus.equalsIgnoreCase("parttime")) {
            System.out.print("Enter number of hours: ");
            int hours = input.nextInt();
            gameTester = new PartTimeGameTester(name, false, hours);
        } else {
            System.out.println("Invalid input. Try again.");
            return;
        }

        System.out.println("Your game tester, " + gameTester.name + ", is a "
                + (gameTester.employmentStatus ? "full-time" : "part-time") + " game tester."
                + " Their salary is: " + gameTester.determineSalary()
        );


    }
}
