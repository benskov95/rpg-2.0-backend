package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EquipmentItem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private EquipmentItemType type;
    
    private String name;
    private int armor = 0;
    private int stamina = 0;

    private int strength = 0;
    private int agility = 0;
    private int intelligence = 0;
    
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
    
    private String effect = "none";

    public EquipmentItem() {}

    public EquipmentItem(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipmentItemType getType() {
        return type;
    }

    public void setType(EquipmentItemType type) {
        this.type = type;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
    
    
    
}
