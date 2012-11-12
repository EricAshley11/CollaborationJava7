/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IMilestoneResource;
import collaborationjava7.common.Milestone;
import org.restlet.resource.*;

/**
 *
 * @author Cam
 */
public class MilestoneResource extends ServerResource implements IMilestoneResource{
    private Milestone milestone;
    private long id;
    
    @Override
    public Milestone retrieve() {
        milestone = QueryManager.getInstance().getMilestoneByID(id);
        return milestone;
    }

    @Override
    public void store(Milestone milestone) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
