package br.com.clara.orcamento.services;

import br.com.clara.orcamento.model.Lancamento;
import br.com.clara.orcamento.repositories.LancamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;

   public Lancamento salvar (Lancamento lancamento) { return lancamentoRepository.save(lancamento);
}
    public Lancamento atualizar (Long id, Lancamento lancamento){
        Lancamento lancamentoSalva = buscarLancamentoExistente(id);

        BeanUtils.copyProperties(lancamento, lancamentoSalva, "id");

        return lancamentoRepository.save(lancamentoSalva);
    }

    private Lancamento buscarLancamentoExistente(Long id) {
        Optional<Lancamento> lanacamentoSalva = lancamentoRepository.findById(id);

        if (!lanacamentoSalva.isPresent()){
            throw new IllegalArgumentException();
        }
        return lanacamentoSalva.get();
    }

}
