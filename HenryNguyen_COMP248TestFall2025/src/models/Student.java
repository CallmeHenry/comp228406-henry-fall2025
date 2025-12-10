package models;

public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String province;
    private String postalCode;

    public Student(String studentID, String firstName, String lastName, String address, String city, String province, String postalCode) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return studentID + "\t" + firstName + "\t" + lastName + "\t" +
                address + "\t" + city + "\t" + province + "\t" + postalCode + "\n";
    }
}