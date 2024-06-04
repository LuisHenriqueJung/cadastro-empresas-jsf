package com.rsdata.cadastroempresasjsf.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "RAMO_ATIVIDADE")
public class RamoAtividade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO",nullable = false,length = 80)
    private String descricao;


}

