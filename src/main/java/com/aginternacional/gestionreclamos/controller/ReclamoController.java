package com.aginternacional.gestionreclamos.controller;

import com.aginternacional.gestionreclamos.domain.Reclamo;
import com.aginternacional.gestionreclamos.domain.Roles;
import com.aginternacional.gestionreclamos.services.ReclamoService;
import com.aginternacional.gestionreclamos.services.RolesService;
import com.aginternacional.gestionreclamos.services.dto.ReclamoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @Autowired
    private RolesService rolesService;


    @GetMapping("/reclamos")
    public void obtenerReclamos(){
        List<Reclamo> reclamos = reclamoService.obtenerReclamos();
        System.out.println("reclamos size: "+reclamos.size());
       // return new ResponseEntity<>(reclamos, null, HttpStatus.OK);
    }

    @PostMapping("/insertarReclamo")
    public ResponseEntity<ReclamoDTO> insertarReclamo(ReclamoDTO reclamoDTO){



        return null;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Roles>> obtenerRoles(){
        List<Roles> roles = rolesService.obtenerRoles();
        System.out.println("reclamos size: "+roles.size());
        return new ResponseEntity<>(roles, null, HttpStatus.OK);
    }
}
