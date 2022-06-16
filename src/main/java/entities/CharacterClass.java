package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CharacterClass implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String className;
    
    @OneToMany(mappedBy = "charClass", cascade = CascadeType.PERSIST)
    private List<Ability> abilities;

    public CharacterClass() {}

    public CharacterClass(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
    
}
