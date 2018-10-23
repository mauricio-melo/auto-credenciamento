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

    @MapsId
    @OneToOne
    @JoinColumn(name="id_empresa")
    private EmpresaEntity empresa;

}

