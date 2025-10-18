package exercise1;

abstract class Insurance {
    protected String insuranceType;
    protected double insurancePrice;

    public Insurance(String insuranceType, double insurancePrice) {
        this.insuranceType = insuranceType;
        this.insurancePrice = insurancePrice;
    }

    public String getInsuranceType() {
        return this.insuranceType;
    }

    public double getInsurancePrice() {
        return this.insurancePrice;
    }

    public abstract void setInsuranceCost(double insurancePrice);

    public abstract String displayInfo();
}