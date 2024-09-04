package br.com.clara.orcamento.repositories;

import br.com.clara.orcamento.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

}



