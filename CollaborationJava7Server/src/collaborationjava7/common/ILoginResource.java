/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import org.restlet.resource.Get;

/**
 *
 * @author Cam
 */
public interface ILoginResource {
    @Get
    public User login(String password);
}
