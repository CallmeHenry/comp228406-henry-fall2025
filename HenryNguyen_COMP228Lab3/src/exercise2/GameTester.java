package exercise2;

abstract class GameTester {
    protected String name;
    protected boolean employmentStatus;

    public GameTester(String name, boolean employmentStatus) {
        this.name = name;
        this.employmentStatus = employmentStatus;
    }

    public abstract double determineSalary();
}
