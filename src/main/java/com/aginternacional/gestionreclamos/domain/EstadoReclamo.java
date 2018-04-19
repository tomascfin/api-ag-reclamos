package com.aginternacional.gestionreclamos.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "estado_reclamo", schema = "public")
@Data
public class EstadoReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEstadoReclamo")
    @SequenceGenerator(name = "seqEstadoReclamo")
    private Long id;
    @OneToMany(mappedBy = "estadoReclamo")
    private List<Reclamo> reclamos;
}
