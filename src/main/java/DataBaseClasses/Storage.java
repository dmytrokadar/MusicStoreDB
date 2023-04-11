package DataBaseClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Storage {
    private String location;
    private Collection<StoreProduct> storeProductsByLocation;

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

        Storage storage = (Storage) o;

        if (location != null ? !location.equals(storage.location) : storage.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

    @OneToMany(mappedBy = "storageByStorage")
    public Collection<StoreProduct> getStoreProductsByLocation() {
        return storeProductsByLocation;
    }

    public void setStoreProductsByLocation(Collection<StoreProduct> storeProductsByLocation) {
        this.storeProductsByLocation = storeProductsByLocation;
    }
}
