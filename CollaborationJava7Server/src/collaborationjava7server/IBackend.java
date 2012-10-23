/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 *
 * @author Cam
 */
public interface IBackend extends Remote {
    void setCurrentProject(Project project) throws RemoteException;

    void setCurrentUser(User user) throws RemoteException;

    void removeProject(Project project) throws RemoteException;
    
    Collection<Project> retrieveProjects() throws RemoteException;

    Collection<Project> getDummyProjects() throws RemoteException;

    Collection<User> retrieveUsers() throws RemoteException;

    String[][] getUserTableData() throws RemoteException;

    Collection<Task> retrieveUserTasks() throws RemoteException;

    Collection<Task> retrieveUserTasks(User user) throws RemoteException;

    void removeUser(User user) throws RemoteException;

    void removeUser(String name) throws RemoteException;

    User getUserFromName(String name) throws RemoteException;
}
