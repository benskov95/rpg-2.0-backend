
package dto;

import java.util.ArrayList;
import java.util.List;

public class DamageEventDTO {
    
    private String initiatorType;
    private String playerCharId;
    private String enemyId;
    private String abilityId;
    private int directDmg;
    private boolean isCrit;
    private List<Integer> dotValues;
    private int dotInterval;

    public DamageEventDTO() {
        this.dotValues = new ArrayList();
    }

    public String getInitiatorType() {
        return initiatorType;
    }

    public void setInitiatorType(String initiatorType) {
        this.initiatorType = initiatorType;
    }

    public String getPlayerCharId() {
        return playerCharId;
    }

    public void setPlayerCharId(String playerCharId) {
        this.playerCharId = playerCharId;
    }

    public String getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(String enemyId) {
        this.enemyId = enemyId;
    }

    public String getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(String abilityId) {
        this.abilityId = abilityId;
    }

    public int getDirectDmg() {
        return directDmg;
    }

    public void setDirectDmg(int finalDmg) {
        this.directDmg = finalDmg;
    }

    public boolean isIsCrit() {
        return isCrit;
    }

    public void setIsCrit(boolean isCrit) {
        this.isCrit = isCrit;
    }

    public List<Integer> getDotValues() {
        return dotValues;
    }

    public void setDotValues(List<Integer> dotValues) {
        this.dotValues = dotValues;
    }

    public int getDotInterval() {
        return dotInterval;
    }

    public void setDotInterval(int dotInterval) {
        this.dotInterval = dotInterval;
    }
    
}
