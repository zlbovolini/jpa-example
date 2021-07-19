package com.github.zlbovolini.jpa.modelo;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Objects;

class ClienteTest {

    @Test
    void deveInserirCliente() {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Conta conta = entityManager.find(Conta.class, 1L);

        if (Objects.isNull(conta)) {
            conta = new Conta(1, 0, "Lucas", BigDecimal.ZERO);
            entityManager.persist(conta);
        }

        Cliente cliente = new Cliente("Lucas", conta);

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }

}