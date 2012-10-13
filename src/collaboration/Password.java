/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

import java.util.Collection;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 */
@Entity
public class Password implements Serializable {

    @Id
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

    public void setPassword(String password) {
        this.password = password;
    }
}
