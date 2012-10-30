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

    private EntityManager em;
    private EntityManagerFactory emf;
    private static QueryManager instance = null;
    
    private QueryManager(){
         emf = Persistence.createEntityManagerFactory("$objectdb/db/ProjectDB.odb");
         em = emf.createEntityManager();
    }

    public static QueryManager getInstance(){
        if(instance == null){
            instance = new QueryManager();
        }
        return instance;        
    }
    
    public User createUser(String username, String password) {
        em.getTransaction().begin();
        User U = new User(username);
        Password P = new Password(username, password);
        em.persist(U);
        em.persist(P);
        em.getTransaction().commit();
        return U;
    }

    public Team createTeam(String name) {
        em.getTransaction().begin();
        Team T = new Team(name);
        em.persist(T);
        em.getTransaction().commit();
        System.out.println("Created Team " + name);
        return T;
    }
    
    public UserStory createUserStory(String name) {
        em.getTransaction().begin();
        UserStory US = new UserStory(name);
        em.persist(US);
        em.getTransaction().commit();
        System.out.println("Created UserStory " + name);
        return US;
    }

    public Project createProject(String name) {
        em.getTransaction().begin();
        Project P = new Project(name);
        em.persist(P);
        em.getTransaction().commit();
        System.out.println("Created Project " + name);
        return P;
    }
    
    public boolean checkPassword(IUser user, String password) {
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
    public User getUser(String name) {
        Query getUserQ = em.createQuery("SELECT U FROM User U WHERE U.name = :qname");
        getUserQ.setParameter("qname", name);
        try{
        User shell = (User) getUserQ.getSingleResult();
        return shell;
        }
        catch(Exception E){ return null;
    }
}
}
