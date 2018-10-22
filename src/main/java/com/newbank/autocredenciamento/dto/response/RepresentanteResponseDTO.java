package com.newbank.autocredenciamento.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RepresentanteResponseDTO {

    @ApiModelProperty(notes = "ID do representante. ", example = "1", required = true, position = 1)
    private Long idRepresentante;

    @ApiModelProperty(notes = "Nome do representante", example = "José da Silva", required = true, position = 2)
    private String nome;

    @ApiModelProperty(notes = "Telefone do representante", example = "11973141552", required = true, position = 3)
    private String telefone;

    @ApiModelProperty(notes = "Sexo do representante", example = "Masculino", required = true, position = 4)
    private String sexo;

    @ApiModelProperty(notes = "Email do representante", example = "jose.silva@outlook.com", required = true, position = 5)
    private String email;

    @ApiModelProperty(notes = "Id da empresa do representante", example = "1", required = true, position = 6)
    private Long empresaId;
}
