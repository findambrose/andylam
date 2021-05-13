package PRCO304HK.ANDYLAM.results;


import PRCO304HK.ANDYLAM.contestants.Contestant;
import PRCO304HK.ANDYLAM.contestants.ContestantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ResultController {

    @Autowired
    ResultService resultService;

    @Autowired
    ContestantService contestantService;

    @GetMapping("/results/add/{id}")
    public int getVotes(@PathVariable int candidateId){
        return resultService.getTotalVotes(candidateId);
    }

    @GetMapping("/results/user")
    public String  getAllVotesUser(Model model){
        List<Contestant> contestants = contestantService.get();
        model.addAttribute("contestants", contestants);
        return "vote";
    }


    @PostMapping("/vote")
    public void vote(Vote vote){
        resultService.vote(vote);
    }
}
