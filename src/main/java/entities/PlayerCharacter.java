package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PlayerCharacter implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;
    
    @OneToOne
    private CharacterClass characterClass;
    
    @OneToOne(mappedBy = "character")
    private Equipment equipment;
    
    private String characterName;
    private int level;
    private int currentLevelXp;
    // add resources (hp, mana/rage etc)
    
    public PlayerCharacter() {}

    public PlayerCharacter(String characterName, User user, CharacterClass characterClass, Equipment equipment) {
        this.characterName = characterName;
        this.user = user;
        this.characterClass = characterClass;
        this.equipment = equipment;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    
}
