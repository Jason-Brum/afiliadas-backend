package com.globo.afiliadas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globo.afiliadas.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    // Busca lançamentos por afiliada
    List<Lancamento> findByAfiliadaId(Long afiliadaId);

    // Busca lançamentos por categoria (tabela TAFILNCCAT0)
    List<Lancamento> findByCategoria_Id(Integer categoriaId);

    // Busca lançamentos por tipo de lançamento (tabela TAFILNCTPO0)
    List<Lancamento> findByTipoLancamento_Id(Integer tipoLancamentoId);

    // Busca lançamentos por tipo E/S (coluna CT_TIPO)
    List<Lancamento> findByTipo(String tipo);

    // Busca lançamentos por status de faturamento (coluna CT_STATUS_FATURAMENTO)
    List<Lancamento> findByStatusFaturamento(String statusFaturamento);
}
