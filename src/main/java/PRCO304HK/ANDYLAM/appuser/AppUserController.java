package PRCO304HK.ANDYLAM.appuser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserService;

    @GetMapping("/users/get")
    public String get(Model model){
        List<AppUser> appUsers = new ArrayList<>();
       appUserService.findAll().forEach(appUser -> appUsers.add(appUser));
       model.addAttribute("users", appUsers);
       return "all-users";
    }
}
