package com.github.zlbovolini.jpa.modelo;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.github.zlbovolini.jpa.modelo.TipoMovimentacao.SAIDA;

class MovimentacaoTest {

    @Test
    void deveRealizarMovimentacaoDeEntrada() {
        Conta conta = new Conta(1, 0, "Lucas", BigDecimal.ZERO);
        Movimentacao movimentacao = new Movimentacao(SAIDA, LocalDateTime.now(),
                "Compra de produto realizada", BigDecimal.valueOf(14.99), conta, List.of());


        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.persist(movimentacao);

        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }

}