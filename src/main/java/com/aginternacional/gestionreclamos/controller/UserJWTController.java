package com.aginternacional.gestionreclamos.controller;

import com.aginternacional.gestionreclamos.pojo.JWTToken;
import com.aginternacional.gestionreclamos.security.jwt.JWTConfigurer;
import com.aginternacional.gestionreclamos.security.jwt.TokenProvider;
import com.aginternacional.gestionreclamos.vm.LoginVM;
import org.glassfish.jersey.server.validation.ValidationError;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class UserJWTController {

    private final Logger log = LoggerFactory.getLogger(UserJWTController.class);

    private final TokenProvider tokenProvider;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public UserJWTController( TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }



    @PostMapping("/authenticate")
    public ResponseEntity authorize(@Valid @RequestBody LoginVM loginVM, HttpServletResponse response) {
        System.out.println("entra a authorize");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword());
        System.out.println("1");
        System.out.println("authenticationToken : "+ authenticationToken.toString());

        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            System.out.println("2");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("3");
            boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();
            System.out.println("4");
            String jwt = tokenProvider.createToken(authentication, rememberMe);
            System.out.println("5");
            response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
            System.out.println("6");
            return ResponseEntity.ok(new JWTToken(jwt));
        } catch (AuthenticationException ae) {
            log.trace("Authentication exception trace: {}", ae);
            return new ResponseEntity<>(Collections.singletonMap("AuthenticationException",
                    ae.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }



}
