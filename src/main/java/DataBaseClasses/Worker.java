package DataBaseClasses;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Worker extends Person {
//    private String eMail;
//    private int id;
//    private String shop;
    private String position;
    private int salary;
    private Collection<Order> ordersById;
    private Collection<Supervisor> supervisorsById;
    private Collection<Supervisor> supervisedById;
    private Supervisor supervisorById;
    private Person personById;
    private Shop shopByShop;

//    @Basic
//    @Column(name = "e_mail")
//    public String geteMail() {
//        return eMail;
//    }

//    public void seteMail(String eMail) {
//        this.eMail = eMail;
//    }

//    @Id
//    @Column(name = "id")
//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
    @Column(name = "e_mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

//        if (id != worker.id) return false;
        if (salary != worker.salary) return false;
//        if (eMail != null ? !eMail.equals(worker.eMail) : worker.eMail != null) return false;
//        if (shop != null ? !shop.equals(worker.shop) : worker.shop != null) return false;
        if (position != null ? !position.equals(worker.position) : worker.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
//        int result = eMail != null ? eMail.hashCode() : 0;
//        result = 31 * result + id;
//        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        int result = (position != null ? position.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }

    @OneToMany(mappedBy = "workerByProcessedBy")
    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }

    @ManyToMany(mappedBy = "workerByUpperPosition")
    public Collection<Supervisor> getSupervisorsById() {
        return supervisorsById;
    }

    public void setSupervisorsById(Collection<Supervisor> supervisorsById) {
        this.supervisorsById = supervisorsById;
    }

    @ManyToMany(mappedBy = "workerByLowerPosition")
    public Collection<Supervisor> getSupervisedById() {
        return supervisedById;
    }

    public void setSupervisedById(Collection<Supervisor> supervisedById) {
        this.supervisedById = supervisedById;
    }

//    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    public Person getPersonById() {
        return personById;
    }

    public void setPersonById(Person personById) {
        this.personById = personById;
    }

    @ManyToOne
    @JoinColumn(name = "shop", referencedColumnName = "location")
    public Shop getShopByShop() {
        return shopByShop;
    }

    public void setShopByShop(Shop shopByShop) {
        this.shopByShop = shopByShop;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "eMail='" + eMail + '\'' +
                ", id=" + id +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", supervisorsById=" + supervisorsById +
                ", supervisedById=" + supervisedById +
                ", personById=" + personById +
                ", shopByShop=" + shopByShop +
                '}';
    }
}
