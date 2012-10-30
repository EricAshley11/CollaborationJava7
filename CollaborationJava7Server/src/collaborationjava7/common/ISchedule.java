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
public interface ISchedule extends Remote{
    boolean addMilestone(IMilestone milestone) throws RemoteException;

    boolean completeMilestone(IMilestone milestone) throws RemoteException;
}
