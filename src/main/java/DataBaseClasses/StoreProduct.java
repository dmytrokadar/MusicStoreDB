package DataBaseClasses;

import javax.persistence.*;

@Entity
@Table(name = "store_product", schema = "public", catalog = "kadardmy")
public class StoreProduct {
    private int productId;
//    private String storage;
    private Storage storageByStorage;

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

//    @Basic
//    @Column(name = "storage")
//    public String getStorage() {
//        return storage;
//    }
//
//    public void setStorage(String storage) {
//        this.storage = storage;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreProduct that = (StoreProduct) o;

        if (productId != that.productId) return false;
//        if (storage != null ? !storage.equals(that.storage) : that.storage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "storage", referencedColumnName = "location")
    public Storage getStorageByStorage() {
        return storageByStorage;
    }

    public void setStorageByStorage(Storage storageByStorage) {
        this.storageByStorage = storageByStorage;
    }
}
