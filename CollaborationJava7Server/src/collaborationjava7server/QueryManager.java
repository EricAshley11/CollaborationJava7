/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;
import collaborationjava7.common.*;
import java.util.ArrayList;
import java.util.List;
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
    public boolean updateObj(Object object){
        try{
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public User createUser(String username, String password, String phoneNum, String email) {
        em.getTransaction().begin();
        User U = new User(username);
        U.setPhoneNum(phoneNum);
        U.setEmail(email);
        Password P = new Password(username, password);
        em.persist(U);
        em.persist(P);
        em.getTransaction().commit();
        System.out.println("New UserID: "+U.getID()+" New Password ID: "+P.getID());
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
    public List<User> getUsersByName(String name) {
        return getByName(name, User.class);
    }
    public List<Project> getProjectsByName(String name){
        return getByName(name, Project.class);
    }
    public List<UserStory> getUserStoriesByName(String name){
        return getByName(name, UserStory.class);
    }
    public List<Schedule> getSchedulesByName(String name){
        return getByName(name, Schedule.class);
    }
    public List<Team> getTeamsByName(String name){
        return getByName(name, Team.class);
    }
    public List<Task> getTasksByName(String name){
        return getByName(name, Task.class);
    }
    public List<Milestone> getMilestonesByName(String name){
        return getByName(name, Milestone.class);
    }
    public List<State> getStatesByName(String name){
        return getByName(name, State.class);
    }
    
    private <T> List<T> getByName(String name, Class<T> type){
        String qText = "SELECT T FROM "+type.getSimpleName()+" T WHERE T.name = \""+name+"\"";
        TypedQuery<T> q = em.createQuery(qText, type);
        List<T> ret;
        try{
            ret= q.getResultList();
        }
        catch(Exception e){
            ret = null;
        }
        return ret;
    }
    
    private <T> T getByID(long id, Class<T> type){
        String qText = "SELECT T FROM "+type.getSimpleName()+" T WHERE T.id = "+id;
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
