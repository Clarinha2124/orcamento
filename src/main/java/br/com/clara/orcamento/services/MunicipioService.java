package br.com.clara.orcamento.services;

import br.com.clara.orcamento.model.Municipio;
import br.com.clara.orcamento.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

  public Municipio salvar (Municipio municipio){ return municipioRepository.save(municipio);}

}
