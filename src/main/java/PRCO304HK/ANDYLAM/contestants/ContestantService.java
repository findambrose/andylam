package PRCO304HK.ANDYLAM.contestants;


import PRCO304HK.ANDYLAM.contests.Contest;
import PRCO304HK.ANDYLAM.results.Result;
import PRCO304HK.ANDYLAM.results.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContestantService {
    @Autowired
    ContestantRepository contestantRepository;

    @Autowired
    ResultService resultService;

    public List<Contestant> get(){
        List<Contestant> contestList = new ArrayList<>();
        contestantRepository.findAll().forEach(contest -> contestList.add(contest));
        return contestList;
    }

    public List<Contestant> getByContestId(int id){
        List<Contestant> contestList = new ArrayList<>();
        contestantRepository.findAll().forEach(contest -> contestList.add(contest));
        return contestList;
    }

    public Contestant save(Contestant c){

        //set contestant's initial vote count to 0
        Result _initial = new Result();
        _initial.setContestantId(c.getContestId());
        _initial.setContestId(c.getContestId());
        _initial.setCount(0);
        resultService.updateVote(_initial);
        return contestantRepository.save(c);
    }

    public void update(Contest contest) {
        //TODO: Update contest
    }

    public void delete(int id) {

        Contestant contestant = new Contestant();
        contestant.setId(id);
        contestantRepository.delete(contestant);
    }
}
