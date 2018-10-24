package com.newbank.autocredenciamento.service;

import com.newbank.autocredenciamento.dto.EmpresaDTO;
import com.newbank.autocredenciamento.exception.ResourceNotFoundException;
import com.newbank.autocredenciamento.model.Empresa;
import com.newbank.autocredenciamento.repository.EmpresaRepository;
import com.newbank.autocredenciamento.translate.EmpresaTranslate;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private EmpresaTranslate translator;

    // Serviço de criaçao
    public Empresa save(@NonNull final EmpresaDTO dto){

        // Tradução de DTO para Entity
        Empresa entity = translator.toEntity(dto);

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }

    // Serviço de alteração
    public Empresa update(@NonNull final EmpresaDTO dto) {

        // Obtendo a entity pelo id
        Empresa entity = findById(dto.getIdEmpresa());

        // Traduzindo DTO para Entity
        entity = translator.toEntity(dto, entity);

        // Salvando
        entity = repository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Empresa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa", "empresaId", id));
    }

    public List<Empresa> findAll() {
        return repository.findAll();
    }

}
