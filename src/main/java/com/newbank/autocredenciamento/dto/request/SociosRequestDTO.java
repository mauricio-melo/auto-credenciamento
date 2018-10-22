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
public class SociosRequestDTO {

    @ApiModelProperty(notes = "ID do socio. ", example = "1", required = true, position = 1)
    private Long idSocio;

    @NotNull(message = "Campo \"nome\" precisa ser informado.")
    @ApiModelProperty(notes = "Nome do socio.", example = "Jose Santos", required = true, position = 2)
    private String nome;

    @NotNull(message = "Campo \"nome\" precisa ser informado.")
    @ApiModelProperty(notes = "Tipo de pessoa do socio.", example = "Fisica", required = true, position =3)
    private String tipoPessoa;

    @ApiModelProperty(notes = "CNPJ do socio.", example = "23.555.432/0001-64", required = true, position = 4)
    private String cnpj;

    @ApiModelProperty(notes = "CPF do socio.", example = "715.888.471-60", required = true, position = 5)
    private String cpf;

    @NotNull(message = "Campo \"empresaId\" precisa ser informado.")
    @ApiModelProperty(notes = "Id da empresa do socio.", example = "1", required = true, position = 6)
    private Long empresaId;
}
