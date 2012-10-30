/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;
import java.rmi.*;
import java.util.Collection;

/**
 *
 * @author Cam
 */
public interface IBackend extends Remote {
    void setCurrentProject(IProject project) throws RemoteException;

    void setCurrentUser(IUser user) throws RemoteException;

    void removeProject(IProject project) throws RemoteException;
    
    Collection<IProject> retrieveProjects() throws RemoteException;

    Collection<IProject> getDummyProjects() throws RemoteException;

    Collection<IUser> retrieveUsers() throws RemoteException;

    String[][] getUserTableData() throws RemoteException;

    Collection<ITask> retrieveUserTasks() throws RemoteException;

    Collection<ITask> retrieveUserTasks(IUser user) throws RemoteException;

    void removeUser(IUser user) throws RemoteException;

    void removeUser(String name) throws RemoteException;

    IUser getUserFromName(String name) throws RemoteException;
}
