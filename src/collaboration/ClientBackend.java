/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import collaborationjava7.common.*;
import java.util.ArrayList;
import java.util.List;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Cam
 */
public class ClientBackend implements IBackend{

    private static ClientBackend instance = null;
    private Backend remoteObj;
    private static String serverAddr = "localhost";
    public static ClientBackend getInstance(){
        if(instance == null){
            //make a single backend for the client
            instance = new ClientBackend();
        }
        return instance;
    }
    
    public static void main(String[] args){
        //Make some test data and put it in the database
        User cam = getInstance().createUser("cam", "abc", "616-1111", "cam@test");
        User zach = getInstance().createUser("zach", "abc", "616-2222", "zach@test");
        User ericA = getInstance().createUser("ericA", "abc", "616-3333", "erica@test");
        User tommy = getInstance().createUser("tommy", "abc", "616-4444", "tommy@test");
        User ericM = getInstance().createUser("ericm", "abc", "616-5555", "ericm@test");
        User mike = getInstance().createUser("mike", "abc", "616-6666", "mike@test");
        
        Team team = getInstance().createTeam("collabTeam", "abc");
        team.addMember(cam);
        team.addMember(zach);
        team.addMember(ericA);
        team.addMember(tommy);
        team.addMember(ericM);
        team.addMember(mike);
        getInstance().saveEntity(team);
        
        Project proj1 = getInstance().createProject("testProj1", cam);
        Project proj2 = getInstance().createProject("testProj2", cam);
        
    }
    //This constructor is private because we want this class to be a singleton
    private ClientBackend(){
        //Realized we don't really need to get a remote object here, we can just use the ClientBackend as a wrapper
        //try {
            // Define our Restlet client resources.  
            //ClientResource cr = new ClientResource(  
            //    "http://"+serverAddr+":8182/collab/backend");  
            //IBackendResource br = cr.wrap(IBackendResource.class);
            remoteObj = new Backend(serverAddr);//br.retrieve(serverAddr);
            /*
            System.out.println("Got the object from the server.");
        } catch (Exception e) {
            System.err.println("Error getting the object from server");
            e.printStackTrace();
        }*/
    }

    public void removeProject(Project project){
         remoteObj.removeProject(project);
    }

    public ArrayList<Project> retrieveUserProjects(User u){
         return remoteObj.retrieveProjects(u);

    }

    public ArrayList<Project> getDummyProjects(){
         return null;//remoteObj.getDummyProjects();

    }

    public ArrayList<User> retrieveUsers(Project p){
        return remoteObj.retrieveUsers(p);
    }

    public String[][] getUserTableData(Project p){
        return remoteObj.getUserTableData(p);
    }

    public ArrayList<Task> retrieveUserTasks(){
         return null;//remoteObj.retrieveUserTasks();
    }

    public ArrayList<Task> retrieveUserTasks(User user){
         return remoteObj.retrieveUserTasks(user);
    }

    public void removeUser(String name){
         remoteObj.removeUser(name);
    }

    public Project createProject(String projectName, User u){
         return remoteObj.createProject(projectName, u);
    }

    public Team createTeam(String teamName, String password){
         return remoteObj.createTeam(teamName, password);
    }

    public UserStory createUserStory(String usName) {
         return remoteObj.createUserStory(usName);
    }

    public User createUser(String user, String password, String phoneNum, String email){
         return remoteObj.createUser(user, password, phoneNum, email);
    }

    public User getUserFromId(long id) {
        return remoteObj.getUserFromId(id);
    }
    
    public User getUser(String name) {
        List<User> users = remoteObj.getUsersFromName(name);
        if(users!=null && users.size()==1){
            return users.iterator().next();
        }
        return null;
    }

    @Override
    public Milestone createMilestone(String milestoneName) {
        return remoteObj.createMilestone(milestoneName);
    }

    @Override
    public Task createTask(String taskName) {
        return remoteObj.createTask(taskName);
    }

    @Override
    public List<User> getUsersFromName(String name) {
        return remoteObj.getUsersFromName(name);
    }

    @Override
    public User loginUser(String userName, String password) {
        return remoteObj.loginUser(userName, password);
    }

    @Override
    public ArrayList<Project> retrieveProjects(User u) {
        return remoteObj.retrieveProjects(u);
    }

    @Override
    public <T> boolean saveEntity(T entity) {
        return remoteObj.saveEntity(entity);
    }

    public void editProjectName(Project proj, String editedProjectName) {
        remoteObj.editProjectName(proj, editedProjectName);
    }

    void updateUser(User user, String newName, String newPhone, String newEmail) {
        remoteObj.updateUser(user, newName, newPhone, newEmail);
    }

    @Override
    public ArrayList<Team> getAllTeams() {
        return remoteObj.getAllTeams();
    }

    @Override
    public boolean loginTeam(Team team, String password) {
        return remoteObj.loginTeam(team, password);
    }

    @Override
    public void addUserToTeam(User u, Team t) {
        remoteObj.addUserToTeam(u, t);
    }
}
