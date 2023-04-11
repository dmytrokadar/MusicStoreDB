package DataBaseClasses;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "web_shop", schema = "public", catalog = "kadardmy")
public class WebShop {
    private String page;
    private Collection<Customer> customersByPage;

    @Id
    @Column(name = "page")
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebShop webShop = (WebShop) o;

        if (page != null ? !page.equals(webShop.page) : webShop.page != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return page != null ? page.hashCode() : 0;
    }

    @OneToMany(mappedBy = "webShopByWebShop")
    public Collection<Customer> getCustomersByPage() {
        return customersByPage;
    }

    public void setCustomersByPage(Collection<Customer> customersByPage) {
        this.customersByPage = customersByPage;
    }
}
