package com.rsdata.cadastroempresasjsf.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_FANTASIA",nullable = false,length = 80)
    private String nomeFantasia;

    @Column(name = "RAZAO_SOCIAL", nullable = false, length = 120)
    private String razaoSocial;

    @Column(name = "CNPJ", nullable = false, length = 18)
    private String cnpj;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_FUNDACAO")
    private Date dataFundacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RAMO_ATIVIDADE_ID", nullable = false)
    private RamoAtividade ramoAtividade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoEmpresa tipo;

}
