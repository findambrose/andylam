package PRCO304HK.ANDYLAM.appuser;

import PRCO304HK.ANDYLAM.registration.RegistrationRequest;
import PRCO304HK.ANDYLAM.registration.token.ConfirmationToken;
import PRCO304HK.ANDYLAM.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    @Autowired
    public AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;


    @Autowired
    private EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
       Optional<AppUser> appUser = appUserRepository.findByEmail(email);

        if (appUser.isPresent()) {
            AppUser userFound = appUser.get();
            return new org.springframework.security.core.userdetails.User(userFound.getUsername(),
                    userFound.getPassword(), userFound.getAuthorities());
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("An account with the email {0} not found.", email));
        }
    }

    public String signUpUser(AppUser appUser, RedirectAttributes at) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getUsername())
                .isPresent();

        if (userExists) {

            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            at.addFlashAttribute("emailinuse", "Emil address is taken.");
           // throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public String update(RegistrationRequest request) {

        AppUserRole appUserRole = request.getRole() == "ADMIN" ? AppUserRole.ADMIN : AppUserRole.USER;
        appUserRepository.updateAppUser(request.getEmail(), appUserRole, request.getFirstName(), request.getLastName());
        return "redirect:/users/get";
    }
}
