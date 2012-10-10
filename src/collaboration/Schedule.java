package collaboration;

import java.util.*;

/**
 *
 * @author Cam
 */
class Schedule{
    
    private Collection<Milestone> milestones;
    
    public Schedule() {
        
    }

    boolean addMilestone(Milestone milestone) {
        if (!milestones.contains(milestone)) {
            milestones.add(milestone);
            return true;
        }
        return false;
    }

    boolean completeMilestone(Milestone milestone) {
        if (milestone.setComplete()) {
            return true;
        }
        return false;
    }
    
    
    
}
