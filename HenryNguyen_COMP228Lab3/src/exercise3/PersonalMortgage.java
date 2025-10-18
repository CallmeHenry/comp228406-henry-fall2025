package exercise3;

public class PersonalMortgage extends Mortgage{
    public PersonalMortgage(String mortgageNumber, String customerNumber, double mortgageAmount, double interestRate, int term) {
        super(mortgageNumber,  customerNumber, mortgageAmount, interestRate, term);
        this.interestRate = interestRate + 0.02;
    }
}
