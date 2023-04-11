package DataBaseClasses;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SectionPK implements Serializable {
    private String shop;
    private String name;

    @Column(name = "shop")
    @Id
    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    @Column(name = "name")
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionPK sectionPK = (SectionPK) o;

        if (shop != null ? !shop.equals(sectionPK.shop) : sectionPK.shop != null) return false;
        if (name != null ? !name.equals(sectionPK.name) : sectionPK.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shop != null ? shop.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
