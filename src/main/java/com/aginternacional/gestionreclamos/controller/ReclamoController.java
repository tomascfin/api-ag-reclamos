package com.aginternacional.gestionreclamos.controller;

import com.aginternacional.gestionreclamos.domain.Reclamo;
import com.aginternacional.gestionreclamos.domain.Roles;
import com.aginternacional.gestionreclamos.services.ReclamoService;
import com.aginternacional.gestionreclamos.services.RolesService;
import com.aginternacional.gestionreclamos.services.dto.ReclamoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value="api", description="Servicios para reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @Autowired
    private RolesService rolesService;


    HttpHeaders headers = new HttpHeaders();


    @GetMapping("/reclamos")
    public void obtenerReclamos(){
        List<Reclamo> reclamos = reclamoService.obtenerReclamos();
        System.out.println("reclamos size: "+reclamos.size());
       // return new ResponseEntity<>(reclamos, null, HttpStatus.OK);
    }

    @PostMapping("/insertarReclamo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ha ingresado un reclamo exitosamente"),
            @ApiResponse(code = 401, message = "No esta autorizado para solicitar este servicio"),
            @ApiResponse(code = 403, message = "El acceso al recurso esta en estado forbidden"),
            @ApiResponse(code = 404, message = "No se encuentra el servicio que llamas")
    })
    @ApiOperation(value = "Inserta un reclamo", response = ReclamoDTO.class)
    public ResponseEntity<ReclamoDTO> insertarReclamo(ReclamoDTO reclamoDTO){
        ReclamoDTO reclamo = reclamoService.insertarReclamoDt(reclamoDTO);

        return new ResponseEntity<>(reclamo, null, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Roles>> obtenerRoles(){
        List<Roles> roles = rolesService.obtenerRoles();
        System.out.println("reclamos size: "+roles.size());
        return new ResponseEntity<>(roles, null, HttpStatus.OK);
    }


}
