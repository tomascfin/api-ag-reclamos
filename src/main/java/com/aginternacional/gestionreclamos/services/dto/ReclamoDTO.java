package com.aginternacional.gestionreclamos.services.dto;

import com.aginternacional.gestionreclamos.domain.Reclamo;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReclamoDTO extends Reclamo{

    private Long id;
    private String colorhexidecimalvalue;
    private String detalle_reclamo;
    private String email_contacto;
    private Integer estado_reclamo;
    private Timestamp fecha_reclamo;
    private String nombre_contacto;
    private String numero_contacto;
    private Integer prioridad;
    private String ruta_archivo;
    private String tipo_reclamo;
    private Integer area;
    private String id_entidad;



}
