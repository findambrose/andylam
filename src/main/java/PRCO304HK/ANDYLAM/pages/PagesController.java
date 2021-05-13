package PRCO304HK.ANDYLAM.pages;


import PRCO304HK.ANDYLAM.appuser.AppUser;
import PRCO304HK.ANDYLAM.appuser.AppUserRepository;

import PRCO304HK.ANDYLAM.contestants.Contestant;

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


    @GetMapping("/admin/create-account")
    public String showAdminRegistrationPage(@PathVariable(required = false) String regError,  Model model){


        model.addAttribute("registerRequest", RegistrationRequest.class);
        return "admin-login";
    }

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(Model model, Principal principal){
        AppUser user = appUserRepository.findByEmail(principal.getName()).get();
        Character letter = user.getFullName().charAt(0);
        model.addAttribute("letter", letter);
        model.addAttribute("name",  user.getFullName());
        return "dashboard";
    }

    @GetMapping("users/dashboard")
    public String showUserDashboard(Model model, Principal principal){
        AppUser user = appUserRepository.findByEmail(principal.getName()).get();
        Character letter = user.getFullName().charAt(0);
        model.addAttribute("letter", letter);
        model.addAttribute("name",  user.getFullName());
        return "user";
    }

    @GetMapping("users/edit/{id}")
    public String showUserEditPage(@PathVariable Long id, Model model){
        AppUser user = appUserRepository.findById(id).get();
        user.getStringName();
        model.addAttribute("user", user);
        model.addAttribute("userUpdate", new RegistrationRequest());
        return "edit-profile";
    }


    @GetMapping("contestants/edit/{id}")
    public String showContestantEditPage(@PathVariable int id, Model model){
        Contestant contestant = new Contestant();
        model.addAttribute("contest", contestant);
        model.addAttribute("contestantUpdate", new Contestant());
        return "edit-contestant";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("regRequest", new RegistrationRequest());
        return "login";
    }

    @GetMapping("/users/add-user-page")
    public String showAddUserPage(Model model){
        model.addAttribute("regRequest", new RegistrationRequest());
        return "add-new-user";
    }

    @GetMapping("/users/add-contestant-page")
    public String showAddContestantPage(Model model){
        model.addAttribute("contestant", new Contestant());
        return "add-contestant";
    }


    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal){
        AppUser user = appUserRepository.findByEmail(principal.getName()).get();
        user.getStringName();
        model.addAttribute("user", user);
        return "profile";
    }

}
