package exercise2;

public class FullTimeGameTester extends GameTester {
    private double salary = 3000;

    public FullTimeGameTester(String name, boolean employmentStatus) {
        super(name, employmentStatus);
    }

    @Override
    public double determineSalary() {
        return salary;
    }
}
