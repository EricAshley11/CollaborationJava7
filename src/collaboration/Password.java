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
 * @author burnsidz
 */
@Entity
public class Password implements Serializable {
    
    @Id
    private int UserID;
    private String password;
    
    public Password() {}
    
    public Password(int User, String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
}
