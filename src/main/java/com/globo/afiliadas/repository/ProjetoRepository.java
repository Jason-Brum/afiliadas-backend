package com.globo.afiliadas.repository;

import com.globo.afiliadas.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor; // Importante
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>, JpaSpecificationExecutor<Projeto> {
}