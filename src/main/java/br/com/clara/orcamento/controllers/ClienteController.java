package br.com.clara.orcamento.controllers;

import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.model.Municipio;
import br.com.clara.orcamento.services.ClienteService;
import br.com.clara.orcamento.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<Cliente> Inserir (@RequestBody Cliente cliente){
        Cliente clienteSalva=clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);

    }
}
