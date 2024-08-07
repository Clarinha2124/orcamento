package br.com.clara.orcamento.controllers;


import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.model.Municipio;
import br.com.clara.orcamento.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;
    @PostMapping()
    public ResponseEntity<Municipio> Inserir (@RequestBody Municipio municipio){
        Municipio municipioSalva=municipioService.salvar(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(municipioSalva);
    }
}
