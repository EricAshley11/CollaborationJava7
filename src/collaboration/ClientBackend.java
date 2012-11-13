/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import collaborationjava7.common.*;
import java.util.Collection;
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
        User bob = cb.createUser("BOB", "Abc");
        System.out.println(bob.getName()+" "+bob.getID());
        User bob2 = cb.getUserFromId(bob.getID());
        System.out.println(bob2.getName());
    }
    //This constructor is private because we want this class to be a singleton
    private ClientBackend(){
        //Get a backend from Server
        try {
            // Define our Restlet client resources.  
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/backend");  
            IBackendResource br = cr.wrap(IBackendResource.class);
            remoteObj = br.retrieve(serverAddr);

            System.out.println("Got the object from the server.");
        } catch (Exception e) {
            System.err.println("Error getting the object from server");
            e.printStackTrace();
        }
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

    public Collection<Project> retrieveProjects(){
         return null;//remoteObj.retrieveProjects();

    }

    public Collection<Project> getDummyProjects(){
         return null;//remoteObj.getDummyProjects();

    }

    public Collection<User> retrieveUsers(){
        return remoteObj.retrieveUsers();
    }

    public String[][] getUserTableData(){
        return remoteObj.getUserTableData();
    }

    public Collection<Task> retrieveUserTasks(){
         return null;//remoteObj.retrieveUserTasks();
    }

    public Collection<Task> retrieveUserTasks(User user){
         return remoteObj.retrieveUserTasks(user);
    }

    public void removeUser(User user){
         remoteObj.removeUser(user);
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

    public User createUser(String user, String password){
         return remoteObj.createUser(user, password);
    }

    public User getUserFromId(long id) {
        return remoteObj.getUserFromId(id);
    }
    
    public User getUser(String name) {
          return remoteObj.getUser(name);
    }
    
}
