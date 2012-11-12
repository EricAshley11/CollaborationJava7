package collaborationjava7.common;

import java.util.*;
import java.io.*;
import javax.persistence.*;

/**
 *
 */
@Entity
public class Schedule implements Serializable {

    @Id @GeneratedValue
    private long id;
    private Collection<Milestone> milestones;

    
    public Schedule() {
    }

    public boolean addMilestone(Milestone milestone) {
        if (!milestones.contains(milestone)) {
            milestones.add(milestone);
            return true;
        }
        return false;
    }

    public boolean completeMilestone(Milestone milestone) {
        if (milestone.setComplete()) {
            return true;
        }
        return false;
    }
    public long getID() {
        return id;
    }
}
