package DataBaseClasses;

import javax.persistence.*;

@Entity
public class Product {
    private int number;
    private String material;
    private String size;
    private String type;
    private String manufacturer;
    private String name;
    private int yearManufactured;
    private int price;
//    private Order orderByNumber;
    private HaveProduct haveProductByNumber;
    private Supply supplyByNumber;

    @Id
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "year_manufactured")
    public int getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(int yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (number != product.number) return false;
        if (yearManufactured != product.yearManufactured) return false;
        if (price != product.price) return false;
        if (material != null ? !material.equals(product.material) : product.material != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        if (manufacturer != null ? !manufacturer.equals(product.manufacturer) : product.manufacturer != null)
            return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + yearManufactured;
        result = 31 * result + price;
        return result;
    }

//    @OneToOne(mappedBy = "productByProduct")
//    public Order getOrderByNumber() {
//        return orderByNumber;
//    }
//
//    public void setOrderByNumber(Order orderByNumber) {
//        this.orderByNumber = orderByNumber;
//    }

    @OneToOne(mappedBy = "productByProduct")
    public HaveProduct getHaveProductByNumber() {
        return haveProductByNumber;
    }

    public void setHaveProductByNumber(HaveProduct haveProductByNumber) {
        this.haveProductByNumber = haveProductByNumber;
    }

    @OneToOne(mappedBy = "productByProduct")
    public Supply getSupplyByNumber() {
        return supplyByNumber;
    }

    public void setSupplyByNumber(Supply supplyByNumber) {
        this.supplyByNumber = supplyByNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "number=" + number +
                ", material='" + material + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", yearManufactured=" + yearManufactured +
                ", price=" + price +
                '}';
    }
}
