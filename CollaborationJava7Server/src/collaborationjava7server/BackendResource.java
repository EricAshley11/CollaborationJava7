/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.Backend;
import collaborationjava7.common.IBackendResource;
import collaborationjava7.common.Milestone;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class BackendResource extends ServerResource implements IBackendResource{
    Backend backend = null;
    @Override
    public Backend retrieve() {
        if(backend == null){
            backend = new Backend();
        }
        return backend;
    }

    @Override
    public void store(Backend backend) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
