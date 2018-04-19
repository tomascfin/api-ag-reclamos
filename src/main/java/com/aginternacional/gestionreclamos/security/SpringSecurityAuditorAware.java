package com.aginternacional.gestionreclamos.security;

import com.aginternacional.gestionreclamos.config.Constants;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        //Optional<String> optional = new Optional<>()
        String userName = SecurityUtils.getCurrentUserLogin();
        //return Optional<userName>;
        return null;
    }
}
