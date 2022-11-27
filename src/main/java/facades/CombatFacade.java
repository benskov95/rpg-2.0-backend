
package facades;

import dto.DamageEventDTO;
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
    
    public DamageEventDTO calculateDamage(DamageEventDTO damageDto) throws Exception { 
        EntityManager em = emf.createEntityManager();
        
        try {
            PlayerCharacter character = em.find(PlayerCharacter.class, damageDto.getPlayerCharId());
            Enemy enemy = em.find(Enemy.class, damageDto.getEnemyId());
            Ability ability = em.find(Ability.class, damageDto.getAbilityId());
            
            Object caster;
            Object target;
            int mainStat;
            int min;
            int max;
            boolean isCrit;
            double critChance;
            double critRoll = Math.random() * 100 + 1;
            
            switch(damageDto.getInitiatorType()) {
                case "player":
                    caster = character;
                    target = enemy;
                    mainStat = character.getMainStat();
                    min = (int) (ability.getMinDamage() * (mainStat));
                    max = (int) (ability.getMaxDamage() * (mainStat));
                    critChance = character.getCritChance();
                    isCrit = critRoll <= critChance;
                    break;
                case "enemy":
                    caster = enemy;
                    target = character;
                    mainStat = enemy.getMainStat();
                    min = (int) (ability.getMinDamage() * mainStat);
                    max = (int) (ability.getMaxDamage() * mainStat);
                    critChance = enemy.getCritChance();
                    isCrit = critRoll <= critChance;
                    break;
                default:
                    throw new Exception("Incorrect initiator type provided.");
            }

            int abilityDmg = (int) (Math.random() * max + min);
            abilityDmg = isCrit ? abilityDmg * 2 : abilityDmg;

            int directDmg = finalizeDamageCalculation(abilityDmg, ability.getDmgType(), caster, target);
            calculateDotDamage(ability, caster, target, mainStat, critChance, damageDto);
            damageDto.setDirectDmg(directDmg);
            damageDto.setIsCrit(isCrit);
            return damageDto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Damage calculation failed.");
        }
        finally {
            em.close();
        }
    }
    
    private void calculateDotDamage(Ability ability, Object caster, Object target, int mainStat, double critChance, DamageEventDTO damageDto) {
        if (ability.getDotDamage() != 0) {
            damageDto.setDotInterval(ability.getDotInterval());
            int noOfTicks = ability.getDotDuration() / ability.getDotInterval();
            
            for (int i = 0; i <= noOfTicks; i++) {
                double critRoll = Math.random() * 100 + 1;
                boolean isCrit = critRoll <= critChance;
                int tickDmg = (int) (ability.getDotDamage() * mainStat);
                int finalTickDmg = finalizeDamageCalculation(tickDmg, ability.getDmgType(), caster, target);
                finalTickDmg = isCrit ? finalTickDmg * 2 : finalTickDmg;
                damageDto.getDotValues().add(finalTickDmg);
            }
        }
    }
    
    private int finalizeDamageCalculation(int dmg, DamageType dmgType, Object caster, Object target) {
        double stepOne; // have to split the calculation of resistance reduction into two parts, otherwise result value becomes 0. Not sure why.
        double stepTwo;
        int res = 0;
        
        try {
            Enemy enemy = (Enemy) caster;
            PlayerCharacter character = (PlayerCharacter) target;
            int resistancePoints = character.getResistancePointsByDmgType(dmgType);
            stepOne = resistancePoints / dmgType.getReductionVal();
            stepTwo = (100 - stepOne) / 100;
            res = (int) (dmg * stepTwo);
            res *=  (100 - character.getAdapReduction()) / 100; 
            res *= (100 + enemy.getAdapIncrease()) / 100; 
        } catch (Exception e) {
            try {
                PlayerCharacter character = (PlayerCharacter) caster;
                Enemy enemy = (Enemy) target;
                int resistancePoints = enemy.getResistancePointsByDmgType(dmgType);
                stepOne = resistancePoints / dmgType.getReductionVal();
                stepTwo = (100 - stepOne) / 100;
                res = (int) (dmg * stepTwo);
                res *=  (100 - enemy.getAdapReduction()) / 100;
                res *= (100 + character.getAdapIncrease()) / 100;
            } catch (Exception ex) {
                System.out.println("Provided target type must be PlayerCharacter or Enemy.");
            }
        }
        
        return res;
    }
}
