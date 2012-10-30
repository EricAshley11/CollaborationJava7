/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import collaborationjava7.common.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;

/**
 *
 * @author Cam
 */
public class ClientBackend implements IBackend{

    private static ClientBackend instance = null;
    private IBackend remoteObj;
    private static String serverAddr = "eos02";
    public static ClientBackend getInstance(){
        if(instance == null){
            //make a single backend for the client
            instance = new ClientBackend();
        }
        return instance;
    }
    //This constructor is private because we want this class to be a singleton
    private ClientBackend(){
        //Get a backend from RMI Server
        if (System.getSecurityManager() == null) {
        System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Backend";
            Registry registry = LocateRegistry.getRegistry(serverAddr);
            remoteObj = (IBackend) registry.lookup(name);
            System.out.println("Got the object from the server.");
        } catch (Exception e) {
            System.err.println("Error getting the object from server");
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void setCurrentProject(IProject project){
        try {
            remoteObj.setCurrentProject(project);
        } catch (RemoteException ex) {
            printRemoteError(ex);
        }
    }

    @Override
    public void setCurrentUser(IUser user){
        try {
            remoteObj.setCurrentUser(user);
        } catch (RemoteException ex) {
            printRemoteError(ex);
        }
    }

    @Override
    public void removeProject(IProject project){
        try {
            remoteObj.removeProject(project);
        } catch (RemoteException ex) {
            printRemoteError(ex);
        }
    }

    @Override
    public Collection<IProject> retrieveProjects(){
        try {
            return remoteObj.retrieveProjects();
        } catch (RemoteException ex) {
            printRemoteError(ex);
            return null;
        }
    }

    @Override
    public Collection<IProject> getDummyProjects(){
        try {
            return remoteObj.getDummyProjects();
        } catch (RemoteException ex) {
            printRemoteError(ex);
            return null;
        }
    }

    @Override
    public Collection<IUser> retrieveUsers(){
        try {
            return remoteObj.retrieveUsers();
        } catch (RemoteException ex) {
            printRemoteError(ex);
            return null;
        }
    }

    @Override
    public String[][] getUserTableData(){
        try {
            return remoteObj.getUserTableData();
        } catch (RemoteException ex) {
            printRemoteError(ex);
            return null;
        }
    }

    @Override
    public Collection<ITask> retrieveUserTasks(){
        try {
            return remoteObj.retrieveUserTasks();
        } catch (RemoteException ex) {
            printRemoteError(ex);
            return null;
        }
    }

    @Override
    public Collection<ITask> retrieveUserTasks(IUser user){
        try {
            return remoteObj.retrieveUserTasks(user);
        } catch (RemoteException ex) {
            printRemoteError(ex);
            return null;
        }
    }

    @Override
    public void removeUser(IUser user){
        try {
            remoteObj.removeUser(user);
        } catch (RemoteException ex) {
            printRemoteError(ex);
        }
    }

    @Override
    public void removeUser(String name){
        try {
            remoteObj.removeUser(name);
        } catch (RemoteException ex) {
            printRemoteError(ex);
        }
    }

    @Override
    public IUser getUserFromName(String name){
        try {
            return remoteObj.getUserFromName(name);
        } catch (RemoteException ex) {
            printRemoteError(ex);
            return null;
        }
    }
    
    private void printRemoteError(RemoteException ex){
        System.err.println("There was a remote error:");
        ex.printStackTrace(System.err);
    }
    
}
