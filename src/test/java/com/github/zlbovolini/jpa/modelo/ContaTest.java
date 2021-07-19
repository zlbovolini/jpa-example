package com.github.zlbovolini.jpa.modelo;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

class ContaTest {

    @Test
    void deveCriarEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.close();
        managerFactory.close();
    }

    @Test
    void deveCriarConta() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        Conta conta = new Conta(1, 0, "Lucas", BigDecimal.ZERO);

        entityManager.getTransaction().begin();

        entityManager.persist(conta);

        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }

}