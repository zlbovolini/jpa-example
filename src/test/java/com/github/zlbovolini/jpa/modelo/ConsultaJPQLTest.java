package com.github.zlbovolini.jpa.modelo;

import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;

public class ConsultaJPQLTest {

    @Test
    void deveRetornarMovimentacoesDaConta() {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        //String jpql = "SELECT m FROM Movimentacao m WHERE m.conta.id = 1";
        String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :conta";

        Conta conta = new Conta(1L);

        Query query = entityManager.createQuery(jpql);
        query.setParameter("conta", conta);

        List<Movimentacao> movimentacaoList = (List<Movimentacao>) query.getResultList();

        for (Movimentacao movimentacao : movimentacaoList) {
            System.out.println(movimentacao.getDescricao());
        }
    }

    @Test
    void deveRetornarMovimentacoesDaContaTyped() {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        //String jpql = "SELECT m FROM Movimentacao m WHERE m.conta.id = 1";
        String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :conta";

        Conta conta = new Conta(1L);

        TypedQuery<Movimentacao> query = entityManager.createQuery(jpql, Movimentacao.class);
        query.setParameter("conta", conta);

        List<Movimentacao> movimentacaoList = query.getResultList();

        for (Movimentacao movimentacao : movimentacaoList) {
            System.out.println(movimentacao.getDescricao());
        }
    }

    @Test
    void deveRetornarMovimentacoesDaContaComCategoriasTyped() {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        String jpql = "SELECT m FROM Movimentacao m JOIN m.categorias c WHERE c = :categoria";

        Categoria categoria = new Categoria(1L);

        TypedQuery<Movimentacao> query = entityManager.createQuery(jpql, Movimentacao.class);
        query.setParameter("categoria", categoria);

        List<Movimentacao> movimentacaoList = query.getResultList();

        for (Movimentacao movimentacao : movimentacaoList) {
            System.out.println(movimentacao.getDescricao());
        }
    }
}
