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
public interface IProjectResource{
    @Get
    public Project retrieve();

    @Put
    public boolean store(Project project);

    @Delete
    public void remove(int id);
}
