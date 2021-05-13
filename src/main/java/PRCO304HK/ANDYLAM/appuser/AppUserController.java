package PRCO304HK.ANDYLAM.appuser;


import PRCO304HK.ANDYLAM.registration.RegistrationRequest;
import PRCO304HK.ANDYLAM.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserService;

    @Autowired
    AppUserService aUserService;

    @Autowired
    RegistrationService regService;

    @Autowired
    EntityManager em;

    @GetMapping("/users/get")
    public String get(Model model){
        List<AppUser> appUsers = new ArrayList<>();
       appUserService.findAll().forEach(appUser -> {
           appUser.getFullName();
           appUser.getStringName();
           appUsers.add(appUser);});
       model.addAttribute("users", appUsers);
       return "all-users";
    }

    @PostMapping("/users/update")
    public void update(RegistrationRequest request){
        aUserService.update(request);
    }


    @GetMapping("/users/delete/{id}]")
    public String delete(@PathVariable Long id){
        AppUser appUser = new AppUser();
        appUser.setId(id);
       appUserService.delete(appUser);
        return "redirect:/users/get";
    }

    @PostMapping("/users/add")
    public String addNewUser(RegistrationRequest request, RedirectAttributes at){

        regService.addUser(request, AppUserRole.USER, at);
        return "redirect:/users/get";
    }
}
