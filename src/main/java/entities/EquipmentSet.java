
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EquipmentSet implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    private PlayerCharacter character;
    
    @OneToOne
    private EquipmentItem helmet;
    @OneToOne
    private EquipmentItem necklace;
    @OneToOne
    private EquipmentItem cloak;
    @OneToOne
    private EquipmentItem chest;
    @OneToOne
    private EquipmentItem bracers;
    @OneToOne
    private EquipmentItem gloves;
    @OneToOne
    private EquipmentItem belt;
    @OneToOne
    private EquipmentItem legs;
    @OneToOne
    private EquipmentItem boots;
    @OneToOne
    private EquipmentItem ring;
    @OneToOne
    private EquipmentItem weapon;

    public EquipmentSet() {}

    public EquipmentSet(EquipmentItem helmet, EquipmentItem necklace, EquipmentItem cloak, EquipmentItem chest, EquipmentItem bracers, EquipmentItem gloves, EquipmentItem belt, EquipmentItem legs, EquipmentItem boots, EquipmentItem ring, EquipmentItem weapon) {
        this.helmet = helmet;
        this.necklace = necklace;
        this.cloak = cloak;
        this.chest = chest;
        this.bracers = bracers;
        this.gloves = gloves;
        this.belt = belt;
        this.legs = legs;
        this.boots = boots;
        this.ring = ring;
        this.weapon = weapon;
    }
    
    public List<EquipmentItem> getEquipmentSetAsList() {
        List<EquipmentItem> eList = new ArrayList();
        eList.add(helmet);
        eList.add(necklace);
        eList.add(cloak);
        eList.add(chest);
        eList.add(bracers);
        eList.add(gloves);
        eList.add(belt);
        eList.add(legs);
        eList.add(boots);
        eList.add(ring);
        eList.add(weapon);
        return eList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

    public void setCharacter(PlayerCharacter character) {
        this.character = character;
    }

    public EquipmentItem getHelmet() {
        return helmet;
    }

    public void setHelmet(EquipmentItem helmet) {
        this.helmet = helmet;
    }

    public EquipmentItem getNecklace() {
        return necklace;
    }

    public void setNecklace(EquipmentItem necklace) {
        this.necklace = necklace;
    }

    public EquipmentItem getCloak() {
        return cloak;
    }

    public void setCloak(EquipmentItem cloak) {
        this.cloak = cloak;
    }

    public EquipmentItem getChest() {
        return chest;
    }

    public void setChest(EquipmentItem chest) {
        this.chest = chest;
    }

    public EquipmentItem getBracers() {
        return bracers;
    }

    public void setBracers(EquipmentItem bracers) {
        this.bracers = bracers;
    }

    public EquipmentItem getGloves() {
        return gloves;
    }

    public void setGloves(EquipmentItem gloves) {
        this.gloves = gloves;
    }

    public EquipmentItem getBelt() {
        return belt;
    }

    public void setBelt(EquipmentItem belt) {
        this.belt = belt;
    }

    public EquipmentItem getLegs() {
        return legs;
    }

    public void setLegs(EquipmentItem legs) {
        this.legs = legs;
    }

    public EquipmentItem getBoots() {
        return boots;
    }

    public void setBoots(EquipmentItem boots) {
        this.boots = boots;
    }

    public EquipmentItem getRing() {
        return ring;
    }

    public void setRing(EquipmentItem ring) {
        this.ring = ring;
    }

    public EquipmentItem getWeapon() {
        return weapon;
    }

    public void setWeapon(EquipmentItem weapon) {
        this.weapon = weapon;
    }
    
    

}
