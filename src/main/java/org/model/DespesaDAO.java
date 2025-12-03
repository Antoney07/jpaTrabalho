package org.model;

import jakarta.persistence.*;
import org.model.Despesa;
import java.util.List;

public class DespesaDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("un.jpa");

    public void salvar(Despesa d) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }

    public List<Despesa> listar() {
        EntityManager em = emf.createEntityManager();
        List<Despesa> lista =
                em.createQuery("SELECT d FROM Despesa d ORDER BY d.id", Despesa.class)
                        .getResultList();
        em.close();
        return lista;
    }

    public void atualizar(Despesa d) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(d);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Despesa d = em.find(Despesa.class, id);
        if (d != null) em.remove(d);
        em.getTransaction().commit();
        em.close();
    }

    public double total() {
        EntityManager em = emf.createEntityManager();
        Double soma = em.createQuery(
                "SELECT SUM(d.valor) FROM Despesa d", Double.class
        ).getSingleResult();
        em.close();
        return soma == null ? 0.0 : soma;
    }
}
