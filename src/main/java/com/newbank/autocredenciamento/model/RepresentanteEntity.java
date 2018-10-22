package com.newbank.autocredenciamento.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString(of = {"idRepresentante"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "representante")
public class RepresentanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepresentante;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name="empresa_id")
    private EmpresaEntity empresa;

}

