package PRCO304HK.ANDYLAM.contestants;
import PRCO304HK.ANDYLAM.results.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContestantService {


    @Autowired
    ResultService resultService;

    public List<Contestant> get(){
        List<Contestant> contestList = new ArrayList<>();

        return contestList;
    }

    public Contestant getContestantById(int id){
        Contestant contestant = new Contestant();
        contestant.setId(1);
        contestant.setName("Ambrose");
        return contestant;
    }

    public Contestant addContestant(Contestant c){
        //set contestant's initial vote count to 0
        Contestant contestant = new Contestant();
        contestant.setId(1);
        contestant.setName("Ambrose");
        return contestant;

    }

    public Contestant updateContestant(Contestant c){
        //set contestant's initial vote count to 0
        Contestant contestant = new Contestant();
        contestant.setId(1);
        contestant.setName("Ambrose");
        return contestant;

    }


    public void delete(int id) {

        Contestant contestant = new Contestant();
        contestant.setId(id);

    }
}
