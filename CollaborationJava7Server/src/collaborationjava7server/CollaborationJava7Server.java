/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import java.rmi.RMISecurityManager;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.security.Policy;

/**
 *
 * @author warnecam
 */
public class CollaborationJava7Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            System.out.println("Exporting");
            String name = "Backend";
            Backend backend = new Backend();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name, backend);
        } catch (Exception e) {
            System.err.println("Backend exception:");
            e.printStackTrace();
        }
    }
}
