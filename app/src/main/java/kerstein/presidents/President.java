package kerstein.presidents;


public class President {
    private int number;
    private String president;
    private int birth_year;
    private Integer death_year;  //not an int cuz not always guaranteed to be there
    private String took_office;
    private String left_office;
    private String party;

    public int getBirth_year() {
        return birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public String getLeft_office() {
        return left_office;
    }

    public int getNumber() {
        return number;
    }

    public String getParty() {
        return party;
    }

    public String getPresident() {
        return president;
    }

    public String getTook_office() {
        return took_office;
    }
}
