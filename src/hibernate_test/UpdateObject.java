package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500);

//            session.createQuery("update Employee set salary = 1000 " +
//                    "where firstName = 'Aleksandr'").executeUpdate();
            List<Employee> emps = session.createQuery("FROM Employee").getResultList(); // pri rabote s HQL pishetcya imya klassa

            for (int i = 0; i < emps.size(); i++) {
                emps.get(i).setSalary(i + 601);
            }


            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
