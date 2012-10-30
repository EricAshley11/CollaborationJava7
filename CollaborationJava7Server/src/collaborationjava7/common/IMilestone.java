/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.rmi.*;

/**
 *
 * @author Cam
 */
public interface IMilestone extends Remote{
    public void setEstDate(int month, int day, int year) throws RemoteException;

    public void setCompDate(int month, int day, int year) throws RemoteException;

    public boolean isComplete() throws RemoteException;

    public boolean setComplete() throws RemoteException;

    public boolean isOnTime() throws RemoteException;

    public String estDateToString() throws RemoteException;

    public String completeDateToString() throws RemoteException;

    public String getMonth(int month) throws RemoteException;

    public int getID() throws RemoteException;
}
