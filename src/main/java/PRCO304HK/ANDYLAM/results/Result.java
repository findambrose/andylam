package PRCO304HK.ANDYLAM.results;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Result {

    private int count;
    private int contestantId;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
