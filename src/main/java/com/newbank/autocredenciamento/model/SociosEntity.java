package com.newbank.autocredenciamento.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(of = {"idSocio"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "socios")
public class SociosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSocio;

    @Column(nullable = false)
    private String nome;

    @Column(name = "tipo_pessoa", nullable = false)
    private String tipoPessoa;

    private String identidade;

    @ManyToOne
    @JoinColumn(name="id_empresa")
    private EmpresaEntity empresa;

}

