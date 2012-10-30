/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IUser;
import java.rmi.RemoteException;
import javax.persistence.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a class that helps save to the DB
 */
class QueryManager {
    // Open a database connection
    // (create a new database if it doesn't exist yet):

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/ProjectDB.odb");
    EntityManager em = emf.createEntityManager();

    private User createUser(String username, String password) {
        em.getTransaction().begin();
        User U = new User(username);
        Password P = new Password(username, password);
        em.persist(U);
        em.persist(P);
        em.getTransaction().commit();
        return U;
    }

    private Team createTeam(String name) {
        em.getTransaction().begin();
        Team T = new Team(name);
        em.persist(T);
        em.getTransaction().commit();
        System.out.println("Created Team " + name);
        return T;
    }
    
    private UserStory createUserStory(String name) {
        em.getTransaction().begin();
        UserStory US = new UserStory(name);
        em.persist(US);
        em.getTransaction().commit();
        System.out.println("Created UserStory " + name);
        return US;
    }

    private Project createProject(String name) {
        em.getTransaction().begin();
        Project P = new Project(name);
        em.persist(P);
        em.getTransaction().commit();
        System.out.println("Created Project " + name);
        return P;
    }
    
    private boolean checkPassword(IUser user, String password) {
        Query createUserQ = em.createQuery("SELECT U.name FROM User U, Password P WHERE P.Username = U.name");
          if(createUserQ.getResultList().isEmpty()==true) {
              em.close();
              emf.close();
              return false;
          }
          else {
           em.close();
           emf.close();
           return true;
          }
    }
}
