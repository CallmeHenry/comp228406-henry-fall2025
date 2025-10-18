package exercise3;

public class BusinessMortgage extends Mortgage{
    public BusinessMortgage(String mortgageNumber, String customerNumber, double mortgageAmount, double interestRate, int term) {
        super(mortgageNumber,  customerNumber, mortgageAmount, interestRate, term);
        this.interestRate = interestRate + 0.01;
    }
}
