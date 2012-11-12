/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import collaborationjava7.common.*;
import collaborationjava7server.BackendResource;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Cam
 */
public class ClientBackend extends Backend{

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
    //This constructor is private because we want this class to be a singleton
    private ClientBackend(){
        super("abc");
        //Get a backend from Server
        try {
            // Define our Restlet client resources.  
            ClientResource cr = new ClientResource(  
                "http://"+serverAddr+":8182/collab/backend");  
            IBackendResource br = cr.wrap(IBackendResource.class);
            remoteObj = br.retrieve();

            System.out.println("Got the object from the server.");
        } catch (Exception e) {
            System.err.println("Error getting the object from server");
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void setCurrentProject(Project project){
         remoteObj.setCurrentProject(project);
    }

    @Override
    public void setCurrentUser(User user){
            remoteObj.setCurrentUser(user);

    }

    @Override
    public void removeProject(Project project){
         remoteObj.removeProject(project);
    }

    @Override
    public Collection<Project> retrieveProjects(){
         return remoteObj.retrieveProjects();

    }

    @Override
    public Collection<Project> getDummyProjects(){
         return remoteObj.getDummyProjects();

    }

    @Override
    public Collection<User> retrieveUsers(){
        return remoteObj.retrieveUsers();
    }

    @Override
    public String[][] getUserTableData(){
        return remoteObj.getUserTableData();
    }

    @Override
    public Collection<Task> retrieveUserTasks(){
         return remoteObj.retrieveUserTasks();
    }

    @Override
    public Collection<Task> retrieveUserTasks(User user){
         return remoteObj.retrieveUserTasks(user);
    }

    @Override
    public void removeUser(User user){
         remoteObj.removeUser(user);
    }

    @Override
    public void removeUser(String name){
         remoteObj.removeUser(name);
    }

    @Override
    public User getUserFromName(String name){
        return remoteObj.getUserFromName(name);
    }

    @Override
    public Project createProject(String projectName){
         return remoteObj.createProject(projectName);
    }

    @Override
    public Team createTeam(String teamName){
         return remoteObj.createTeam(teamName);
    }

    @Override
    public UserStory createUserStory(String usName) {
         return remoteObj.createUserStory(usName);
    }

    @Override
    public User createUser(String user, String password){
         return remoteObj.createUser(user, password);
    }

    @Override
    public User getUser(String name) {
          return remoteObj.getUser(name);
    }
    
}
