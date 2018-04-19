package com.aginternacional.gestionreclamos.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity()
@Table(name = "reclamo", schema = "public")
@Data
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReclamo")
    @SequenceGenerator(name = "seqReclamo")
    private Long id;
    @Column(name = "usuario_creador",  length = 32)
    private String usuarioCreador;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "reclamo")
    private List<DocumentosReclamo> documentosReclamos;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado")
    private EstadoReclamo estadoReclamo;



}
