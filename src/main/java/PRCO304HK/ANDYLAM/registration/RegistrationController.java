package PRCO304HK.ANDYLAM.registration;

import PRCO304HK.ANDYLAM.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public String register(RegistrationRequest request) {
        return registrationService.register(request, AppUserRole.USER);
    }

    @PostMapping(path = "admin")
    public String registerAdmin(RegistrationRequest request) {
        return registrationService.register(request, AppUserRole.ADMIN);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
