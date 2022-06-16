package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Ability implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    private String abilityId;
    
    @ManyToOne
    private CharacterClass charClass;
    
    @OneToOne
    private PlayerLevel levelRequirement;
    
    private String abilityName;
    private int minDamage;
    private int maxDamage;
    private int dotDamage;
    private int dotDuration;
    private int cooldownMs;
    
    public Ability() {}

    public Ability(String abilityId, CharacterClass charClass, PlayerLevel lvlReq, String abilityName, int minDamage, int maxDamage, int dotDamage, int dotDuration, int cooldownMs) {
        this.abilityId = abilityId;
        this.charClass = charClass;
        this.levelRequirement = lvlReq;
        this.abilityName = abilityName;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.dotDamage = dotDamage;
        this.dotDuration = dotDuration;
        this.cooldownMs = cooldownMs;
    }

    public String getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(String abilityId) {
        this.abilityId = abilityId;
    }

    public CharacterClass getCharClass() {
        return charClass;
    }

    public void setCharClass(CharacterClass charClass) {
        this.charClass = charClass;
    }

    public PlayerLevel getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(PlayerLevel levelRequirement) {
        this.levelRequirement = levelRequirement;
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

    public int getDotDuration() {
        return dotDuration;
    }

    public void setDotDuration(int dotDuration) {
        this.dotDuration = dotDuration;
    }
    
    public int getCooldownMs() {
        return cooldownMs;
    }

    public void setCooldownMs(int cooldownMs) {
        this.cooldownMs = cooldownMs;
    }  
    
}
