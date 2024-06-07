package com.rsdata.cadastroempresasjsf.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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

    @NotEmpty
    @Column(name = "NOME_FANTASIA", nullable = false, length = 80)
    private String nomeFantasia;

    @NotEmpty
    @Column(name = "RAZAO_SOCIAL", nullable = false, length = 120)
    private String razaoSocial;

    @CNPJ
    @NotNull
    @Column(name = "CNPJ", nullable = false, length = 18)
    private String cnpj;

    @Past
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_FUNDACAO")
    private Date dataFundacao;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RAMO_ATIVIDADE_ID", nullable = false)
    private RamoAtividade ramoAtividade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoEmpresa tipo;

}
