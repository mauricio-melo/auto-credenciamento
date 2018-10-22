package com.newbank.autocredenciamento.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SociosDTO {
    private Long idSocio;
    private String nome;
    private String tipoPessoa;
    private String cpf;
    private String cnpj;
    private Long empresaId;
}
