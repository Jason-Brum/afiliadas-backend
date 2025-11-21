package com.globo.afiliadas.repository;

import com.globo.afiliadas.model.ProjetoVigencia;
import com.globo.afiliadas.model.ProjetoVigenciaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoVigenciaRepository extends JpaRepository<ProjetoVigencia, ProjetoVigenciaId> {
}