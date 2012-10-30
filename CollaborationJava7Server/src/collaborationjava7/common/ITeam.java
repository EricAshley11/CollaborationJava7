/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 *
 * @author Cam
 */
public interface ITeam extends Remote{
    boolean addProject(IProject project) throws RemoteException;

    boolean removeProject(IProject project) throws RemoteException;

    boolean addMember(IUser user) throws RemoteException;

    boolean removeMember(IUser user) throws RemoteException;

    boolean completeMilestone(IMilestone milestone) throws RemoteException;

    boolean addMilestone(IMilestone milestone) throws RemoteException;

    public ISchedule getSched() throws RemoteException;

    public Collection<IProject> getProjects() throws RemoteException;

    Collection<IUser> getTeamMembers() throws RemoteException;

    public String getName() throws RemoteException;
}
