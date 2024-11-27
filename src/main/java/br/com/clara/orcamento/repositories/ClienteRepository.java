package br.com.clara.orcamento.repositories;

import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.repositories.cliente.ClienteRepositoryQuery;
import br.com.clara.orcamento.repositories.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {

}
