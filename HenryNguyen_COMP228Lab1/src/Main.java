public class Main {

    public static void main(String[] args) {
        Singers singer1 = new Singers();
        System.out.println("\nDefault instance: ");
        printSinger(singer1);

        singer1.setAll("123", "Test Name", "456 Street", "1990-01-01", 3);
        System.out.println("\nInvoking setAll(): ");
        printSinger(singer1);

        singer1.setId("321");
        singer1.setName("Name Test");
        singer1.setAddress("654 Street");
        singer1.setDob("1999-02-02");
        singer1.setNumOfAlbums(30);
        System.out.println("\nInvoking individual set functions: ");
        printSinger(singer1);
    }

    public static void printSinger(Singers singer) {

        System.out.printf("\nID: %s\n" +
                        "Name: %s\n" +
                        "Address: %s\n" +
                        "Date of Birth: %s\n" +
                        "Number of Albums: %d\n",
                singer.getId(), singer.getName(),
                singer.getAddress(), singer.getDob(),
                singer.getNumOfAlbums());

    }

}