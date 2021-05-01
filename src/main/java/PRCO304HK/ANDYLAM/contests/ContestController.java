package PRCO304HK.ANDYLAM.contests;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContestController {

    @Autowired
    ContestService contestService;

    @GetMapping("/contests")
    public List<Contest> get(){
        return contestService.get();
    }

    @PostMapping("/contests")
    public void save(Contest contest){
        contestService.save(contest);
    }

}
