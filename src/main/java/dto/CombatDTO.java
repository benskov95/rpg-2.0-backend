
package dto;

public class CombatDTO {
    
    private String playerCharId;
    private String enemyId;
    private String abilityId;
    private int finalDmg;

    public CombatDTO() {}

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
    
}
