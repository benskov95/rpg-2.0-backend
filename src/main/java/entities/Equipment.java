package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private PlayerCharacter character;
    
    @OneToMany
    private List<EquipmentItem> itemList;

    public Equipment() {}

    public Equipment(PlayerCharacter character, List<EquipmentItem> itemList) {
        this.character = character;
        this.itemList = itemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

    public void setCharacter(PlayerCharacter character) {
        this.character = character;
    }

    public List<EquipmentItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<EquipmentItem> itemList) {
        this.itemList = itemList;
    }

}
