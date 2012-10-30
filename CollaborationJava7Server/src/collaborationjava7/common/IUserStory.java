/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Cam
 */
public interface IUserStory extends Remote{
     boolean removeTask(ITask task) throws RemoteException;

    boolean addTask(ITask task) throws RemoteException;

    boolean removeProject(IProject project) throws RemoteException;

    boolean changeProject(IProject project) throws RemoteException;
}
