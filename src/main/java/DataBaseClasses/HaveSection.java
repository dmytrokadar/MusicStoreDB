package DataBaseClasses;

import javax.persistence.*;

@Entity
@Table(name = "have_section", schema = "public", catalog = "kadardmy")
public class HaveSection {
    private int id;
//    private String shop;
    private String section;
    private Shop shopByShop;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "shop")
//    public String getShop() {
//        return shop;
//    }
//
//    public void setShop(String shop) {
//        this.shop = shop;
//    }

    @Basic
    @Column(name = "section")
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HaveSection that = (HaveSection) o;

        if (id != that.id) return false;
//        if (shop != null ? !shop.equals(that.shop) : that.shop != null) return false;
        if (section != null ? !section.equals(that.section) : that.section != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
//        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        result = 31 * result + (section != null ? section.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "shop", referencedColumnName = "location")
    public Shop getShopByShop() {
        return shopByShop;
    }

    public void setShopByShop(Shop shopByShop) {
        this.shopByShop = shopByShop;
    }
}
