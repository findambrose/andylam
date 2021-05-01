package PRCO304HK.ANDYLAM.contests;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContestController {

    @Autowired
    ContestService contestService;

    @GetMapping("/contests")
    public String get(Model model){
        List<Contest>  contestList =  contestService.get();
        model.addAttribute("contests", contestList);
        return "all-contests";
    }

    @PostMapping("/contests")
    public void save(Contest contest){
        contestService.save(contest);
    }

    @PostMapping("/contests/update")
    public void update(Contest contest){
        contestService.update(contest);
    }

    @GetMapping("/contests/delete")
    public void update(int id){
        contestService.delete(id);
    }

}
