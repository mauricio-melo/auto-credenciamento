package com.newbank.autocredenciamento.resource;

import com.newbank.autocredenciamento.dto.SociosDTO;
import com.newbank.autocredenciamento.dto.request.SociosRequestDTO;
import com.newbank.autocredenciamento.dto.response.SociosResponseDTO;
import com.newbank.autocredenciamento.model.Socios;
import com.newbank.autocredenciamento.service.SociosService;
import com.newbank.autocredenciamento.translate.SociosTranslate;
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
@RequestMapping(value = "/api/socio")
@Api(value = "Socio", description = "Operações disponíveis para o recurso socio")
public class SociosResource {

    @Autowired
    private SociosTranslate translator;

    @Autowired
    private SociosService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo recurso socio", responseReference = "Novo recurso criado.")
    public ResponseEntity<Void> create(@Valid @RequestBody SociosRequestDTO requestDTO) {

        // Traduzindo requisição recebida para DTO
        final SociosDTO dto = translator.toDTO(requestDTO);

        // Acionando service create
        final Socios entity = service.save(dto);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{socioId}")
                .buildAndExpand(entity.getIdSocio())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/{socioId}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pesquisa de um recurso socio em específico", response = SociosResponseDTO.class)
    public ResponseEntity<SociosResponseDTO> findById(@PathVariable final Long socioId) {

        //Efetuando busca da entidade na base dados pelo id
        final Socios entity = service.findById(socioId);

        //Traduzindo Entity para Response
        final SociosResponseDTO responseDTO = translator.toResponse(entity);

        //Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos os socios", response = SociosResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<SociosResponseDTO>> list() {

        //Buscando todos os recursos tattoo para Requisição recebida
        final List<Socios> entityList = service.findAll();

        //Traduzindo entity para response
        final List<SociosResponseDTO> responseList = translator.toResponse(entityList);

        //Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("{socioId}")
    public ResponseEntity<Void> delete(@PathVariable final Long socioId) {

        // Acionando service delete
        service.delete(socioId);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }
}
