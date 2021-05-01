package PRCO304HK.ANDYLAM.contestants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    public List<Contestant> get(){

        return contestantService.get();

    }
}
