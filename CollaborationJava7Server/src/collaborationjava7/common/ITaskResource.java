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
public interface ITaskResource{
    @Get
    public Task retrieve();

    @Put
    public boolean store(Task task);

    @Delete
    public void remove(int id);
}
