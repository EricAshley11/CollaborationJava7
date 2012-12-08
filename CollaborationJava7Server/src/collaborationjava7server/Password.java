/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;


//import java.util.ArrayList;
import java.io.Serializable;


/**
 *
 */
public class Password implements Serializable {

    
    private long id;
    private String userName;
    private String password;

    public Password() {
    }

    public Password(String userName, String password) {
        this.password = password;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public long getID(){
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
