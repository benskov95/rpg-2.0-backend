
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EnhancementLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private int enhLvl;
    
    private double scalingMultiplier;
    private double chance;

    public EnhancementLevel() {}

    public EnhancementLevel(int level) {
        this.enhLvl = level;
        calcScaling();
        calcChance();
    }
    
    private void calcScaling() {
        switch(this.enhLvl) {
            case 0:
                this.scalingMultiplier = 1;
                break;
            case 1:
                this.scalingMultiplier = 1.25;
                break;
            default:
                this.scalingMultiplier = this.enhLvl * 0.75;
                break;
        }
    }
    
    private void calcChance() {
        double chanceCalc = 100 - (Math.pow(this.enhLvl, 2) * 1.1); 
        if (chanceCalc < 0) {
            this.chance = 1.5;
            return;
        }
        this.chance = chanceCalc;
    }
    
    public int getEnhLvl() {
        return enhLvl;
    }

    public void setEnhLvl(int level) {
        this.enhLvl = level;
    }

    public double getScalingMultiplier() {
        return scalingMultiplier;
    }

    public void setScalingMultiplier(double scalingValue) {
        this.scalingMultiplier = scalingValue;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }
    
    
    
    
}
