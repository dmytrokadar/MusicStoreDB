package DataBaseClasses;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    protected String eMail;
    protected int id;
    protected String firstName;
    protected String lastName;
//    private Customer customerByEMail;
    private Collection<Customer> customersById;
//    private Worker workerByEMail;
    private Worker workerById;

    @Basic
    @Column(name = "e_mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (eMail != null ? !eMail.equals(person.eMail) : person.eMail != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eMail != null ? eMail.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "e_mail", referencedColumnName = "e_mail", nullable = false)
//    public Customer getCustomerByEMail() {
//        return customerByEMail;
//    }
//
//    public void setCustomerByEMail(Customer customerByEMail) {
//        this.customerByEMail = customerByEMail;
//    }

    // розкоментити аж шось
//    @OneToMany(mappedBy = "personById")
//    public Collection<Customer> getCustomersById() {
//        return customersById;
//    }

    public void setCustomersById(Collection<Customer> customersById) {
        this.customersById = customersById;
    }

//    @ManyToOne
//    @JoinColumn(name = "e_mail", referencedColumnName = "e_mail", nullable = false)
//    public Worker getWorkerByEMail() {
//        return workerByEMail;
//    }
//
//    public void setWorkerByEMail(Worker workerByEMail) {
//        this.workerByEMail = workerByEMail;
//    }

    @OneToOne(mappedBy = "personById")
    public Worker getWorkerById() {
        return workerById;
    }

    public void setWorkerById(Worker workerById) {
        this.workerById = workerById;
    }

    @Override
    public String toString() {
        return "Person{" +
                "eMail='" + eMail + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
