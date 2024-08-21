package br.com.clara.orcamento.controllers;


import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.model.Lancamento;
import br.com.clara.orcamento.model.Municipio;
import br.com.clara.orcamento.repositories.LancamentoRepository;
import br.com.clara.orcamento.services.LancamentoService;
import br.com.clara.orcamento.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping()
    public List<Lancamento> listarTodosLancamentos(){
        return lancamentoRepository.findAll(Sort.by("tipolancamento").ascending());
    }

    @PostMapping
    public ResponseEntity<Lancamento> Inserir (@RequestBody Lancamento lancamento){

        Lancamento lancamentoSalva=lancamentoService.salvar(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);
    }
}
