package com.newbank.autocredenciamento.repository;

import com.newbank.autocredenciamento.model.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

}
