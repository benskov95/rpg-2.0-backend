
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EquipmentItem implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private EquipmentItemTemplate template;
    
    @ManyToOne
    private EnhancementLevel enhancementLvl;

    public EquipmentItem() {}

    public EquipmentItem(EquipmentItemTemplate template, EnhancementLevel enhancementLvl) {
        this.template = template;
        this.enhancementLvl = enhancementLvl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EquipmentItemTemplate getTemplate() {
        return template;
    }

    public void setTemplate(EquipmentItemTemplate template) {
        this.template = template;
    }

    public EnhancementLevel getEnhancementLvl() {
        return enhancementLvl;
    }

    public void setEnhancementLvl(EnhancementLevel enhancementLvl) {
        this.enhancementLvl = enhancementLvl;
    }
    
}
