/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import javax.persistence.*;
import java.util.*;

/**
 * This is a class that helps save to the DB
 * 
 * @author Cam
 */
class DatabaseManager {
	// Open a database connection
	// (create a new database if it doesn't exist yet):

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/O.odb");
        EntityManager em = emf.createEntityManager();

	private void createUser() {
		Query createUserQ = em.createQuery("");
	}

	private void addUserToTeam() {
		Query addUserQ = em.createQuery("");
	}


    private TypedQuery<User> createQuery(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
