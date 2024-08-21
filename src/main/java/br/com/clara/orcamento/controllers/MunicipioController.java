package br.com.clara.orcamento.controllers;


import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.model.Municipio;
import br.com.clara.orcamento.repositories.MunicipioRepository;
import br.com.clara.orcamento.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private MunicipioRepository municipioRepository;

    @GetMapping()
    public List<Municipio> listarTodosMunicipios(){
        return municipioRepository.findAll(Sort.by("nome").ascending());
    }

    @PostMapping()
    public ResponseEntity<Municipio> Inserir (@RequestBody Municipio municipio){
        Municipio municipioSalva=municipioService.salvar(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(municipioSalva);
    }
}
