package DataBaseClasses;

import javax.persistence.*;

@Entity
public class Supply {
//    private String manufacturer;
    private int product;
    private Manufacturer manufacturerByManufacturer;
    private Product productByProduct;

//    @Basic
//    @Column(name = "manufacturer")
//    public String getManufacturer() {
//        return manufacturer;
//    }
//
//    public void setManufacturer(String manufacturer) {
//        this.manufacturer = manufacturer;
//    }

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

        Supply supply = (Supply) o;

        if (product != supply.product) return false;
//        if (manufacturer != null ? !manufacturer.equals(supply.manufacturer) : supply.manufacturer != null)
//            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = product;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "manufacturer", referencedColumnName = "name", nullable = false)
    public Manufacturer getManufacturerByManufacturer() {
        return manufacturerByManufacturer;
    }

    public void setManufacturerByManufacturer(Manufacturer manufacturerByManufacturer) {
        this.manufacturerByManufacturer = manufacturerByManufacturer;
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
