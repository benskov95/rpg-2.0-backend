
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Enemy implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private EnemyType type;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ability> abilities;
    
    @OneToOne(cascade = CascadeType.ALL)
    private LootTable lootTable;
    
    private int lvl;
    private int armor = 0;
    private int stamina = 0;

    private int mainStat = 1;
    
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
    
    @Transient
    private HashMap<String, Integer> resistanceMap;
    
    public Enemy() {}

    public Enemy(String name, int lvl, int armor, int stamina, int mainStat, EnemyType type, List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.lvl = lvl;
        this.armor = armor;
        this.stamina = stamina;
        this.type = type;
        this.abilities = abilities;
        this.lootTable = lootTable;
    }
    
    private void fillResistanceMap() {
        this.resistanceMap = new HashMap();
        this.resistanceMap.put("Physical", this.armor);
        this.resistanceMap.put("Bleed", this.bleedResistance);
        this.resistanceMap.put("Fire", this.fireResistance);
        this.resistanceMap.put("Frost", this.frostResistance);
        this.resistanceMap.put("Holy", this.holyResistance);
        this.resistanceMap.put("Magic", this.magicResistance);
        this.resistanceMap.put("Nature", this.natureResistance);
        this.resistanceMap.put("Poison", this.poisonResistance);
        this.resistanceMap.put("Shadow", this.shadowResistance);
    }
    
    public int getResistancePointsByDmgType(DamageType dmgType) {
        if (this.resistanceMap == null) {
            fillResistanceMap();
        }
        return resistanceMap.get(dmgType.getType());
    }
    
//    private List<Currency> generateCurrency(PlayerCharacter player) {
//        List<Currency> currencies = new ArrayList();
//        
//        this.lootTable.getCurrencies().forEach(curTemplate -> {
//            int rand = (int) (Math.random() * 100 + 1);
//            
//            // 50% chance to generate specific currency
//            if (rand <= 50) {        
//                try {
//                    Currency res = player.getCurrencies().stream()
//                            .filter(temp -> Objects.equals(temp, curTemplate))
//                            .collect(Collectors.toList())
//                            .get(0);
//                    
//                    res.setQuanitity(res.getQuanitity() + 10);
//                } catch(Exception e) {
//
//                }
//            }
//        });
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
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
        return (int) (mainStat * 1.2);
    }

    public int getRawMainStat() {
        return mainStat;
    }

    public void setRawMainStat(int mainStat) {
        this.mainStat = mainStat;
    }
    
    public double getCritChance() {
        // every 20 points of crit is 1% crit chance.
        return criticalHit / 20; 
    }

    public int getCriticalHit() {
        return criticalHit;
    }

    public void setCriticalHit(int criticalHit) {
        this.criticalHit = criticalHit;
    }
    
    public int getSwiftnessPercentage() {
        return swiftness / 30; // 1% cd (maybe cast time as well?) reduction per 30 points of swiftness.
    }

    public int getSwiftness() {
        return swiftness;
    }

    public void setSwiftness(int swiftness) {
        this.swiftness = swiftness;
    }
    
    public int getAdapIncrease() {
        return adaptability / 20; // 1% dmg increase per 20 points of adaptability
    }
    
    public int getAdapReduction() {
        return adaptability / 30; // 1% all dmg reduction per 30 points of adaptability
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

    public void setNatureResistance(int natureResistance) {
        this.natureResistance = natureResistance;
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
    
    

    public EnemyType getType() {
        return type;
    }

    public void setType(EnemyType type) {
        this.type = type;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public LootTable getLootTable() {
        return lootTable;
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }
    
}
