/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.IScheduleResource;
import collaborationjava7.common.Milestone;
import collaborationjava7.common.Schedule;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Cam
 */
public class ScheduleResource extends ServerResource implements IScheduleResource{
    private Schedule schedule;
    private long id;
    
    @Override
    public Schedule retrieve() {
        schedule = QueryManager.getInstance().getScheduleByID(id);
        return schedule;
    }

    @Override
    public boolean store(Schedule schedule) {
        return QueryManager.getInstance().updateObj(schedule);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}
