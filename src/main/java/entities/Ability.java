package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ability implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String abilityId;
    
    // nullable so I can store enemy abilities in same table
    @ManyToOne
    @JoinColumn(nullable = true)
    private CharacterClass charClass;
    
    @OneToOne
    private PlayerLevel levelRequirement;
    
    @OneToOne
    @JoinColumn(nullable = true)
    private DamageType dmgType;

    private String abilityName;
    private int minDamage;
    private int maxDamage;
    private int dotDamage;
    private int dotDuration;
    private int dotInterval;
    private int cooldown;
    
    public Ability() {}

    public Ability(String abilityId, CharacterClass charClass, PlayerLevel lvlReq, DamageType dmgType, String abilityName, int minDamage, int maxDamage, int dotDamage, int dotDuration, int dotInterval, int cooldownMs) {
        this.abilityId = abilityId;
        this.charClass = charClass;
        this.levelRequirement = lvlReq;
        this.dmgType = dmgType;
        this.abilityName = abilityName;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.dotDamage = dotDamage;
        this.dotDuration = dotDuration;
        this.dotInterval = dotInterval;
        this.cooldown = cooldownMs;
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

    public DamageType getDmgType() {
        return dmgType;
    }

    public void setDmgType(DamageType dmgType) {
        this.dmgType = dmgType;
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

    public int getDotInterval() {
        return dotInterval;
    }

    public void setDotInterval(int dotInterval) {
        this.dotInterval = dotInterval;
    }
    
    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldownMs) {
        this.cooldown = cooldownMs;
    }  
    
}
