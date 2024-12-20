package br.com.clara.orcamento.repositories.cliente;
import br.com.clara.orcamento.dto.ClienteDto;
import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.repositories.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClienteRepositoryQuery {
    public Page<ClienteDto> filtrar (ClienteFilter clienteFilter, Pageable pageable);
}
