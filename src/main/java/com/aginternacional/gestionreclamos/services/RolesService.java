package com.aginternacional.gestionreclamos.services;

import com.aginternacional.gestionreclamos.domain.Roles;
import com.aginternacional.gestionreclamos.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> obtenerRoles() {

        List<Roles> roles = new ArrayList<>();
        rolesRepository.findAll()
                .forEach(roles::add);

        return roles;
    }
}
