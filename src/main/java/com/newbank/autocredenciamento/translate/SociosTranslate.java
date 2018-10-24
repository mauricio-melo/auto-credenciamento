package com.newbank.autocredenciamento.translate;

import com.newbank.autocredenciamento.dto.SociosDTO;
import com.newbank.autocredenciamento.dto.request.SociosRequestDTO;
import com.newbank.autocredenciamento.dto.response.SociosResponseDTO;
import com.newbank.autocredenciamento.model.Socios;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SociosTranslate {
    public SociosDTO toDTO(SociosRequestDTO requestDTO){
        return SociosDTO.builder()
                .idSocio(requestDTO.getIdSocio())
                .nome(requestDTO.getNome())
                .tipoPessoa(requestDTO.getTipoPessoa())
                .identidade(requestDTO.getIdentidade())
                .empresaId(requestDTO.getEmpresaId())
                .build();
    }

    //Traduz o DTO para entity, recebendo o DTO por parametro
    public Socios toEntity(SociosDTO dto) {
        return toEntity(dto, Socios.builder().build());
    }

    //Traduz o DTO para a entity, recebendo um DTO e um entity por parametro
    public Socios toEntity(SociosDTO dto, Socios entity) {

        entity.setIdSocio(dto.getIdSocio());
        entity.setNome(dto.getNome());
        entity.setTipoPessoa(dto.getTipoPessoa());
        entity.setIdentidade(dto.getIdentidade());

        return entity;
    }

    //Traduz a entity para a o response
    public SociosResponseDTO toResponse(Socios entity) {
        return SociosResponseDTO.builder()
                .idSocio(entity.getIdSocio())
                .nome(entity.getNome())
                .tipoPessoa(entity.getTipoPessoa())
                .identidade(entity.getIdentidade())
                .empresaId(entity.getEmpresa().getIdEmpresa())
                .build();
    }


    //Traduz uma lista de entity para uma lista de response
    public List<SociosResponseDTO> toResponse(List<Socios> entityList) {
        List<SociosResponseDTO> responseDTOList = new ArrayList<SociosResponseDTO>();
        entityList.forEach(
                entity ->
                        responseDTOList.add(toResponse(entity))
        );
        return responseDTOList;
    }
}
