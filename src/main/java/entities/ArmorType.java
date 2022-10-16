package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArmorType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id 
    private String name;
    
    // for armor value calculation on equipment items
    private int armorMultiplier;

    public ArmorType() {}

    public ArmorType(String name, int armorMultiplier) {
        this.name = name;
        this.armorMultiplier = armorMultiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmorMultiplier() {
        return armorMultiplier;
    }

    public void setArmorMultiplier(int armorMultiplier) {
        this.armorMultiplier = armorMultiplier;
    }
    
}
