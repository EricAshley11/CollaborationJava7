/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IStateResource;
import collaborationjava7.common.State;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class StateResource extends ServerResource implements IStateResource{
    private State state;
    private long id;
    
    @Override
    public State retrieve() {
        state = QueryManager.getInstance().getStateByID(id);
        return state;
    }

    @Override
    public void store(State task) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
