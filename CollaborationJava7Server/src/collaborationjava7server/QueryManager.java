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

    static QueryManager getInstance(){
        if(instance == null){
            instance = new QueryManager();
        }
        return instance;        
    }
    boolean updateObj(Object object){
        try{
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    boolean updateObjs(Object[] object) {
        boolean retVal = true;
        for(Object o : object){
            if(!updateObj(o))
                retVal = false;
        }
        return retVal;
    }
    User createUser(String username, String password, String phoneNum, String email) {
        em.getTransaction().begin();
        User U = new User(username);
        U.setPhoneNum(phoneNum);
        U.setEmail(email);
        Password P = new Password(username, password);
        em.persist(U);
        em.persist(P);
        em.getTransaction().commit();
        System.out.println("New User, ID: "+U.getName()+", "+U.getID()+" New Password ID: "+P.getID());
        return U;
    }

    Team createTeam(String name) {
        em.getTransaction().begin();
        Team T = new Team(name);
        em.persist(T);
        em.getTransaction().commit();
        System.out.println("Created Team " + name);
        return T;
    }
    
    UserStory createUserStory(String name) {
        em.getTransaction().begin();
        UserStory US = new UserStory(name);
        em.persist(US);
        em.getTransaction().commit();
        System.out.println("Created UserStory " + name);
        return US;
    }

    Project createProject(String name) {
        em.getTransaction().begin();
        Project P = new Project(name);
        Schedule S = new Schedule();
        P.setSchedule(S);
        em.persist(P);
        em.persist(S);
        em.getTransaction().commit();
        System.out.println("Created Project " + name+", id: "+P.getID());
        return P;
    }
    User checkPassword(String user, String password) {
        TypedQuery<User> createUserQ = 
                em.createQuery("SELECT U FROM User U, Password P WHERE P.userName = :name AND U.name = P.userName AND P.password = :pass", User.class);
        try{
            //List<User> users = createUserQ.setParameter("name", user)
                    //.setParameter("pass", password).getResultList();
            User u = createUserQ.setParameter("name", user)
                    .setParameter("pass", password).getSingleResult();
            return u;
        }catch(Exception e){
            System.out.println("Invalid Credentials"+e.getMessage());
            return null;
        }
    }
    List<User> getUsersByName(String name) {
        return getByName(name, User.class);
    }
    List<Project> getProjectsByName(String name){
        return getByName(name, Project.class);
    }
    List<UserStory> getUserStoriesByName(String name){
        return getByName(name, UserStory.class);
    }
    List<Schedule> getSchedulesByName(String name){
        return getByName(name, Schedule.class);
    }
    List<Team> getTeamsByName(String name){
        return getByName(name, Team.class);
    }
    List<Task> getTasksByName(String name){
        return getByName(name, Task.class);
    }
    List<Milestone> getMilestonesByName(String name){
        return getByName(name, Milestone.class);
    }
    List<State> getStatesByName(String name){
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
    
    Project getProjectByID(long id){
        return getByID(id, Project.class);
    }
    User getUserByID(long id){
        return getByID(id, User.class);
    }
    UserStory getUserStoryByID(long id){
        return getByID(id, UserStory.class);
    }
    Schedule getScheduleByID(long id){
        return getByID(id, Schedule.class);
    }
    Team getTeamByID(long id){
        return getByID(id, Team.class);
    }
    Task getTaskByID(long id){
        return getByID(id, Task.class);
    }
    Milestone getMilestoneByID(long id){
        return getByID(id, Milestone.class);
    }
    State getStateByID(long id){
        return getByID(id, State.class);
    }

    Task createTask(String name) {
        em.getTransaction().begin();
        Task t = new Task(name);
        em.persist(t);
        em.getTransaction().commit();
        System.out.println("Created Task " + name+", id: "+t.getID());
        return t;
    }

    Milestone createMilestone(String name) {
        em.getTransaction().begin();
        Milestone m = new Milestone(name);
        em.persist(m);
        em.getTransaction().commit();
        System.out.println("Created Milestone " + name+", id: "+m.getID());
        return m;
    }

    <T> ArrayList<T> getAll(Class<T> aClass) {
        String queryTxt = "SELECT T FROM :type T";
        TypedQuery<T> query = em.createQuery(queryTxt, aClass);
        List<T> results = query.setParameter("type", aClass.getSimpleName()).getResultList();
        ArrayList<T> retVal = new ArrayList(results);
        return retVal;
    }
}
