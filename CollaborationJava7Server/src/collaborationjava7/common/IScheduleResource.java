/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.io.Serializable;
import org.restlet.resource.*;

/**
 *
 * @author Cam
 */
public interface IScheduleResource{
    @Get
    public Schedule retrieve();

    @Put
    public boolean store(Schedule schedule);

    @Delete
    public void remove(int id);
}
