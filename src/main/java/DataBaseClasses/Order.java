package DataBaseClasses;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Order {
    private Integer date;
    private int product;
    private Integer processedBy;
    private Product productByProduct;
    private Worker workerByProcessedBy;
//    private Collection<MakeOrder> makeOrdersByProduct;
    private Collection<Process> processesByProduct;

    @Basic
    @Column(name = "date")
    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Id
    @Column(name = "product")
    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    @Basic
    @Column(name = "processed_by")
    public Integer getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (product != order.product) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (processedBy != null ? !processedBy.equals(order.processedBy) : order.processedBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + product;
        result = 31 * result + (processedBy != null ? processedBy.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "processed_by", referencedColumnName = "id", insertable=false, updatable=false)
    public Worker getWorkerByProcessedBy() {
        return workerByProcessedBy;
    }

    public void setWorkerByProcessedBy(Worker workerByProcessedBy) {
        this.workerByProcessedBy = workerByProcessedBy;
    }

    // розкоментити аж шось
//    @OneToMany(mappedBy = "orderByOrder")
//    public Collection<MakeOrder> getMakeOrdersByProduct() {
//        return makeOrdersByProduct;
//    }
//
//    public void setMakeOrdersByProduct(Collection<MakeOrder> makeOrdersByProduct) {
//        this.makeOrdersByProduct = makeOrdersByProduct;
//    }
//
//    @OneToMany(mappedBy = "orderByOrder")
//    public Collection<Process> getProcessesByProduct() {
//        return processesByProduct;
//    }

    public void setProcessesByProduct(Collection<Process> processesByProduct) {
        this.processesByProduct = processesByProduct;
    }
}
