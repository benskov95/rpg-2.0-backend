
package dto;

import java.util.ArrayList;
import java.util.List;

public class CombatDTO {
    
    private String playerCharId;
    private String enemyId;
    private String abilityId;
    private int finalDmg;
    private boolean isCrit;
    private List<Integer> dotValues;
    private int dotInterval;

    public CombatDTO() {
        this.dotValues = new ArrayList();
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

    public int getFinalDmg() {
        return finalDmg;
    }

    public void setFinalDmg(int finalDmg) {
        this.finalDmg = finalDmg;
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
