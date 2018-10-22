package com.newbank.autocredenciamento.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequestDTO {

    @ApiModelProperty(notes = "ID da empresa. ", example = "1", required = true, position = 1)
    private Long idEmpresa;

    @NotNull(message = "Campo \"cnpj\" precisa ser informado.")
    @ApiModelProperty(notes = "CNPJ do cliente.", example = "23.555.432/0001-64", required = true, position = 2)
    private String cnpj;

    @NotNull(message = "Campo \"razaoSocial\" precisa ser informado.")
    @ApiModelProperty(notes = "Razão social do cliente.", example = "Itau Ltda", required = true, position = 3)
    private String razaoSocial;

    @NotNull(message = "Campo \"nomeFantasia\" precisa ser informado.")
    @ApiModelProperty(notes = "Nome fantasia do cliente.", example = "Itau", required = true, position = 4)
    private String nomeFantasia;

    @NotNull(message = "Campo \"dataFundacao\" precisa ser informado.")
    @ApiModelProperty(notes = "Data de fundação do cliente.", example = "1968-09-15", required = true, position = 5)
    private Date dataFundacao;

    @NotNull(message = "Campo \"cep\" precisa ser informado.")
    @ApiModelProperty(notes = "CEP do cliente.", example = "04856-287", required = true, position = 6)
    private String cep;

    @NotNull(message = "Campo \"logradouro\" precisa ser informado.")
    @ApiModelProperty(notes = "Logradouro do cliente.", example = "Rua Joaquim Floriano, 245", required = true, position = 7)
    private String logradouro;

    @NotNull(message = "Campo \"bairro\" precisa ser informado.")
    @ApiModelProperty(notes = "Bairro do cliente.", example = "Itaim Bibi", required = true, position = 9)
    private String bairro;

    @NotNull(message = "Campo \"cidade\" precisa ser informado.")
    @ApiModelProperty(notes = "Cidade do cliente.", example = "SP", required = true, position = 10)
    private String cidade;

    @NotNull(message = "Campo \"estado\" precisa ser informado.")
    @ApiModelProperty(notes = "Estado do cliente.", example = "São Paulo", required = true, position = 11)
    private String estado;
}
