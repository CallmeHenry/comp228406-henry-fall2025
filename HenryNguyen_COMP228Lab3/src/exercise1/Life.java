package exercise1;

class Life extends Insurance {

    public Life(String insuranceType, double insurancePrice) {
        super(insuranceType, insurancePrice);
    }

    @Override
    public void setInsuranceCost(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    @Override
    public String displayInfo() {
        return "Insurance Type: " + this.insuranceType + ". Insurance Price: " + this.insurancePrice + "\n";
    }
}
