
package facades;

import dto.CombatDTO;
import entities.Ability;
import entities.DamageType;
import entities.Enemy;
import entities.PlayerCharacter;
import javax.persistence.EntityManager;
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
    
    public CombatDTO calculatePlayerDamage(CombatDTO combatDto) throws Exception {
        EntityManager em = emf.createEntityManager();
        
        try {
            PlayerCharacter character = em.find(PlayerCharacter.class, combatDto.getPlayerCharId());
            Enemy enemy = em.find(Enemy.class, combatDto.getEnemyId());
            Ability ability = em.find(Ability.class, combatDto.getAbilityId());

            int mainStat = character.getMainStat() >= 1 ? character.getMainStat() : 1;
            int min = (int) (ability.getMinDamage() * (mainStat * 1.2));
            int max = (int) (ability.getMaxDamage() * (mainStat * 1.2));
            
            calculateDotDamage(ability, mainStat, character.getCritChance(), combatDto);

            double critRoll = Math.random() * 100 + 1;
            boolean isCrit = critRoll <= character.getCritChance();
            int abilityDmg = (int) (Math.random() * max + min);
            abilityDmg = isCrit ? abilityDmg * 2 : abilityDmg;

            int finalDmg = finalizeDamageCalculation(abilityDmg, ability.getDmgType(), enemy);
            combatDto.setFinalDmg(finalDmg);
            combatDto.setIsCrit(isCrit);
            return combatDto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Damage calculation failed.");
        }
        finally {
            em.close();
        }
    }
    
    private void calculateDotDamage(Ability ability, int mainStat, double critChance, CombatDTO combatDto) {
        if (ability.getDotDamage() != 0) {
            combatDto.setDotInterval(ability.getDotInterval());
            int noOfTicks = ability.getDotDuration() / ability.getDotInterval();
            for (int i = 0; i <= noOfTicks; i++) {
                double critRoll = Math.random() * 100 + 1;
                boolean isCrit = critRoll <= critChance;
                int tickDmg = (int) (ability.getDotDamage() * (mainStat * 1.2));
                tickDmg = isCrit ? tickDmg * 2 : tickDmg;
                combatDto.getDotValues().add(tickDmg);
            }
        }
    }
    
    private int finalizeDamageCalculation(int dmg, DamageType dmgType, Object target) {
        int reductionVal = dmgType.getType().equals("Physical") ? 40 : 10; // 40 points per % of reduction for armor, 10 points for resistances.
        double stepOne; // have to split the calculation of resistance reduction into two parts, otherwise value becomes 0. Not sure why.
        double stepTwo;
        int res = 0;
        
        try {
            PlayerCharacter character = (PlayerCharacter) target;
            int resistancePoints = character.getResistancePointsByDmgType(dmgType);
            stepOne = resistancePoints / reductionVal;
            stepTwo = (100 - stepOne) / 100;
            res = (int) (dmg * stepTwo);
            res *=  (100 - (character.getAdaptability() / 30)) / 100; // 1% all dmg reduction per 30 points of adaptability
            res *= (100 + (character.getAdaptability() / 20)) / 100; // 1% dmg increase per 20 points of adaptability
        } catch (Exception e) {
            try {
                Enemy enemy = (Enemy) target;
                int resistancePoints = enemy.getResistancePointsByDmgType(dmgType);
                stepOne = resistancePoints / reductionVal;
                stepTwo = (100 - stepOne) / 100;
                res = (int) (dmg * stepTwo);
                res *=  (100 - (enemy.getAdaptability() / 30)) / 100;
                res *= (100 + (enemy.getAdaptability() / 20)) / 100;
            } catch (Exception ex) {
                System.out.println("Provided target type must be PlayerCharacter or Enemy.");
            }
        }
        
        return res;
    }
}
