package PRCO304HK.ANDYLAM.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository
        extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByIdNumber(String id);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE AppUser a " +
            "SET a.email = ?1, a.appUserRole = ?2, a.firstName = ?3, a.lastName = ?4 WHERE a.email = ?1")
    int updateAppUser(String email, AppUserRole appUserRole, String firstName, String lastName);

}
