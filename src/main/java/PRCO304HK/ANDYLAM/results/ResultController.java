package PRCO304HK.ANDYLAM.results;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ResultController {

    @Autowired
    ResultService resultService;

    @GetMapping("/results/add/{id}")
    public List<Result> get(@PathVariable int id){
        return resultService.getByContestId(id);
    }


    @PostMapping("/vote")
    public void updateVote(Result r){
        resultService.updateVote(r);
    }
}
