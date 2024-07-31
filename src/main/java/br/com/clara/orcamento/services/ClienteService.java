package br.com.clara.orcamento.services;

import br.com.clara.orcamento.model.Cliente;
import br.com.clara.orcamento.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){ return clienteRepository.save(cliente);}
}
