package br.com.clara.orcamento.repositories.lancamento;

import br.com.clara.orcamento.dto.LancamentoDto;
import br.com.clara.orcamento.repositories.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {
    public Page<LancamentoDto> filtrar (LancamentoFilter lancamentoFilter, Pageable pageable);
}
