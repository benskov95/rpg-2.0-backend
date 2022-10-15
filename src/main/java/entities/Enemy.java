
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enemy implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String name;
    
    private int lvl;
    private int armor;
    private int stamina;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private EnemyType type;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ability> abilities;
    
    @OneToMany(cascade = CascadeType.ALL)
    private LootTable lootTable;

    public Enemy() {}

    public Enemy(String name, int lvl, int armor, int stamina, EnemyType type, List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.lvl = lvl;
        this.armor = armor;
        this.stamina = stamina;
        this.type = type;
        this.abilities = abilities;
        this.lootTable = lootTable;
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
