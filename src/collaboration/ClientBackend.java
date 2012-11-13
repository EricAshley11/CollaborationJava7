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
public class ClientBackend{

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
        ClientBackend cb = ClientBackend.getInstance();
        User bob = cb.createUser("BOB", "abc", "123-555-9999","bob@test.com");
        System.out.println(bob);
        User bob2 = cb.getUserFromId(bob.getID());
        System.out.println(bob2);
        bob2.setEmail("changedemail@test.com");
        cb.remoteObj.saveUser(bob2);
        User bob3 = cb.getUserFromId(bob2.getID());
        System.out.println(bob3);
        List<User> users = cb.remoteObj.getUsersFromName("BOB");
        for(User u : users){
            System.out.println(u);
        }
    }
    //This constructor is private because we want this class to be a singleton
    private ClientBackend(){
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
    
    
    public void setCurrentProject(Project project){
        // remoteObj.setCurrentProject(project);
    }

    public void setCurrentUser(User user){
           // remoteObj.setCurrentUser(user);

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

    public ArrayList<User> retrieveUsers(){
        return remoteObj.retrieveUsers();
    }

    public String[][] getUserTableData(){
        return remoteObj.getUserTableData();
    }

    public ArrayList<Task> retrieveUserTasks(){
         return null;//remoteObj.retrieveUserTasks();
    }

    public ArrayList<Task> retrieveUserTasks(User user){
         return remoteObj.retrieveUserTasks(user);
    }

    public void removeUser(User user){
         //remoteObj.removeUser(user);
    }

    public void removeUser(String name){
         remoteObj.removeUser(name);
    }

    public Project createProject(String projectName){
         return remoteObj.createProject(projectName);
    }

    public Team createTeam(String teamName){
         return remoteObj.createTeam(teamName);
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

    public User login(String userName, String password) {
        return remoteObj.loginUser(userName, password);
    }
    
}
