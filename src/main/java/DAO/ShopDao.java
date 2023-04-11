package DAO;

import DataBaseClasses.Shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ShopDao {
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//    private static EntityManager em = emf.createEntityManager();
//    private static EntityTransaction t = em.getTransaction();

    public static Shop createShop(EntityManager em, EntityTransaction t, String location) {
        t.begin();
        Shop shop = new Shop();
        shop.setLocation(location);
        em.persist(shop);
        t.commit();
        System.out.println("Inserted Shop " + shop);
        return shop;
    }
}
