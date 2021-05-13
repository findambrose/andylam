package PRCO304HK.ANDYLAM.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    public int getTotalVotes (int contestantId){
        //Get total votes
        int votes = 5;
        return votes;
    }

    public void vote(Vote vote){
        //Interact with bchain to vote
    }
}
