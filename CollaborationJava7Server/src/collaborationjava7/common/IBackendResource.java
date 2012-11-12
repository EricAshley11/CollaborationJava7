/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import org.restlet.resource.*;

/**
 *
 * @author Cam
 */
public interface IBackendResource {
    @Get
    public Backend retrieve();

    @Put
    public void store(Backend backend);

    @Delete
    public void remove(int id);
}
