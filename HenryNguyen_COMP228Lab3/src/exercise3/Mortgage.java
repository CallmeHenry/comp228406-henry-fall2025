package exercise3;

public abstract class Mortgage implements MortgageConstants{
    protected String mortgageNumber;
    protected String customerNumber;
    protected double mortgageAmount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String customerNumber, double mortgageAmount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerNumber = customerNumber;
        this.mortgageAmount = mortgageAmount;
        this.interestRate = interestRate;

        if (this.mortgageAmount > MAX_MORTGAGE) {
            this.mortgageAmount = MAX_MORTGAGE;
        }

        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            this.term = SHORT_TERM;
        }

    }

    public String getMortgageInfo() {
        return String.format(
                "Current Bank: %s\n\tMortgage number: %s\n\tCustomer Number: %s\n\tMortgage Amount: %.2f\n\tInterest Rate: %.2f%%\n\tTerm: %d years",
                BANK_NAME,
                this.mortgageNumber,
                this.customerNumber,
                this.mortgageAmount,
                this.interestRate * 100,
                this.term
        );
    }
}
