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
public interface IStateResource {
    @Get
    public State retrieve();

    @Put
    public boolean store(State state);

    @Delete
    public void remove(int id);
}
