package br.com.clara.orcamento.repositories.cliente;


import br.com.clara.orcamento.dto.ClienteDto;
import br.com.clara.orcamento.model.Cliente;

import br.com.clara.orcamento.repositories.filter.ClienteFilter;
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

public class ClienteRepositoryimpl implements ClienteRepositoryQuery {

        @PersistenceContext
        private EntityManager manager;

        @Override
        public Page<ClienteDto> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<ClienteDto> criteria = builder.createQuery(ClienteDto.class);
            Root<Cliente> root = criteria.from(Cliente.class);



            criteria.select(builder.construct(ClienteDto.class

                    ,root.get("nome")
                            ,root.get("endereco")
                            ,root.get("numero")
                    ));


            Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
            criteria.where(predicates);
            criteria.orderBy(builder.asc(root.get("nome")));

            TypedQuery<ClienteDto> query = manager.createQuery(criteria);
            adicionarRestricoesPaginacao(query, pageable);

            return new PageImpl<>(query.getResultList(), pageable, total(clienteFilter));

        }

        private Long total(ClienteFilter clienteFilter) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
            Root<Cliente> root = criteria.from(Cliente.class);

            Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
            criteria.where(predicates);

            criteria.select(builder.count(root));
            return manager.createQuery(criteria).getSingleResult();

        }

        private void adicionarRestricoesPaginacao(TypedQuery<ClienteDto> query, Pageable pageable) {
            int paginaAtual = pageable.getPageNumber();
            int totalRegistrosPorPagina = pageable.getPageSize();
            int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

            query.setFirstResult(primeiroRegistroDaPagina);
            query.setMaxResults(totalRegistrosPorPagina);
        }

        private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(clienteFilter.getNumero())) {
                predicates.add(builder.like(builder.lower(root.get("numero")), "%" + clienteFilter.getNumero().toLowerCase() + "%"));
            }
            return predicates.toArray(new Predicate[predicates.size()]);

        }

        private void adicionarRestricoesDePaginacao
                (TypedQuery<ClienteDto> query, Pageable pageable) {
            int paginaAtual = pageable.getPageNumber();
            ;
            int totalRegistroPorPagina = pageable.getPageSize();
            int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;

            query.setFirstResult(primeiroRegistroDaPagina);
            query.setMaxResults(totalRegistroPorPagina);
        }
}
