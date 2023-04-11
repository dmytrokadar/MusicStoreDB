package DataBaseClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Shop {
    private String location;
    private Collection<HaveSection> haveSectionsByLocation;
    private Collection<Section> sectionsByLocation;
    private Collection<Worker> workersByLocation;

    @Id
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (location != null ? !location.equals(shop.location) : shop.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

    @OneToMany(mappedBy = "shopByShop")
    public Collection<HaveSection> getHaveSectionsByLocation() {
        return haveSectionsByLocation;
    }

    public void setHaveSectionsByLocation(Collection<HaveSection> haveSectionsByLocation) {
        this.haveSectionsByLocation = haveSectionsByLocation;
    }

    @OneToMany(mappedBy = "shopByShop")
    public Collection<Section> getSectionsByLocation() {
        return sectionsByLocation;
    }

    public void setSectionsByLocation(Collection<Section> sectionsByLocation) {
        this.sectionsByLocation = sectionsByLocation;
    }

    @OneToMany(mappedBy = "shopByShop")
    public Collection<Worker> getWorkersByLocation() {
        return workersByLocation;
    }

    public void setWorkersByLocation(Collection<Worker> workersByLocation) {
        this.workersByLocation = workersByLocation;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "location='" + location + '\'' +
                ", haveSectionsByLocation=" + haveSectionsByLocation +
                '}';
    }
}
