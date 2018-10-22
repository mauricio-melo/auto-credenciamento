package com.newbank.autocredenciamento.translate;

import com.newbank.autocredenciamento.dto.EmpresaDTO;
import com.newbank.autocredenciamento.dto.request.EmpresaRequestDTO;
import com.newbank.autocredenciamento.dto.response.EmpresaResponseDTO;
import com.newbank.autocredenciamento.model.EmpresaEntity;
import com.newbank.autocredenciamento.model.util.Endereco;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpresaTranslate {


    public EmpresaDTO toDTO(EmpresaRequestDTO requestDTO) {
        return EmpresaDTO.builder()
                .idEmpresa(requestDTO.getIdEmpresa())
                .cnpj(requestDTO.getCnpj())
                .razaoSocial(requestDTO.getRazaoSocial())
                .nomeFantasia(requestDTO.getNomeFantasia())
                .dataFundacao(requestDTO.getDataFundacao())
                .cep(requestDTO.getCep())
                .logradouro(requestDTO.getLogradouro())
                .bairro(requestDTO.getBairro())
                .cidade(requestDTO.getCidade())
                .estado(requestDTO.getEstado())
                .build();
    }

    //Traduz o DTO para entity, recebendo o DTO por parametro
    public EmpresaEntity toEntity(EmpresaDTO dto) {
        return toEntity(dto, EmpresaEntity.builder().build());
    }

    //Traduz o DTO para a entity, recebendo um DTO e um entity por parametro
    public EmpresaEntity toEntity(EmpresaDTO dto, EmpresaEntity entity) {

        Endereco endereco = Endereco.builder()
                .cep(dto.getCep())
                .logradouro(dto.getLogradouro())
                .bairro(dto.getBairro())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .build();

        entity.setIdEmpresa(dto.getIdEmpresa());
        entity.setCnpj(dto.getCnpj());
        entity.setRazaoSocial(dto.getRazaoSocial());
        entity.setNomeFantasia(dto.getNomeFantasia());
        entity.setDataFundacao(dto.getDataFundacao());
        entity.setEndereco(endereco);

        return entity;
    }

    //Traduz a entity para a o response
    public EmpresaResponseDTO toResponse(EmpresaEntity entity) {
        return EmpresaResponseDTO.builder()
                .idEmpresa(entity.getIdEmpresa())
                .cnpj(entity.getCnpj())
                .razaoSocial(entity.getRazaoSocial())
                .nomeFantasia(entity.getNomeFantasia())
                .dataFundacao(entity.getDataFundacao())
                .cep(entity.getEndereco().getCep())
                .logradouro(entity.getEndereco().getLogradouro())
                .bairro(entity.getEndereco().getBairro())
                .cidade(entity.getEndereco().getCidade())
                .estado(entity.getEndereco().getEstado())
                .build();
    }


    //Traduz uma lista de entity para uma lista de response
    public List<EmpresaResponseDTO> toResponse(List<EmpresaEntity> entityList) {
        List<EmpresaResponseDTO> responseDTOList = new ArrayList<EmpresaResponseDTO>();
        entityList.forEach(
                empresaEntity ->
                        responseDTOList.add(toResponse(empresaEntity))
        );
        return responseDTOList;
    }
}