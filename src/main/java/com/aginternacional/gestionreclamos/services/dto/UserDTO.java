package com.aginternacional.gestionreclamos.services.dto;
import com.aginternacional.gestionreclamos.config.Constants;
import com.aginternacional.gestionreclamos.domain.Authority;
import com.aginternacional.gestionreclamos.domain.User;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;


public class UserDTO {

    private Long id;

    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;



    public UserDTO() {
        // Empty constructor needed for MapStruct.
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
