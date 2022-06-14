package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ability implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String abilityId;
    
    @ManyToOne
    private CharacterClass className;
    
    private String abilityName;
    private int minDamage;
    private int maxDamage;
    private int dotDamage;
    private int cooldownMs;
    
    public Ability() {}

    public Ability(String abilityId, CharacterClass className, String abilityName, int minDamage, int maxDamage, int dotDamage, int cooldownMs) {
        this.abilityId = abilityId;
        this.className = className;
        this.abilityName = abilityName;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.dotDamage = dotDamage;
        this.cooldownMs = cooldownMs;
    }

    public String getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(String abilityId) {
        this.abilityId = abilityId;
    }

    public CharacterClass getClassName() {
        return className;
    }

    public void setClassName(CharacterClass className) {
        this.className = className;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getDotDamage() {
        return dotDamage;
    }

    public void setDotDamage(int dotDamage) {
        this.dotDamage = dotDamage;
    }

    public int getCooldownMs() {
        return cooldownMs;
    }

    public void setCooldownMs(int cooldownMs) {
        this.cooldownMs = cooldownMs;
    }  
    
}
