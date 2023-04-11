package DAO;

import DataBaseClasses.Person;
import DataBaseClasses.Product;
import DataBaseClasses.Shop;
import DataBaseClasses.Worker;

import javax.persistence.*;
import java.util.List;

public class WorkerDao {
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//    private static EntityManager em = emf.createEntityManager();
//    private static EntityTransaction t = em.getTransaction();

    public static Worker createWorker(EntityManager em, EntityTransaction t, String e_mail, int ID, Shop shop, String position, int salary, String firstName, String lastName) {
        t.begin();
        Worker worker = new Worker();

        worker.seteMail(e_mail);
        worker.setId(ID);
        worker.setShopByShop(shop);
        worker.setPosition(position);
        worker.setSalary(salary);
        worker.setFirstName(firstName);
        worker.setLastName(lastName);

        em.persist(worker);
        t.commit();
        System.out.println("Inserted Worker " + worker);
        return worker;
    }

    public static Worker createWorkerWithPerson(EntityManager em, EntityTransaction t, Person person, Shop shop, String position, int salary) {
        t.begin();
        Worker worker = new Worker();

        worker.setPersonById(person);
        worker.seteMail(person.geteMail());
        worker.setId(person.getId());
        worker.setShopByShop(shop);
        worker.setPosition(position);
        worker.setSalary(salary);
        System.out.println("Inserted Worker " + worker);

        em.persist(worker);
        t.commit();
        return worker;
    }

    public static void queryWorker(EntityManager em) {
        TypedQuery<Worker> q2 = em.createQuery("SELECT w FROM Worker AS w", Worker.class);
        List<Worker> l = q2.getResultList();
        System.out.println("Workers:");
        for (Worker w : l) {
            System.out.println(w);
        }
    }
}
