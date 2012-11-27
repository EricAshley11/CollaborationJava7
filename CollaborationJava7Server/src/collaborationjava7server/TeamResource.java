/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.ITeamResource;
import collaborationjava7.common.Team;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class TeamResource  extends ServerResource implements ITeamResource{
    private Team team;
    private long id;
    
    @Override
    public Team retrieve() {
        id = Long.parseLong((String)this.getRequestAttributes().get("id"));
        team = QueryManager.getInstance().getTeamByID(id);
        return team;
    }

    @Override
    public boolean store(Team team) {
        return QueryManager.getInstance().updateObj(team);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
