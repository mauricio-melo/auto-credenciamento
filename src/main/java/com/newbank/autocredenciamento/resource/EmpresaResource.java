package com.newbank.autocredenciamento.resource;

import com.newbank.autocredenciamento.dto.EmpresaDTO;
import com.newbank.autocredenciamento.dto.request.EmpresaRequestDTO;
import com.newbank.autocredenciamento.dto.response.EmpresaResponseDTO;
import com.newbank.autocredenciamento.model.EmpresaEntity;
import com.newbank.autocredenciamento.service.EmpresaService;
import com.newbank.autocredenciamento.translate.EmpresaTranslate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/empresa")
@Api(value = "Empresa", description = "Operações disponíveis para o recurso empresa")
public class EmpresaResource {

    @Autowired
    private EmpresaTranslate translator;

    @Autowired
    private EmpresaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo recurso empresa", responseReference = "Novo recurso criado.")
    public ResponseEntity<Void> create(@Valid @RequestBody EmpresaRequestDTO requestDTO) {

        // Traduzindo requisição recebida para DTO
        final EmpresaDTO empresaDTO = translator.toDTO(requestDTO);

        // Acionando service create
        final EmpresaEntity entity = service.save(empresaDTO);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{empresaId}")
                .buildAndExpand(entity.getIdEmpresa())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/{empresaId}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pesquisa de um recurso empresa em específico", response = EmpresaResponseDTO.class)
    public ResponseEntity<EmpresaResponseDTO> findById(@PathVariable final Long empresaId) {

        //Efetuando busca da entidade na base dados pelo id
        final EmpresaEntity entity = service.findById(empresaId);

        //Traduzindo Entity para Response
        final EmpresaResponseDTO responseDTO = translator.toResponse(entity);

        //Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos as empresa's", response = EmpresaResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<EmpresaResponseDTO>> list() {

        //Buscando todos os recursos tattoo para Requisição recebida
        final List<EmpresaEntity> entityList = service.findAll();

        //Traduzindo entity para response
        final List<EmpresaResponseDTO> responseList = translator.toResponse(entityList);

        //Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("{empresaId}")
    public ResponseEntity<Void> delete(@PathVariable final Long empresaId) {

        // Acionando service delete
        service.delete(empresaId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }
}

