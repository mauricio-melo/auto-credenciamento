package com.newbank.autocredenciamento.resource;

import com.newbank.autocredenciamento.dto.EmpresaDTO;
import com.newbank.autocredenciamento.dto.request.EmpresaRequestDTO;
import com.newbank.autocredenciamento.model.EmpresaEntity;
import com.newbank.autocredenciamento.service.EmpresaService;
import com.newbank.autocredenciamento.translate.EmpresaTranslate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;

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
}

