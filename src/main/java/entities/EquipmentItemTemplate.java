package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EquipmentItemTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private EquipmentItemType equipmentItemType;
    
    @OneToOne
    private ItemQuality quality;
    
    @OneToOne
    private ArmorType armorType;
    
    @OneToOne
    private PlayerLevel levelRequirement;
    
    private int armor;
    private int stamina = 0;

    private int mainStat;
    
    private int criticalHit = 0;
    private int swiftness = 0;
    private int adaptability = 0;
    
    private int frostResistance = 0;
    private int fireResistance = 0;
    private int shadowResistance = 0;
    private int natureResistance = 0;
    private int holyResistance = 0;
    private int poisonResistance = 0;
    private int bleedResistance = 0;
    
    private String effect = "none";

    public EquipmentItemTemplate() {}

    public EquipmentItemTemplate(String name, EquipmentItemType eItemType, ItemQuality quality, ArmorType armorType, PlayerLevel lvlReq) {
        this.name = name;
        this.equipmentItemType = eItemType;
        this.quality = quality;
        this.armorType = armorType;
        this.levelRequirement = lvlReq;
        
        calculateStats();
    }
    
    private void calculateStats() {
        this.armor = this.quality.getQualityMultiplier()
                * this.armorType.getArmorMultiplier() 
                * this.equipmentItemType.getEqTypeMultiplier()
                * this.levelRequirement.getPlayerLevel();
    }

    public EquipmentItemType getEquipmentItemType() {
        return equipmentItemType;
    }

    public void setEquipmentItemType(EquipmentItemType equipmentItemType) {
        this.equipmentItemType = equipmentItemType;
    }

    public ItemQuality getQuality() {
        return quality;
    }

    public void setQuality(ItemQuality quality) {
        this.quality = quality;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public PlayerLevel getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(PlayerLevel levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
    
    
    
}
