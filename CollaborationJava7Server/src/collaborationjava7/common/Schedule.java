package collaborationjava7.common;

import java.util.*;
import java.io.*;


/**
 *
 */

public class Schedule implements Serializable {

    
    private long id;
    
    
    private Project project;
    
    
    private ArrayList<Milestone> milestones;

    
    public Schedule() {
        this.milestones = new ArrayList<Milestone>();
    }

    public boolean changeProject(Project proj){
        if(this.project != proj){
            this.project = proj;
            return true;//QueryManager.getInstance().updateObjs(new Object[]{this, proj});
        }
        return false;
    }
    public boolean addMilestone(Milestone milestone) {
        if (!milestones.contains(milestone)) {
            milestones.add(milestone);
            //QueryManager.getInstance().updateObj(this);
            return true;
        }
        return false;
    }

    public boolean removeMilestone(Milestone milestone) {
        if (milestones.remove(milestone)) {
            //QueryManager.getInstance().updateObjs(new Object[]{milestone, this});
            return true;
        }
        return false;
    }
    public boolean completeMilestone(Milestone milestone) {
        if (milestone.setComplete()) {
            //QueryManager.getInstance().updateObj(this);
            return true;
        }
        return false;
    }
    public long getID() {
        return id;
    }
    public ArrayList<Milestone> getMilestones(){
        return milestones;
    }
}
