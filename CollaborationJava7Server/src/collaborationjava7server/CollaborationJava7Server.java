/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author warnecam
 */
public class CollaborationJava7Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            System.out.println("Exporting");
            String name = "Backend";
            Backend backend = new Backend();
            UnicastRemoteObject.unexportObject(backend, true);
            IBackend stub =
                (IBackend) UnicastRemoteObject.exportObject(backend, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
        } catch (Exception e) {
            System.err.println("Backend exception:");
            e.printStackTrace();
        }
    }
}
