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
        return QueryManager.getInstance().getAll(Team.class);
    }

    @Override
    public Team create(String[] namePass) {
        if(namePass.length != 2)
            return null;
        return QueryManager.getInstance().createTeam(namePass[0],namePass[1]);
    }
    
}
