/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.util.Collection;

/**
 *
 * @author Cam
 */
class UserStory {
    
    private Collection<Task> tasks;
    private Project project;
    private State state;
    
    boolean removeTask(Task task) {
        if(tasks.remove(task)){
            task.delete();//TODO: Not sure if this is the best way to do this
            return true;
        }
        return false;
    }

    boolean addTask(Task task) {
        if(tasks.contains(task)){
            tasks.add(task);
            task.changeUserStory(this);
            return true;
        }
        return false;
    }

    boolean removeProject(Project project) {
        if(project != null && project.equals(this.project)){
            this.project = null;
            project.removeUserStory(this);
            return true;
        }
        return false;
    }

    boolean changeProject(Project project) {
        if(project != null && project.equals(this.project)){
            this.project.removeUserStory(this);
            this.project = project;
            project.addUserStory(this);
            return true;
        }
        return false;
    }
    
}
