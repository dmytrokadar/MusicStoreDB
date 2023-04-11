package DAO;

import DataBaseClasses.Person;
import DataBaseClasses.Shop;
import DataBaseClasses.Worker;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDao {
    public static Person createPerson(EntityManager em, EntityTransaction t, String e_mail, int ID, String firstName, String lastName) {
        t.begin();
        Person person = new Person();

        person.seteMail(e_mail);
        person.setId(ID);
        person.setLastName(lastName);
        person.setFirstName(firstName);

        em.persist(person);
        t.commit();
        System.out.println("Inserted Person " + person);
        return person;
    }

    public static void queryPerson(EntityManager em) {
        TypedQuery<Person> q2 = em.createQuery("SELECT w FROM Worker AS w", Person.class);
        List<Person> l = q2.getResultList();
        System.out.println("Persons: ");
        for (Person p : l) {
            System.out.println(p);
        }
    }
}
