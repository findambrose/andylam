package PRCO304HK.ANDYLAM.contestants;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Contestant {


    private int id;
    private String name;

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    private String party;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
