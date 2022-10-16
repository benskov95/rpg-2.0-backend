package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @OneToOne(cascade = CascadeType.ALL)
    private EquipmentSet equipment;
    
    @OneToOne
    private PlayerLevel playerLevel;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<EquipmentItem> equipmentInventory = new ArrayList();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<ConsumableItem> consumableInventory = new ArrayList();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Currency> currencies = new ArrayList();
    
    private int xpForNextLvl;
    
    private int armor = 0;
    private int stamina = 0;

    private int mainStat;
    
    private int criticalHit = 0;
    private int swiftness = 0;
    private int adaptability = 0;
    
    private int frostResistance = 0;
    private int fireResistance = 0;
    private int shadowResistance = 0;
    private int magicResistance = 0;
    private int natureResistance = 0;
    private int holyResistance = 0;
    private int poisonResistance = 0;
    private int bleedResistance = 0;
    
    public PlayerCharacter() {}

    public PlayerCharacter(String characterName, User user, CharacterClass characterClass, EquipmentSet equipment, PlayerLevel playerLevel, int xpForNextLvl) {
        this.characterName = characterName;
        this.user = user;
        this.characterClass = characterClass;
        this.equipment = equipment;
        this.playerLevel = playerLevel;
        this.xpForNextLvl = xpForNextLvl;
        this.equipmentInventory = new ArrayList();
        this.consumableInventory = new ArrayList();
        this.currencies = new ArrayList();
        
        calculateStats();
    }
    
    private void calculateStats() {
        try {
            equipment.getEquipmentSetAsList().forEach(eItem -> {
                this.armor += eItem.getTemplate().getArmor() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.stamina += eItem.getTemplate().getStamina() * eItem.getEnhancementLvl().getScalingMultiplier();

                this.mainStat += eItem.getTemplate().getMainStat() * eItem.getEnhancementLvl().getScalingMultiplier();

                this.criticalHit += eItem.getTemplate().getCriticalHit() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.swiftness += eItem.getTemplate().getSwiftness() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.adaptability += eItem.getTemplate().getAdaptability() * eItem.getEnhancementLvl().getScalingMultiplier();

                this.frostResistance += eItem.getTemplate().getFrostResistance() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.fireResistance += eItem.getTemplate().getFireResistance() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.shadowResistance += eItem.getTemplate().getShadowResistance() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.natureResistance += eItem.getTemplate().getNatureResistance() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.holyResistance += eItem.getTemplate().getHolyResistance() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.poisonResistance += eItem.getTemplate().getPoisonResistance() * eItem.getEnhancementLvl().getScalingMultiplier();
                this.bleedResistance += eItem.getTemplate().getBleedResistance() * eItem.getEnhancementLvl().getScalingMultiplier();
            });             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public double getCritChance() {
        // every 20 points of crit is 1% crit chance.
        return this.getCriticalHit() / 20; 
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

    public EquipmentSet getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentSet equipment) {
        this.equipment = equipment;
    }

    public PlayerLevel getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(PlayerLevel playerLevel) {
        this.playerLevel = playerLevel;
    }

    public List<EquipmentItem> getEquipmentInventory() {
        return equipmentInventory;
    }

    public void setEquipmentInventory(List<EquipmentItem> equipmentInventory) {
        this.equipmentInventory = equipmentInventory;
    }

    public List<ConsumableItem> getConsumableInventory() {
        return consumableInventory;
    }

    public void setConsumableInventory(List<ConsumableItem> consumableInventory) {
        this.consumableInventory = consumableInventory;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public int getXpForNextLvl() {
        return xpForNextLvl;
    }

    public void setXpForNextLvl(int xpForNextLvl) {
        this.xpForNextLvl = xpForNextLvl;
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

    public int getMagicResistance() {
        return magicResistance;
    }

    public void setMagicResistance(int magicResistance) {
        this.magicResistance = magicResistance;
    }

    public int getNatureResistance() {
        return natureResistance;
    }

    public void setNatureResistance(int lightningResistance) {
        this.natureResistance = lightningResistance;
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
