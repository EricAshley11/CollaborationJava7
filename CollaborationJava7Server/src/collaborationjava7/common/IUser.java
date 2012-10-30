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
public interface IUser extends Remote{
    boolean addToTeam(ITeam team) throws RemoteException;

    void delete() throws RemoteException;

    boolean removeFromTeam(ITeam team) throws RemoteException;

    boolean switchTeams(ITeam oldTeam, ITeam newTeam) throws RemoteException;

    boolean addTask(ITask task) throws RemoteException;

    boolean removeTask(ITask task) throws RemoteException;

    // <editor-fold desc="Getters/Setters">
    public String getEmail() throws RemoteException;

    public void setEmail(String email) throws RemoteException;

    public String getName() throws RemoteException;

    public void setName(String name) throws RemoteException;

    public String getPhoneNum() throws RemoteException;

    public void setPhoneNum(String phoneNum) throws RemoteException;

    public Collection<ITask> getTasks() throws RemoteException;

    public Collection<ITeam> getTeams() throws RemoteException;
    // </editor-fold>
    
}
