package DAO;

import DataBaseClasses.Product;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class ProductDao{
    @PersistenceContext
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//    private static EntityManager em = emf.createEntityManager();
//    private static EntityTransaction t = em.getTransaction();

    public static Product createProduct(EntityManager em, EntityTransaction t, int number, String material, String size, String type, String manufacturer, String name, int year_manufactured, int price) {
        t.begin();
        Product product = new Product();
        product.setNumber(number);
        product.setMaterial(material);
        product.setSize(size);
        product.setType(type);
        product.setManufacturer(manufacturer);
        product.setName(name);
        product.setYearManufactured(year_manufactured);
        product.setPrice(price);
        em.persist(product);
        t.commit();
        System.out.println("Inserted Product " + product);
        return product;
    }

    public static void insertProduct(EntityManager em, EntityTransaction t, Product p) throws SQLException {
        t.begin();
        em.persist(p);
        t.commit();
        System.out.println("Inserted " + p);
    }

    public static void deleteProduct(EntityManager em, EntityTransaction t, Product p) throws SQLException {
        t.begin();
        em.remove(p);
        t.commit();
        System.out.println("Removed " + p);
    }

    public static void deleteProductByID(EntityManager em, EntityTransaction t, int id) throws SQLException {
        Product p = em.find(Product.class, id);
        t.begin();
        em.remove(p);
        t.commit();
        System.out.println("Removed " + p);

    }

    public static void upodateProduct(EntityManager em, EntityTransaction t, Product p, String name) throws SQLException {
//        EntityTransaction t = em.getTransaction();
        t.begin();
        p.setName(name);
        em.persist(p);
        t.commit();
        System.out.println("Updated " + p);
    }

    public static void queryProduct(EntityManager em) {
        TypedQuery<Product> q2 = em.createQuery("SELECT p FROM Product AS p", Product.class);
        q2.setMaxResults(10);
        List<Product> l = q2.getResultList();
        System.out.println("Products:");
        for (Product p : l) {
            System.out.println(p);
        }
    }

    public static Product retrieveProductByID(EntityManager em, int id) {
        TypedQuery<Product> q3 = em.createQuery("SELECT p FROM Product AS p WHERE (p.number = : id)", Product.class);
        q3.setParameter("id", id);
        Product p = q3.getSingleResult();
        System.out.println("Product " + p.toString() + " retrieved by ID.");
        return p;
    }

    public static List<Product> retrieveProductByManufacturer(EntityManager em, String name) {
        TypedQuery<Product> q3 = em.createQuery("SELECT p FROM Product AS p WHERE (p.manufacturer = : manufacturerName)", Product.class);
        q3.setParameter("manufacturerName", name);
        List<Product> l = q3.getResultList();
        System.out.println("Products:");
        for (Product p : l) {
            System.out.println(p);
        }
        System.out.println(" retrieved by Manufacturer.");
//        System.out.println("Product " + p.toString() + " retrieved by Manufacturer.");
        return l;
    }

    public static List<Product> retrieveProductByWhatYouWant(EntityManager em, String whatToFind, String whereToFind) {
        TypedQuery<Product> q3 = em.createQuery("SELECT p FROM Product AS p WHERE (p."+whereToFind+" = : whatT)", Product.class);
        q3.setParameter("whatT", whatToFind);
//        q3.setParameter("whereT", whereToFind);
        List<Product> l = q3.getResultList();
        System.out.println("Products:");
        for (Product p : l) {
            System.out.println(p);
        }
        System.out.println(" retrieved by "+whereToFind+".");
//        System.out.println("Product " + p.toString() + " retrieved by Manufacturer.");
        return l;
    }
}





//    @Transactional
//    public static void insertProduct(Connection c, int number, String material, String size, String type, String manufacturer, String name, int year_manufactured, int price) throws SQLException {
//        Statement stmt = c.createStatement();
//        stmt.execute("INSERT INTO product (number, material, size, type, manufacturer, name, year_manufactured, price) VALUES ("+number+", "+material+", "+size+", "+type+", "+manufacturer+", "+name+", "+year_manufactured+", "+price+");");
//
//    }
