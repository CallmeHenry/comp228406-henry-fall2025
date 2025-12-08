public class Player {
    private int playerId;
    private String firstName, lastName, address, postalCode, province, phoneNumber;

    public Player(int playerId, String firstName, String lastName, String address,
                  String postalCode, String province, String phoneNumber) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.phoneNumber = phoneNumber;

    }
    public int getPlayerId() { return playerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPostalCode() { return postalCode; }
    public String getProvince() { return province; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setPlayerId(int playerId) { this.playerId = playerId; }

}
