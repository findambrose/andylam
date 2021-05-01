package PRCO304HK.ANDYLAM.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    ResultRepsitory resultRepsitory;

    public List<Result> getByContestId (int id){
       return resultRepsitory.findByContestId(id);
    }

    public void updateVote(Result s){
        resultRepsitory.save(s);
    }
}
