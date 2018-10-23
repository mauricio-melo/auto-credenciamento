package com.newbank.autocredenciamento.resource;

import com.newbank.autocredenciamento.dto.RepresentanteDTO;
import com.newbank.autocredenciamento.dto.request.RepresentanteRequestDTO;
import com.newbank.autocredenciamento.dto.response.RepresentanteResponseDTO;
import com.newbank.autocredenciamento.model.RepresentanteEntity;
import com.newbank.autocredenciamento.service.RepresentanteService;
import com.newbank.autocredenciamento.translate.RepresentanteTranslate;
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
@RequestMapping(value = "/api/representante")
@Api(value = "Empresa", description = "Operações disponíveis para o recurso representante")
public class RepresentanteResource {

    @Autowired
    private RepresentanteTranslate translator;

    @Autowired
    private RepresentanteService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo recurso representante", responseReference = "Novo recurso criado.")
    public ResponseEntity<Void> create(@Valid @RequestBody RepresentanteRequestDTO requestDTO) {

        // Traduzindo requisição recebida para DTO
        final RepresentanteDTO dto = translator.toDTO(requestDTO);

        // Acionando service create
        final RepresentanteEntity entity = service.save(dto);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{representanteId}")
                .buildAndExpand(entity.getIdRepresentante())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/{representanteId}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pesquisa de um recurso representante em específico", response = RepresentanteResponseDTO.class)
    public ResponseEntity<RepresentanteResponseDTO> findById(@PathVariable final Long representanteId) {

        //Efetuando busca da entidade na base dados pelo id
        final RepresentanteEntity entity = service.findById(representanteId);

        //Traduzindo Entity para Response
        final RepresentanteResponseDTO responseDTO = translator.toResponse(entity);

        //Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos os representantes", response = RepresentanteResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<RepresentanteResponseDTO>> list() {

        //Buscando todos os recursos tattoo para Requisição recebida
        final List<RepresentanteEntity> entityList = service.findAll();

        //Traduzindo entity para response
        final List<RepresentanteResponseDTO> responseList = translator.toResponse(entityList);

        //Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("{representanteId}")
    public ResponseEntity<Void> delete(@PathVariable final Long representanteId) {

        // Acionando service delete
        service.delete(representanteId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }
}
