package collaborationjava7server;

import collaborationjava7.common.*;
import java.util.*;
import java.io.*;
import java.rmi.RemoteException;

/**
 *
 */
class Schedule implements Serializable, ISchedule {

    private Collection<IMilestone> milestones;

    public Schedule() {
    }

    @Override
    public boolean addMilestone(IMilestone milestone) {
        if (!milestones.contains(milestone)) {
            milestones.add(milestone);
            return true;
        }
        return false;
    }

    @Override
    public boolean completeMilestone(IMilestone milestone) throws RemoteException{
        if (milestone.setComplete()) {
            return true;
        }
        return false;
    }
}
