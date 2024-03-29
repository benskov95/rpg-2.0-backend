package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EquipmentItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;

    public EquipmentItemType() {}
    
    public EquipmentItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
