package com.github.zlbovolini.jpa.modelo;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.github.zlbovolini.jpa.modelo.TipoMovimentacao.SAIDA;

class CategoriaTest {

    @Test
    void deveInserirCategoria() {

        Categoria categoriaLazer = new Categoria("Lazer");
        Categoria categoriaNegocio = new Categoria("Negocio");

        List<Categoria> categoriaList = List.of(categoriaLazer, categoriaNegocio);

        Conta conta = new Conta();
        conta.setId(1L);

        Movimentacao movimentacao = new Movimentacao(SAIDA, LocalDateTime.now(),
                "Compra de produto realizada", BigDecimal.valueOf(14.99), conta, categoriaList);

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(categoriaLazer);
        entityManager.persist(categoriaNegocio);
        entityManager.persist(movimentacao);

        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }

}