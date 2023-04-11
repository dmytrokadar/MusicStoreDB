package DAO;

import DataBaseClasses.Customer;
import DataBaseClasses.Product;
import DataBaseClasses.WebShop;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class CustomerDao {
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//    private static EntityManager em = emf.createEntityManager();
//    private static EntityTransaction t = em.getTransaction();

    public static Customer createProduct(EntityManager em, EntityTransaction t, String e_mail, WebShop web_shop, String account) {
        t.begin();
        Customer customer = new Customer();

        customer.seteMail(e_mail);
        customer.setWebShopByWebShop(web_shop);
        customer.setAccount(account);

        em.persist(customer);
        t.commit();
        System.out.println("Inserted Customer " + customer);
        return customer;
    }

    public static void insertCustomer(EntityManager em, EntityTransaction t, Customer customer) throws SQLException {
        t.begin();
        em.persist(customer);
        t.commit();
        System.out.println("Inserted " + customer);
    }

    public static void deleteCustomer(EntityManager em, EntityTransaction t, Customer customer) throws SQLException  {
        t.begin();
        em.remove(customer);
        t.commit();
        System.out.println("Removed " + customer);
    }

    public static void deleteProductByID(EntityManager em, EntityTransaction t, int id) throws SQLException {
        Product p = em.find(Product.class, id);
        t.begin();
        em.remove(p);
        t.commit();
        System.out.println("Removed " + p);

    }

    public static void upodateCustomer(EntityManager em, EntityTransaction t, Customer customer, int ID) throws SQLException {
        t.begin();
        customer.setId(ID);
        em.persist(customer);
        t.commit();
        System.out.println("Updated " + customer);
    }

    public static void queryCustomer(EntityManager em) {
        TypedQuery<Customer> q2 = em.createQuery("SELECT p FROM Customer AS p", Customer.class);
        List<Customer> l = q2.getResultList();
        System.out.println("Customers:");
        for (Customer customer : l) {
            System.out.println(customer);
        }
    }

    public static Customer retrieveCustomerByEmail(EntityManager em, String e_mail) {
        //                                                                            or e_mail
        TypedQuery<Customer> q3 = em.createQuery("SELECT p FROM Customer AS p WHERE (p.eMail = :"+e_mail+")", Customer.class);
        Customer customer = q3.getSingleResult();
        System.out.println("Customer " + customer.toString() + " retrieved by e-mail.");
        return customer;
    }

}
