package PRCO304HK.ANDYLAM.pages;


import PRCO304HK.ANDYLAM.appuser.AppUser;
import PRCO304HK.ANDYLAM.registration.RegistrationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PagesController {


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

}
