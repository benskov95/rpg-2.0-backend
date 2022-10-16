
package facades;

import entities.Ability;
import entities.DamageType;
import entities.Enemy;
import entities.PlayerCharacter;
import javax.persistence.EntityManagerFactory;

public class CombatFacade {
    
    private static EntityManagerFactory emf;
    private static CombatFacade instance;

    private CombatFacade() {}

    public static CombatFacade getCombatFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CombatFacade();
        }
        return instance;
    }
    
    public void calculatePlayerDamage(PlayerCharacter character, Enemy enemy, Ability ability) {
        int min = (int) (ability.getMinDamage() * character.getMainStat() * 2.5);
        int max = (int) (ability.getMaxDamage() * character.getMainStat() * 2.5);
        
        int critRoll = (int) (Math.random() * 100 + 1);
        boolean isCrit = critRoll <= character.getCritChance();
        int dmgTotal = (int) (isCrit ? (Math.random() * max + min) * 2 : (Math.random() * max + min));
        
        int dmgFinal = calculateDamageReduction(dmgTotal, ability.getDmgType(), enemy);
    }
    
    public int calculateDamageReduction(double dmg, DamageType dmgType, Object target) {
        PlayerCharacter character = null;
        Enemy enemy = null;
        int resistanceReductionVal = 10; // every 10 resistance points reduces damage of that type by 1%.
        int armorReductionVal = 40;
        int res = 0;
        
        try {
            character = (PlayerCharacter) target;
        } catch (Exception e) {
            try {
                enemy = (Enemy) target;
            } catch (Exception ex) {
                System.out.println("Provided target is neither PlayerCharacter nor Enemy");
            }
        }
        
        switch(dmgType.getType()) {
            case "Physical":
                res = (int) (character != null 
                        ? dmg - (character.getArmor() / armorReductionVal)
                        : dmg - (enemy.getArmor() / armorReductionVal));
                return res;
            case "Bleed":
                res = (int) (character != null 
                        ? dmg - (character.getBleedResistance() / resistanceReductionVal)
                        : dmg - (enemy.getBleedResistance() / resistanceReductionVal));
                return res;
            case "Fire":
                res = (int) (character != null 
                        ? dmg - (character.getFireResistance() / resistanceReductionVal)
                        : dmg - (enemy.getFireResistance() / resistanceReductionVal));
                return res;
            case "Frost":
                res = (int) (character != null 
                        ? dmg - (character.getFrostResistance() / resistanceReductionVal)
                        : dmg - (enemy.getFrostResistance() / resistanceReductionVal));
                return res;
            case "Holy":
                res = (int) (character != null 
                        ? dmg - (character.getHolyResistance() / resistanceReductionVal)
                        : dmg - (enemy.getHolyResistance() / resistanceReductionVal));
                return res;
            case "Magic":
                res = (int) (character != null 
                        ? dmg - (character.getMagicResistance() / resistanceReductionVal)
                        : dmg - (enemy.getMagicResistance() / resistanceReductionVal));
                return res;
            case "Nature":
                res = (int) (character != null 
                        ? dmg - (character.getNatureResistance() / resistanceReductionVal)
                        : dmg - (enemy.getNatureResistance() / resistanceReductionVal));
                return res;
            case "Poison":
                res = (int) (character != null 
                        ? dmg - (character.getPoisonResistance() / resistanceReductionVal)
                        : dmg - (enemy.getPoisonResistance() / resistanceReductionVal));
                return res;
            case "Shadow":
                res = (int) (character != null 
                        ? dmg - (character.getShadowResistance() / resistanceReductionVal)
                        : dmg - (enemy.getShadowResistance() / resistanceReductionVal));
                return res;
            default:
                break;
        }
        
        return res;
    }
}
