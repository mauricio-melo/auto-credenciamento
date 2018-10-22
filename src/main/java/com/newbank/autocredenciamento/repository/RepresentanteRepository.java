package com.newbank.autocredenciamento.repository;

import com.newbank.autocredenciamento.model.RepresentanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentanteRepository  extends JpaRepository<RepresentanteEntity, Long> {

}