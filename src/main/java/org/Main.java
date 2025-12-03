package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.model.Despesa;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("un.jpa");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Despesa d = new Despesa();
        d.setDescricao("Teste1");
        d.setValor(50);
        d.setCategoria("Comida");
        d.setData(LocalDate.now());

        em.persist(d);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
