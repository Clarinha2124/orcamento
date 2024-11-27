package br.com.clara.orcamento.repositories;

import br.com.clara.orcamento.model.Municipio;
import br.com.clara.orcamento.repositories.filter.MunicipioFilter;
import br.com.clara.orcamento.repositories.municipio.MunicipioRepositoryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>, MunicipioRepositoryQuery {




}



