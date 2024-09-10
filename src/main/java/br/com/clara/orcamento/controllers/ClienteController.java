package br.com.clara.orcamento.controllers;

import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.model.Lancamento;
import br.com.clara.orcamento.model.Municipio;
import br.com.clara.orcamento.repositories.ClienteRepository;
import br.com.clara.orcamento.services.ClienteService;
import br.com.clara.orcamento.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping()
    public List<Cliente>listarTodosClientes(){
        return clienteRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }
    @PostMapping()
    public ResponseEntity<Cliente> Inserir (@RequestBody Cliente cliente){
        Cliente clienteSalva=clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);

    }
}
