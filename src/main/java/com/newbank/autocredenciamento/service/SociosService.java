package com.newbank.autocredenciamento.service;

import com.newbank.autocredenciamento.dto.SociosDTO;
import com.newbank.autocredenciamento.exception.ResourceNotFoundException;
import com.newbank.autocredenciamento.model.Socios;
import com.newbank.autocredenciamento.repository.SociosRepository;
import com.newbank.autocredenciamento.translate.SociosTranslate;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SociosService {

    @Autowired
    private SociosRepository repository;

    @Autowired
    private SociosTranslate translator;

    @Autowired
    private EmpresaService empresaService;

    // Serviço de criaçao
    public Socios save(@NonNull final SociosDTO dto){

        // Efetuando tradução de DTO para Entity
        Socios entity = translator.toEntity(dto);

        // Setando valores identificadores para a entity;
        entity.setEmpresa(empresaService.findById(dto.getEmpresaId()));

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }

    // Serviço de alteração
    public Socios update(@NonNull final SociosDTO dto){

        // Obtendo a entity pelo id
        Socios entity = findById(dto.getIdSocio());

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
    public Socios findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Socio", "idSocio", id));
    }

    // Serviço de listar todos
    public List<Socios> findAll() {
        return repository.findAll();
    }


}
