package DataBaseClasses;

import javax.persistence.*;

@Entity
@Table(name = "have_product", schema = "public", catalog = "kadardmy")
public class HaveProduct {
    private String section;
    private int product;
    private Product productByProduct;

    @Basic
    @Column(name = "section")
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Id
    @Column(name = "product")
    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HaveProduct that = (HaveProduct) o;

        if (product != that.product) return false;
        if (section != null ? !section.equals(that.section) : that.section != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = section != null ? section.hashCode() : 0;
        result = 31 * result + product;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "product", referencedColumnName = "number", nullable = false)
    public Product getProductByProduct() {
        return productByProduct;
    }

    public void setProductByProduct(Product productByProduct) {
        this.productByProduct = productByProduct;
    }
}
