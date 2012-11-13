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
    @Override
    public Backend retrieve(String serverAddr) {
        return new Backend(serverAddr);
    }
}
