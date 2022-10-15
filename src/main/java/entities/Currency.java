
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private PlayerCharacter owner;
    
    @OneToMany
    private CurrencyTemplate template;
    
    private int quanitity;

    public Currency() {}

    public Currency(CurrencyTemplate template, int quanitity) {
        this.template = template;
        this.quanitity = quanitity;
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
    
    public CurrencyTemplate getTemplate() {
        return template;
    }

    public void setTemplate(CurrencyTemplate template) {
        this.template = template;
    }

    public int getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(int quanitity) {
        this.quanitity = quanitity;
    }
    
}
