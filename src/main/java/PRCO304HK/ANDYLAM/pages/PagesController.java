package PRCO304HK.ANDYLAM.pages;


import PRCO304HK.ANDYLAM.appuser.AppUser;
import PRCO304HK.ANDYLAM.appuser.AppUserRepository;
import PRCO304HK.ANDYLAM.appuser.AppUserService;
import PRCO304HK.ANDYLAM.registration.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class PagesController {

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("admin/create-account")
    public String showAdminRegistrationPage(Model model){
        model.addAttribute("registerRequest", RegistrationRequest.class);
        return "adminRegistration";
    }

    @GetMapping("admin/dashboard")
    public String showAdminDashboard(Model model){
        AppUser user = new AppUser("Ambrose", "Kyusya");
        model.addAttribute("userDetails", user);
        return "adminRegistration";
    }

    @GetMapping("users/dashboard")
    public String showUserDashboard(Model model){

        AppUser user = new AppUser("Ambrose", "Kyusya");
        model.addAttribute("userDetails", user);
        return "user";
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
