
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumableItemTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;

    public ConsumableItemTemplate() {}

    public ConsumableItemTemplate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
