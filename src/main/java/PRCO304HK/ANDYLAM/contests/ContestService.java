package PRCO304HK.ANDYLAM.contests;


import PRCO304HK.ANDYLAM.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContestService {
    @Autowired
    ContestRepository contestRepository;

    public List<Contest> get(){
        List<Contest> contestList = new ArrayList<>();
        contestRepository.findAll().forEach(contest -> contestList.add(contest));
        return contestList;
    }

    public Contest save(Contest c){
        return contestRepository.save(c);

    }
}
