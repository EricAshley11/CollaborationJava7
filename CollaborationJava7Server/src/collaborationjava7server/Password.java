/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;


//import java.util.Collection;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 */
@Entity(name = "Password")
public class Password implements Serializable {

    @Id @GeneratedValue
    private long id;
    private String name;
    private String password;

    public Password() {
    }

    public Password(String User, String password) {
        this.password = password;
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
