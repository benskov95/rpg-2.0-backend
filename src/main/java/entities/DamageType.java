
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DamageType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String type;

    public DamageType() {}

    public DamageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

}
