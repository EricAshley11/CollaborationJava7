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
public interface IProject extends Remote{
    String getName() throws RemoteException;

    Collection<ITeam> getTeams() throws RemoteException;

    void reName(String newName) throws RemoteException;

    boolean removeTeam(ITeam team) throws RemoteException;

    boolean addTeam(ITeam team) throws RemoteException;

    boolean removeUserStory(IUserStory userStory) throws RemoteException;

    boolean addUserStory(IUserStory userStory) throws RemoteException;

    boolean createMilestone(IMilestone milestone) throws RemoteException;

    boolean removeMilestone(IMilestone milestone) throws RemoteException;
}
