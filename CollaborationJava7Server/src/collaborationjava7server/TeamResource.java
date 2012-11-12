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
        team = QueryManager.getInstance().getTeamByID(id);
        return team;
    }

    @Override
    public void store(Team team) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
