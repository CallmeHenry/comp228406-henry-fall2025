import java.time.LocalDate;

public class Singers {
    private String id;
    private String name;
    private String address;
    private LocalDate dob;
    private int numOfAlbums;

    public Singers() {
        this.id =  "";
        this.name = "";
        this.address = "";
        this.dob = null;
        this.numOfAlbums = 0;
    }

    public Singers(String id,  String name, String address,
                   LocalDate dob, int numOfAlbums) {
       this.id = id;
       this.name = name;
       this.address = address;
       this.dob = dob;
       this.numOfAlbums = numOfAlbums;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }

    public void setNumOfAlbums(int numOfAlbums) {
        this.numOfAlbums = numOfAlbums;
    }

    public void setAll(String id, String name, String address, String dob, int numOfAlbums) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = LocalDate.parse(dob);
        this.numOfAlbums = numOfAlbums;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public int getNumOfAlbums() {
        return this.numOfAlbums;
    }
    
}
