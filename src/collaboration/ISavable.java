package collaboration;

/**
 *
 * @author Cam
 */
public interface ISavable { 
    /***
     * Saves the object to the DB
     * @param entityManager The DB entityManager
     * @return if the save was successful
     */
    boolean Save(QueryManager entityManager);
    
}
