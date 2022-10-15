
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LootTable implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany
    private List<CurrencyTemplate> currencies = new ArrayList();
    
    @OneToMany
    private List<EquipmentItemTemplate> items = new ArrayList();

    public LootTable() {}

    public LootTable(List<CurrencyTemplate> currencies, List<EquipmentItemTemplate> items) {
        this.currencies = currencies;
        this.items = items;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CurrencyTemplate> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencyTemplate> currencies) {
        this.currencies = currencies;
    }

    public List<EquipmentItemTemplate> getItems() {
        return items;
    }

    public void setItems(List<EquipmentItemTemplate> items) {
        this.items = items;
    }
    
    
    
}
