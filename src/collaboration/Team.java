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
@Entity
class Team implements Serializable {

	@ID
	private int TeamID;
	
    private Collection<User> users;
    private Collection<Project> projects;
    private Schedule schedule;

    boolean addProject(Project project) {
        if (!projects.contains(project)) {
            projects.add(project);
            project.addTeam(this);
            return true;
        }
        return false;
    }

    boolean removeProject(Project project) {
        if (projects.remove(project)) {
            project.removeTeam(this);
            return true;
        }
        return false;
    }

    boolean addMilestone(Milestone milestone) {
        return schedule.addMilestone(milestone);
    }

    boolean completeMilestone(Milestone milestone) {
        return schedule.completeMilestone(milestone);
    }

    boolean addMember(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.addToTeam(this);
            return true;
        }
        return false;
    }

    boolean removeMember(User user) {
        if (users.remove(user)) {
            user.removeFromTeam(this);
            return true;
        }
        return false;
    }

    Schedule getSchedule() {
        return schedule;
    }

    Collection<Project> getProjects() {
        return projects;
    }

    Collection<User> getTeamMembers() {
        return users;
    }
}
