/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 *
 * @author warnecam
 */
public class CollaborationJava7Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.setSecurityManager(new RMISecurityManager());
        try {
            System.out.println("Exporting");  
            Component component = new Component();  
            component.getServers().add(Protocol.HTTP, 8182);  
  
            component.getDefaultHost().attach("/collab", new CollabApplication());
  
            // Start the component.  
            component.start();  
          
        } catch (Exception e) {
            System.err.println("Backend exception:");
            e.printStackTrace();
        }
    }
}
