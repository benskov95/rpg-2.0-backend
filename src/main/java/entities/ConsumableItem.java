
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ConsumableItem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private PlayerCharacter owner;
    
    @ManyToOne
    private ConsumableItemTemplate template;
    
    private int quantity;

    public ConsumableItem() {}

    public ConsumableItem(ConsumableItemTemplate template, int quantity) {
        this.template = template;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerCharacter getOwner() {
        return owner;
    }

    public void setOwner(PlayerCharacter owner) {
        this.owner = owner;
    }
    
    public ConsumableItemTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ConsumableItemTemplate template) {
        this.template = template;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }   
    
}
