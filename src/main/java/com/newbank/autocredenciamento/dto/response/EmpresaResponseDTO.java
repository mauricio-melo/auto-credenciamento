package com.newbank.autocredenciamento.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmpresaResponseDTO {

    @ApiModelProperty(notes = "ID da empresa. ", example = "1", required = true, position = 1)
    private Long idEmpresa;

    @ApiModelProperty(notes = "CNPJ do cliente.", example = "23.555.432/0001-64", required = true, position = 2)
    private String cnpj;

    @ApiModelProperty(notes = "Razão social do cliente.", example = "Itau Ltda", required = true, position = 3)
    private String razaoSocial;

    @ApiModelProperty(notes = "Nome fantasia do cliente.", example = "Itau", required = true, position = 4)
    private String nomeFantasia;

    @ApiModelProperty(notes = "Data de fundação do cliente.", example = "1968-09-15", required = true, position = 5)
    private Date dataFundacao;

    @ApiModelProperty(notes = "CEP do cliente.", example = "04856-287", required = true, position = 6)
    private String cep;

    @ApiModelProperty(notes = "Logradouro do cliente.", example = "Rua Joaquim Floriano, 245", required = true, position = 7)
    private String logradouro;

    @ApiModelProperty(notes = "Bairro do cliente.", example = "Itaim Bibi", required = true, position = 9)
    private String bairro;

    @ApiModelProperty(notes = "Cidade do cliente.", example = "SP", required = true, position = 10)
    private String cidade;

    @ApiModelProperty(notes = "Estado do cliente.", example = "São Paulo", required = true, position = 11)
    private String estado;
}
