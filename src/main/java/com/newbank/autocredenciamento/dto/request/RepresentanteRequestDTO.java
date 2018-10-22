package com.newbank.autocredenciamento.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepresentanteRequestDTO {

    @ApiModelProperty(notes = "ID do representante. ", example = "1", required = true, position = 1)
    private Long idRepresentante;

    @NotNull(message = "Campo \"nome\" precisa ser informado.")
    @ApiModelProperty(notes = "Nome do representante", example = "José da Silva", required = true, position = 2)
    private String nome;

    @NotNull(message = "Campo \"telefone\" precisa ser informado.")
    @ApiModelProperty(notes = "Telefone do representante", example = "11973141552", required = true, position = 3)
    private String telefone;

    @NotNull(message = "Campo \"sexo\" precisa ser informado.")
    @ApiModelProperty(notes = "Sexo do representante", example = "Masculino", required = true, position = 4)
    private String sexo;

    @NotNull(message = "Campo \"email\" precisa ser informado.")
    @ApiModelProperty(notes = "Email do representante", example = "jose.silva@outlook.com", required = true, position = 5)
    private String email;

    @NotNull(message = "Campo \"empresaId\" precisa ser informado.")
    @ApiModelProperty(notes = "Id da empresa do representante", example = "1", required = true, position = 6)
    private Long empresaId;
}
