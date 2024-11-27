package br.com.clara.orcamento.controllers;

import br.com.clara.orcamento.dto.ClienteDto;
import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.repositories.ClienteRepository;
import br.com.clara.orcamento.services.ClienteService;
import br.com.clara.orcamento.repositories.filter.ClienteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

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
    public Page<ClienteDto> pesquisar(ClienteFilter clienteFilter, Pageable pageable){
        return clienteRepository.filtrar(clienteFilter, pageable);
    }
    @GetMapping("/todas")
    public List<Cliente>listarTodosClientes(){
        return clienteRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();
    }
    @PostMapping()
    public ResponseEntity<Cliente> Inserir(@RequestBody Cliente cliente){
        Cliente categoriaSalva= clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }
    @PutMapping("/id")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteSalva = clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(clienteSalva);
    }


}





