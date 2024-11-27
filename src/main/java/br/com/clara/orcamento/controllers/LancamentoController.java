package br.com.clara.orcamento.controllers;



import br.com.clara.orcamento.dto.LancamentoDto;
import br.com.clara.orcamento.model.Lancamento;

import br.com.clara.orcamento.repositories.LancamentoRepository;
import br.com.clara.orcamento.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import br.com.clara.orcamento.repositories.filter.LancamentoFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private LancamentoRepository lancamentoRepository;
    @GetMapping()
    public Page<LancamentoDto> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable){
        return lancamentoRepository.filtrar(lancamentoFilter, pageable);
    }
    @GetMapping("/todas")
    public List<Lancamento> listarTodosLancamentos(){
        return lancamentoRepository.findAll(Sort.by("tipolancamento").ascending());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long id){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        return lancamento.isPresent() ? ResponseEntity.ok(lancamento.get()): ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Lancamento> Inserir (@RequestBody Lancamento lancamento){

        Lancamento lancamentoSalva=lancamentoService.salvar(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        lancamentoRepository.deleteById(id);
    }

    @PutMapping("/id")
    public ResponseEntity<Lancamento> atualizar(@PathVariable Long id, @RequestBody Lancamento lancamento) {
       Lancamento lancamentoSalva = lancamentoService.atualizar(id, lancamento);
        return ResponseEntity.ok(lancamentoSalva);
    }

}
