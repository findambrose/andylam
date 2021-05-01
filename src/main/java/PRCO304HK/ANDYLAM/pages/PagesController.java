package PRCO304HK.ANDYLAM.pages;


import PRCO304HK.ANDYLAM.appuser.AppUser;
import PRCO304HK.ANDYLAM.appuser.AppUserRepository;
import PRCO304HK.ANDYLAM.appuser.AppUserService;
import PRCO304HK.ANDYLAM.contestants.Contestant;
import PRCO304HK.ANDYLAM.contestants.ContestantRepository;
import PRCO304HK.ANDYLAM.contests.Contest;
import PRCO304HK.ANDYLAM.contests.ContestRepository;
import PRCO304HK.ANDYLAM.registration.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class PagesController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ContestantRepository contestantRepository;

    @Autowired
    ContestRepository contestRepository;

    @GetMapping("admin/create-account")
    public String showAdminRegistrationPage(Model model){
        model.addAttribute("registerRequest", RegistrationRequest.class);
        return "adminRegistration";
    }

    @GetMapping("admin/dashboard")
    public String showAdminDashboard(Model model){
        AppUser user = new AppUser("Ambrose", "Kyusya");
        model.addAttribute("userDetails", user);
        return "dashboard";
    }

    @GetMapping("users/dashboard")
    public String showUserDashboard(Model model){

        AppUser user = new AppUser("Ambrose", "Kyusya");
        model.addAttribute("userDetails", user);
        return "user";
    }

    @GetMapping("users")
    public String showAllUsers(Model model){
        AppUser user = new AppUser("Ambrose", "Kyusya");
        model.addAttribute("userDetails", user);
        return "user";
    }

    @GetMapping("users/edit/{id}")
    public String showUserEditPage(@PathVariable Long id, Model model){
        AppUser user = appUserRepository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("userUpdate", new RegistrationRequest());
        return "edit-profile";
    }

    @GetMapping("contests/edit/{id}")
    public String showContestEditPage(@PathVariable int id, Model model){
        Contest contest = contestRepository.findById(id).get();
        model.addAttribute("contest", contest);
        model.addAttribute("contestUpdate", new Contest());
        return "edit-contest";
    }

    @GetMapping("contestants/edit/{id}")
    public String showContestantEditPage(@PathVariable int id, Model model){
        Contestant contestant = contestantRepository.findById(id).get();
        model.addAttribute("contest", contestant);
        model.addAttribute("contestantUpdate", new Contestant());
        return "edit-contestant";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("regRequest", new RegistrationRequest());
        return "login";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal){
        AppUser user = appUserRepository.findByEmail(principal.getName()).get();
        model.addAttribute("user", user);
        return "profile";
    }

}
