package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PlayerCharacter implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "character_name", length = 20)
    private String characterName;
    
    @ManyToOne
    private User user;

    @OneToOne
    private CharacterClass characterClass;
    
    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    private Equipment equipment;
    
    @OneToOne
    private PlayerLevel playerLevel;
    
    private int totalXp;
    
    private int armor = 0;
    private int stamina = 0;

    private int mainStat;
    
    private int criticalHit = 0;
    private int swiftness = 0;
    private int adaptability = 0;
    
    private int frostResistance = 0;
    private int fireResistance = 0;
    private int shadowResistance = 0;
    private int lightningResistance = 0;
    private int holyResistance = 0;
    private int poisonResistance = 0;
    private int bleedResistance = 0;
    
    public PlayerCharacter() {}

    public PlayerCharacter(String characterName, User user, CharacterClass characterClass, Equipment equipment, PlayerLevel playerLevel, int totalXp) {
        this.characterName = characterName;
        this.user = user;
        this.characterClass = characterClass;
        this.equipment = equipment;
        this.playerLevel = playerLevel;
        this.totalXp = totalXp;
        
        calculateStats();
    }
    
    private void calculateStats() {
        equipment.getItemList().forEach(eItem -> {
            this.armor += eItem.getArmor();
            this.stamina += eItem.getStamina();
            
            this.mainStat += eItem.getMainStat();
            
            this.criticalHit += eItem.getCriticalHit();
            this.swiftness += eItem.getSwiftness();
            this.adaptability += eItem.getAdaptability();
            
            this.frostResistance += eItem.getFrostResistance();
            this.fireResistance += eItem.getFireResistance();
            this.shadowResistance += eItem.getShadowResistance();
            this.lightningResistance += eItem.getLightningResistance();
            this.holyResistance += eItem.getHolyResistance();
            this.poisonResistance += eItem.getPoisonResistance();
            this.bleedResistance += eItem.getBleedResistance();
        });
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public PlayerLevel getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(PlayerLevel playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getTotalXp() {
        return totalXp;
    }

    public void setTotalXp(int totalXp) {
        this.totalXp = totalXp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMainStat() {
        return mainStat;
    }

    public void setMainStat(int mainStat) {
        this.mainStat = mainStat;
    }

    public int getCriticalHit() {
        return criticalHit;
    }

    public void setCriticalHit(int criticalHit) {
        this.criticalHit = criticalHit;
    }

    public int getSwiftness() {
        return swiftness;
    }

    public void setSwiftness(int swiftness) {
        this.swiftness = swiftness;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public int getFrostResistance() {
        return frostResistance;
    }

    public void setFrostResistance(int frostResistance) {
        this.frostResistance = frostResistance;
    }

    public int getFireResistance() {
        return fireResistance;
    }

    public void setFireResistance(int fireResistance) {
        this.fireResistance = fireResistance;
    }

    public int getShadowResistance() {
        return shadowResistance;
    }

    public void setShadowResistance(int shadowResistance) {
        this.shadowResistance = shadowResistance;
    }

    public int getLightningResistance() {
        return lightningResistance;
    }

    public void setLightningResistance(int lightningResistance) {
        this.lightningResistance = lightningResistance;
    }

    public int getHolyResistance() {
        return holyResistance;
    }

    public void setHolyResistance(int holyResistance) {
        this.holyResistance = holyResistance;
    }

    public int getPoisonResistance() {
        return poisonResistance;
    }

    public void setPoisonResistance(int poisonResistance) {
        this.poisonResistance = poisonResistance;
    }

    public int getBleedResistance() {
        return bleedResistance;
    }

    public void setBleedResistance(int bleedResistance) {
        this.bleedResistance = bleedResistance;
    }
    
    
}
