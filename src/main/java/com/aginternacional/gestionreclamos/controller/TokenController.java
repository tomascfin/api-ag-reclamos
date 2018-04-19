package com.aginternacional.gestionreclamos.controller;

import com.aginternacional.gestionreclamos.domain.User;
import com.aginternacional.gestionreclamos.security.jwt.JwtGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody  final User user){
        user.setId(125L);
        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getRole());
        return jwtGenerator.generate(user);

    }

   /* @PostMapping
    public String generate(@RequestBody final User jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }*/
}
