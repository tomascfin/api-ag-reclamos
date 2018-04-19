package com.aginternacional.gestionreclamos.domain;


import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name = "documentos_reclamo", schema = "public")
@Data
public class DocumentosReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDocumentosReclamo")
    @SequenceGenerator(name = "seqDocumentosReclamo")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Reclamo reclamo;


}
