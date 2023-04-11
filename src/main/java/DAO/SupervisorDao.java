package DAO;

import DataBaseClasses.Supervisor;
import DataBaseClasses.Worker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class SupervisorDao {
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//    private static EntityManager em = emf.createEntityManager();
//    private static EntityTransaction t = em.getTransaction();

    public static Supervisor createRealationSupervise(EntityManager em, EntityTransaction t, Worker upper, Worker lower) {
        t.begin();
        Supervisor supervisor = new Supervisor();

        Set<Worker> SetOfUpper = new HashSet<Worker>();
        SetOfUpper.add(upper);
        Set<Worker> SetOfLower = new HashSet<Worker>();
        SetOfLower.add(lower);

        supervisor.setWorkerByUpperPosition(SetOfUpper);
        supervisor.setWorkerByLowerPosition(SetOfLower);

        em.persist(supervisor);
        t.commit();
        System.out.println("Inserted Supervising " + supervisor);
        return supervisor;
    }

    // upper or lower can be null to insert only one
    public static void upodateSupervising(EntityManager em, EntityTransaction t, Supervisor s, Worker upper, Worker lower) throws SQLException {
        t.begin();
        s.appendWorkerByUpperPosition(upper);
        s.appendWorkerByLowerPosition(lower);
        em.persist(s);
        t.commit();
        System.out.println("Updated " + s);
    }
}
