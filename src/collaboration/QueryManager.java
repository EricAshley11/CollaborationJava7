/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import javax.persistence.*;
import java.util.*;

/**
 * This is a class that helps save to the DB
 */
class QueryManager {
    // Open a database connection
    // (create a new database if it doesn't exist yet):
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/ProjectDB.odb");
    EntityManager em = emf.createEntityManager();

    private void createUser(String username, String password) {
        em.getTransaction().begin();
        User U = new User(username);
        Password P = new Password(username, password);
        em.persist(U);
        em.persist(P);
        em.getTransaction().commit();
        System.out.println("Created User " + username);
    }

    private void createTeam(String name) {
        em.getTransaction().begin();
        Team T = new Team(name);
        em.persist(T);
        em.getTransaction().commit();
        System.out.println("Created Team " + name);
    }

    private void createProject(String name) {
        em.getTransaction().begin();
        Project P = new Project(name);
        em.persist(P);
        em.getTransaction().commit();
        System.out.println("Created Project " + name);
    }
}
