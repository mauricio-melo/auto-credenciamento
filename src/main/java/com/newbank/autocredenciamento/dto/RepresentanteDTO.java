package com.newbank.autocredenciamento.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RepresentanteDTO {
    private Long idRepresentante;
    private String nome;
    private String telefone;
    private String sexo;
    private String email;
    private Long empresaId;
}
