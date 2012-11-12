/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;
import collaborationjava7.common.*;
import javax.persistence.*;

/**
 * This is a class that helps save to the DB
 */
public class QueryManager {
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
        System.out.println("Created Project " + name+", id: "+P.getID());
        return P;
    }
    
    public boolean checkPassword(IUserResource user, String password) {
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
    private <T> T getByID(long id, Class<T> type){
        String qText = "SELECT T FROM "+type.getSimpleName()+ " T WHERE T.id = "+id;
        TypedQuery<T> q = em.createQuery(qText, type);
        return q.getSingleResult();
    }
    
    public Project getProjectByID(long id){
        return getByID(id, Project.class);
    }
    public User getUserByID(long id){
        return getByID(id, User.class);
    }
    public UserStory getUserStoryByID(long id){
        return getByID(id, UserStory.class);
    }
    public Schedule getScheduleByID(long id){
        return getByID(id, Schedule.class);
    }
    public Team getTeamByID(long id){
        return getByID(id, Team.class);
    }
    public Task getTaskByID(long id){
        return getByID(id, Task.class);
    }
    public Milestone getMilestoneByID(long id){
        return getByID(id, Milestone.class);
    }
    public State getStateByID(long id){
        return getByID(id, State.class);
    }
}
