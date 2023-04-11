package DAO;

import DataBaseClasses.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
//        Class c = Class.forName("org.eclipse.persistence.jpa.PersistenceProvider");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            Product p = ProductDao.createProduct(em, t, 789452, "rosewood", "32x32x32", "ukulele", "schecter", "american standart", 2022, 99999);
            ProductDao.deleteProduct(em, t, p);

            p = ProductDao.createProduct(em, t, 789445, "rosewood", "32x32x32", "ukulele", "schecter", "american standart", 2022, 99999);
            ProductDao.deleteProductByID(em, t, p.getNumber());

            ProductDao.upodateProduct(em, t, p, "fjdsfnjdsnsdk");
            ProductDao.queryProduct(em);

            Product p2 = ProductDao.retrieveProductByID(em, 323);
            List<Product> p3 = ProductDao.retrieveProductByManufacturer(em, "gibson");

            // doesn't work with integers!!!!!!
            List<Product> p4 = ProductDao.retrieveProductByWhatYouWant(em,"fender", "manufacturer");
            List<Product> p5 = ProductDao.retrieveProductByWhatYouWant(em,"guitar", "type");

            //=======================================================
//        Shop shop = DAO.ShopDao.createShop(em, t,"Thakurova zxc81346cx/4xbvxcvv");
////        Person person = PersonDao.createPerson(em, t, "jbgfjabcvvcdsk@.com", 5126342, "ashbxdxzxa", "nhsdbvjxv.,");
////        Worker w3 = WorkerDao.createWorkerWithPerson(em, t, person, shop, "manager", 350000);
//        Person p1 = PersonDao.createPerson(em, t, "jk@.comd6", 555523636, "ashxzvcd36", "nhdcjsv36");
//        Worker w1 = WorkerDao.createWorker(em, t,"jk@.comd6", 555523636, shop, "manager", 100000, "ashxzvcd36", "nhdcjsv36");
//        Person p2 = PersonDao.createPerson(em, t, "njvfjasdk@.com45", 653523145, "n0smkd45", "jsdnfj45");
//        Worker w2 = WorkerDao.createWorker(em, t,"njvfjasdk@.com45", 653523145, shop, "director", 900000, "n0smkd45", "jsdnfj45");
////            WorkerDao.queryWorker();
////        //========================================================
//        Supervisor sup = DAO.SupervisorDao.createRealationSupervise(em, t, w2, w1);
        } finally {
            if(t.isActive()){
                t.rollback();
            }
            em.close();
            emf.close();
        }
//
//        try {
//            t.begin();
//
//            Shop shop = new Shop();
//            shop.setLocation("Thakurova 29 ");
//            em.persist(shop);
//
//            t.commit();
//        } finally {
//            if(t.isActive()){
//                t.rollback();
//            }
//            em.close();
//            emf.close();
//        }

    }
}
