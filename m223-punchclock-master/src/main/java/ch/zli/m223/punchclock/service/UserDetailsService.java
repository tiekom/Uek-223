package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    public UserDetailsService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public ApplicationUser findByUsername(String username) {
        return applicationUserRepository.findByUsername(username);
    }

    public Optional<ApplicationUser> findById(Long id) {
        return applicationUserRepository.findById(id);
    }

    public void existsByUsername(String username) {
        applicationUserRepository.existsByUsername(username);
    }

    public void ApplicationUser(ApplicationUser applicationUser) {
        applicationUserRepository.save(applicationUser);
    }

    public void deleteById(Long id) {
        applicationUserRepository.deleteById(id);
    }

}
