package PRCO304HK.ANDYLAM.contestants;

import PRCO304HK.ANDYLAM.contests.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContestantController {

    @Autowired
    ContestantService contestantService;

    @PostMapping("/contestants")
    public void save(Contestant c){
        contestantService.save(c);
    }

    @GetMapping("/contestants")
    public String get(Model model){
       List<Contestant> contestants = contestantService.get();
       model.addAttribute("contestants", contestants);
       return "all-contestants";
    }

    @PostMapping("/contestants/update")
    public void update(Contest contest){
        contestantService.update(contest);
    }

    @GetMapping("/contestants/delete")
    public void update(int id){
        contestantService.delete(id);
    }
}
