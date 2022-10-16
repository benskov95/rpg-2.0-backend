package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EquipmentItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;
    
    // for armor value calculation on equipment items
    private int eqTypeMultiplier;

    public EquipmentItemType() {}
    
    public EquipmentItemType(String name, int eqTypeMultiplier) {
        this.name = name;
        this.eqTypeMultiplier = eqTypeMultiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEqTypeMultiplier() {
        return eqTypeMultiplier;
    }

    public void setEqTypeMultiplier(int eqTypeMultiplier) {
        this.eqTypeMultiplier = eqTypeMultiplier;
    }
    
}
