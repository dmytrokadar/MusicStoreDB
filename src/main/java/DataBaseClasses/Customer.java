package DataBaseClasses;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Customer extends Person {
//    private String eMail;
//    private int id;
//    private String webShop;
    private String account;
//    private Person personById;
    private WebShop webShopByWebShop;
//    private Collection<MakeOrder> makeOrdersByEMail;

    @Id
    @Column(name = "e_mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

//    @Basic
//    @Column(name = "id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "web_shop")
//    public String getWebShop() {
//        return webShop;
//    }
//
//    public void setWebShop(String webShop) {
//        this.webShop = webShop;
//    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (eMail != null ? !eMail.equals(customer.eMail) : customer.eMail != null) return false;
        if (account != null ? !account.equals(customer.account) : customer.account != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eMail != null ? eMail.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "id", referencedColumnName = "id", insertable=false, updatable=false)
//    public Person getPersonById() {
//        return personById;
//    }
//
//    public void setPersonById(Person personById) {
//        this.personById = personById;
//    }

    @ManyToOne
    @JoinColumn(name = "web_shop", referencedColumnName = "page")
    public WebShop getWebShopByWebShop() {
        return webShopByWebShop;
    }

    public void setWebShopByWebShop(WebShop webShopByWebShop) {
        this.webShopByWebShop = webShopByWebShop;
    }

//    @OneToMany(mappedBy = "customerByCustomer")
//    public Collection<MakeOrder> getMakeOrdersByEMail() {
//        return makeOrdersByEMail;
//    }
//
//    public void setMakeOrdersByEMail(Collection<MakeOrder> makeOrdersByEMail) {
//        this.makeOrdersByEMail = makeOrdersByEMail;
//    }
}
