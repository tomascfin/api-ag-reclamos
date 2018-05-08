package com.aginternacional.gestionreclamos.services.dto;

import com.aginternacional.gestionreclamos.domain.DocumentosReclamo;
import com.aginternacional.gestionreclamos.domain.EstadoReclamo;
import com.aginternacional.gestionreclamos.domain.Reclamo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Data
public class ReclamoDTO {

    @NotNull
    private Long id;
    private String usuarioCreador;
    private Timestamp created_at;
    private String descripcion;
    private List<DocumentosReclamo> documentosReclamos;
    private EstadoReclamo estadoReclamo;







}
