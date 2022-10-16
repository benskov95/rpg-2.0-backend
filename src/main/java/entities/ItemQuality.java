package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemQuality implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;
    
    // for armor value calculation on equipment items
    private int qualityMultiplier;

    public ItemQuality() {}

    public ItemQuality(String name, int qualityMultiplier) {
        this.name = name;
        this.qualityMultiplier = qualityMultiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQualityMultiplier() {
        return qualityMultiplier;
    }

    public void setQualityMultiplier(int qualityMultiplier) {
        this.qualityMultiplier = qualityMultiplier;
    }

}
