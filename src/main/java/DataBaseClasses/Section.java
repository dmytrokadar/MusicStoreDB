package DataBaseClasses;

import javax.persistence.*;

@Entity
@IdClass(SectionPK.class)
public class Section {
    private String shop;
    private String name;
    private HaveProduct haveProductByName;
    private HaveSection haveSectionByName;
    private Shop shopByShop;

    @Id
    @Column(name = "shop")
    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    @Id
    @Column(name = "name")
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

        Section section = (Section) o;

        if (shop != null ? !shop.equals(section.shop) : section.shop != null) return false;
        if (name != null ? !name.equals(section.name) : section.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shop != null ? shop.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "name", referencedColumnName = "section", nullable = false, insertable=false, updatable=false)
    public HaveProduct getHaveProductByName() {
        return haveProductByName;
    }

    public void setHaveProductByName(HaveProduct haveProductByName) {
        this.haveProductByName = haveProductByName;
    }

    @ManyToOne
    @JoinColumn(name = "name", referencedColumnName = "section", nullable = false, insertable=false, updatable=false)
    public HaveSection getHaveSectionByName() {
        return haveSectionByName;
    }

    public void setHaveSectionByName(HaveSection haveSectionByName) {
        this.haveSectionByName = haveSectionByName;
    }

    @ManyToOne
    @JoinColumn(name = "shop", referencedColumnName = "location", nullable = false, insertable=false, updatable=false)
    public Shop getShopByShop() {
        return shopByShop;
    }

    public void setShopByShop(Shop shopByShop) {
        this.shopByShop = shopByShop;
    }
}
