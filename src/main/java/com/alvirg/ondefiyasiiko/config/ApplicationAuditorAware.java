package com.alvirg.ondefiyasiiko.config;

import com.alvirg.ondefiyasiiko.user.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // get the currentAuditor
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // check if the user is not authenticated || or we don't know the user yet
        if (authentication == null
                || !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken){
            return Optional.empty(); // the we don't have an authenticated user
        }

        // get the user from the principal and cast it to user
        User userPrincipal = (User) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getId());
    }
}
