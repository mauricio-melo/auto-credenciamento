package com.newbank.autocredenciamento.translate;

import com.newbank.autocredenciamento.dto.RepresentanteDTO;
import com.newbank.autocredenciamento.dto.request.RepresentanteRequestDTO;
import com.newbank.autocredenciamento.dto.response.RepresentanteResponseDTO;
import com.newbank.autocredenciamento.model.RepresentanteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepresentanteTranslate {
    public RepresentanteDTO toDTO(RepresentanteRequestDTO requestDTO) {
        return RepresentanteDTO.builder()
                .idRepresentante(requestDTO.getIdRepresentante())
                .nome(requestDTO.getNome())
                .telefone(requestDTO.getTelefone())
                .sexo(requestDTO.getSexo())
                .email(requestDTO.getEmail())
                .empresaId(requestDTO.getEmpresaId())
                .build();

    }

    //Traduz o DTO para entity, recebendo o DTO por parametro
    public RepresentanteEntity toEntity(RepresentanteDTO dto) {
        return toEntity(dto, RepresentanteEntity.builder().build());
    }

    //Traduz o DTO para a entity, recebendo um DTO e um entity por parametro
    public RepresentanteEntity toEntity(RepresentanteDTO dto, RepresentanteEntity entity) {

        entity.setIdRepresentante(dto.getIdRepresentante());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setSexo(dto.getSexo());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    //Traduz a entity para a o response
    public RepresentanteResponseDTO toResponse(RepresentanteEntity entity) {
        return RepresentanteResponseDTO.builder()
                .idRepresentante(entity.getIdRepresentante())
                .nome(entity.getNome())
                .telefone(entity.getTelefone())
                .sexo(entity.getSexo())
                .email(entity.getEmail())
                .empresaId(entity.getEmpresa().getIdEmpresa())
                .build();
    }


    //Traduz uma lista de entity para uma lista de response
    public List<RepresentanteResponseDTO> toResponse(List<RepresentanteEntity> entityList) {
        List<RepresentanteResponseDTO> responseDTOList = new ArrayList<RepresentanteResponseDTO>();
        entityList.forEach(
                entity ->
                        responseDTOList.add(toResponse(entity))
        );
        return responseDTOList;
    }
}
