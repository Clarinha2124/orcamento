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
import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<Municipio> buscarPeloCodigo(@PathVariable Long id){
        Optional<Municipio> municipio = municipioRepository.findById(id);
        return municipio.isPresent() ? ResponseEntity.ok(municipio.get()): ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        municipioRepository.deleteById(id);
    }
    @PostMapping()
    public ResponseEntity<Municipio> Inserir (@RequestBody Municipio municipio){
        Municipio municipioSalva=municipioService.salvar(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(municipioSalva);
    }
}
