/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import collaborationjava7.common.*;
import org.restlet.Application;  
import org.restlet.Restlet;  
import org.restlet.routing.Router;  
/**
 *
 * @author Cam
 */
public class CollabApplication extends Application{
    @Override  
    public synchronized Restlet createInboundRoot() {  
        Router router = new Router(getContext());  
        router.attach("/milestone/{id}", MilestoneResource.class);  
        router.attach("/project/{id}", ProjectResource.class);  
        router.attach("/schedule/{id}", ScheduleResource.class);  
        router.attach("/state/{id}", StateResource.class);  
        router.attach("/task/{id}", TaskResource.class);  
        router.attach("/team/{id}", TeamResource.class);  
        router.attach("/user/{id}", UserResource.class);  
        router.attach("/userstory/{id}", UserStoryResource.class);
        router.attach("/backend",BackendResource.class);
        return router;  
    }  
  
}  
