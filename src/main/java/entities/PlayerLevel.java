package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlayerLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private int playerLevel;
    
    private int requiredXp;

    public PlayerLevel() {}

    public PlayerLevel(int playerLevel, int requiredXp) {
        this.playerLevel = playerLevel;
        this.requiredXp = requiredXp;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getRequiredXp() {
        return requiredXp;
    }

    public void setRequiredXp(int requiredXp) {
        this.requiredXp = requiredXp;
    }  
    
}
