
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EnemyType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;
    
    private int lootMultiplier;

    public EnemyType() {}

    public EnemyType(String name, int lootMultiplier) {
        this.name = name;
        this.lootMultiplier = lootMultiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLootMultiplier() {
        return lootMultiplier;
    }

    public void setLootMultiplier(int lootMultiplier) {
        this.lootMultiplier = lootMultiplier;
    }
   
}
