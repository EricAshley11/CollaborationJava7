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
public interface IUserResource{
    @Get
    public User retrieve();

    @Put
    public void store(User user);

    @Delete
    public void remove();
}
