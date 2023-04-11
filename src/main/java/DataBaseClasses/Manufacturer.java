package DataBaseClasses;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Manufacturer {
    private String name;
    private String productTypes;
    private Collection<Supply> suppliesByName;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "product_types")
    public String getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(String productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (productTypes != null ? !productTypes.equals(that.productTypes) : that.productTypes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (productTypes != null ? productTypes.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "manufacturerByManufacturer")
    public Collection<Supply> getSuppliesByName() {
        return suppliesByName;
    }

    public void setSuppliesByName(Collection<Supply> suppliesByName) {
        this.suppliesByName = suppliesByName;
    }
}
