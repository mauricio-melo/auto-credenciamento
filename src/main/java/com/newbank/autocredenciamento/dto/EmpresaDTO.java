package com.newbank.autocredenciamento.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class EmpresaDTO {
    private Long idEmpresa;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private Date dataFundacao;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}

