package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {

    public Optional<ApplicationUser> findByUsername(String username) {
        return Optional.empty();
    }

    public Optional<ApplicationUser> findById(Long id) {
        return Optional.empty();
    }

    public Boolean existsByUsername(String username) {
        return null;
    }

    public Boolean existsByEmail(String email) {
        return null;
    }
}
