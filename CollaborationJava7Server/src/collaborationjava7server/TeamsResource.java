/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.ITeamsResource;
import collaborationjava7.common.Team;
import java.util.ArrayList;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class TeamsResource extends ServerResource implements ITeamsResource{

    @Override
    public ArrayList<Team> retrieve() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Team create(String teamName) {
        return QueryManager.getInstance().createTeam(teamName);
    }
    
}
