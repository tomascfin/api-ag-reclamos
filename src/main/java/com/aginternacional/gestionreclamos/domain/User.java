package com.aginternacional.gestionreclamos.domain;

import com.aginternacional.gestionreclamos.config.Constants;
import com.aginternacional.gestionreclamos.pojo.AbstractAuditingEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
@Data
//@Cache(usage = CacheConcurrencyStrategy.NONE.NONSTRICT_READ_WRITE)
public class User extends AbstractAuditingEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorUser")
    @SequenceGenerator(name = "sequenceGeneratorUser")
    private Long id;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password_hash",length = 60)
    private String password;

    @NotNull
    @Column(nullable = false)
    private String role;


}
