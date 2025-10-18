package exercise2;

public class PartTimeGameTester extends GameTester {
    private double salary = 20;
    private int hours;

    public PartTimeGameTester(String name, boolean employmentStatus, int hours) {
        super(name, employmentStatus);
        this.hours = hours;
    }

    @Override
    public double determineSalary() {
        return salary*hours;
    }
}
