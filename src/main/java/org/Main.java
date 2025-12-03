package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.model.Usuario;
public class Main {

public static void main(String[] args){
    EntityManagerFactory enf = Persistence.createEntityManagerFactory("un.jpa");
    EntityManager em = enf.createEntityManager();
    em.getTransaction().begin();
    Usuario usuario = new Usuario();
    usuario.setNome("Antoney");
    usuario.setEmail("antonygabrielmor@gmail.com");
    usuario.setSenha("300107");
    em.persist(usuario);
    em.getTransaction().commit();
    em.close();

}}