/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IMilestonesResource;
import collaborationjava7.common.Milestone;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class MilestonesResource extends ServerResource implements IMilestonesResource{

    @Override
    public Milestone create(String name) {
        return QueryManager.getInstance().createMilestone(name);
    }
}
