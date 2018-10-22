package com.newbank.autocredenciamento.model;

import com.newbank.autocredenciamento.model.util.Endereco;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString(of = {"idEmpresa"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresa")
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @Column(nullable = false)
    private String cnpj;

    @Column(name = "rz_social", nullable = false)
    private String razaoSocial;

    @Column(name = "nm_fantasia", nullable = false)
    private String nomeFantasia;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_fundacao", nullable = false)
    private Date dataFundacao;

    @Embedded
    private Endereco endereco;

    @OneToOne(mappedBy = "empresa")
    private RepresentanteEntity representante;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<SociosEntity> socios;
}
