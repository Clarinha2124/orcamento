package br.com.clara.orcamento.repositories.lancamento;

import br.com.clara.orcamento.dto.LancamentoDto;
import br.com.clara.orcamento.model.Lancamento;
import br.com.clara.orcamento.repositories.filter.LancamentoFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class LancamentoRepositoryimpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<LancamentoDto> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<LancamentoDto> criteria = builder.createQuery(LancamentoDto.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        criteria.select(builder.construct(LancamentoDto.class
                , root.get("datalancamento")
                , root.get("tipolancamento")
                , root.get("id")
                , root.get("valorlancamento")));





        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        TypedQuery<LancamentoDto> query = manager.createQuery(criteria);
        adicionarRestricoesPaginacao(query, pageable);



        return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));

    }

    private Long total(LancamentoFilter lancamentoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder,root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();

    }

    private void adicionarRestricoesPaginacao(TypedQuery<LancamentoDto> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder, Root<Lancamento> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(lancamentoFilter.getTipolancamento())) {
            predicates.add(builder.like(builder.lower(root.get("numero")), "%" + lancamentoFilter.getTipolancamento().toLowerCase() + "%"));
        }
        return predicates.toArray(new Predicate[predicates.size()]);

    }

    private void adicionarRestricoesDePaginacao
            (TypedQuery<LancamentoDto> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        ;
        int totalRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistroPorPagina);
    }
}
