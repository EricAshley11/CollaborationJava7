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
public interface ITask extends Remote{
    boolean removeUser(IUser user) throws RemoteException;

    boolean changeUser(IUser user) throws RemoteException;

    boolean changeUserStory(IUserStory userStory) throws RemoteException;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getDescription() throws RemoteException;

    public String getName() throws RemoteException;

    //TODO: states need to get changed up public State getState();

    public int getStoryPointsActual() throws RemoteException;

    public int getStoryPointsEstimate() throws RemoteException;

    public IUser getUser() throws RemoteException;

    public IUserStory getUserStory() throws RemoteException;

    public void setDescription(String description) throws RemoteException;

    public void setName(String name) throws RemoteException;

    //TODO: same as above public void setState(State state);

    public void setStoryPointsActual(int storyPointsActual) throws RemoteException;

    public void setStoryPointsEstimate(int storyPointsEstimate) throws RemoteException;
    //</editor-fold>

    void delete() throws RemoteException;
}
