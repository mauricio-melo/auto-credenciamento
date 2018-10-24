package com.newbank.autocredenciamento.repository;

import com.newbank.autocredenciamento.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
