package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GettingObjectWithHQL {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> emps = session.createQuery("FROM Employee").getResultList(); // pri rabote s HQL pishetcya imya klassa
            List<Employee> emps = session.createQuery("FROM Employee " +
                    "where firstName = 'Aleksandr' and salary > 650").getResultList(); // pri rabote s HQL pishetcya imya klassa

            for (Employee e:emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
