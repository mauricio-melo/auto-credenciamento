package com.newbank.autocredenciamento.service;

import com.newbank.autocredenciamento.dto.RepresentanteDTO;
import com.newbank.autocredenciamento.exception.ResourceNotFoundException;
import com.newbank.autocredenciamento.model.RepresentanteEntity;
import com.newbank.autocredenciamento.repository.RepresentanteRepository;
import com.newbank.autocredenciamento.translate.RepresentanteTranslate;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentanteService {

    @Autowired
    private RepresentanteRepository repository;

    @Autowired
    private RepresentanteTranslate translator;

    @Autowired
    private EmpresaService empresaService;

    // Serviço de criaçao
    public RepresentanteEntity save(@NonNull final RepresentanteDTO dto){

        // Efetuando tradução de DTO para Entity
        RepresentanteEntity entity = translator.toEntity(dto);

        // Setando valores identificadores para a entity;
        entity.setEmpresa(empresaService.findById(dto.getEmpresaId()));

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }

    // Serviço de alteração
    public RepresentanteEntity update(@NonNull final RepresentanteDTO dto){

        // Obtendo a entity pelo id
        RepresentanteEntity entity = findById(dto.getIdRepresentante());

        // Traduzindo DTO para Entity
        entity = translator.toEntity(dto, entity);

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }

    // Serviço de delete por id
    public void delete(Long id){
        repository.deleteById(id);
    }

    // Serviço de encontrar por id
    public RepresentanteEntity findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Representante", "representanteId", id));
    }

    // Serviço de listar todos
    public List<RepresentanteEntity> findAll() {
        return repository.findAll();
    }



}
