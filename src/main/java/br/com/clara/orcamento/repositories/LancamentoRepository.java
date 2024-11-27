package br.com.clara.orcamento.repositories;

import br.com.clara.orcamento.model.Lancamento;
import br.com.clara.orcamento.repositories.filter.LancamentoFilter;
import br.com.clara.orcamento.repositories.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> , LancamentoRepositoryQuery {

}
