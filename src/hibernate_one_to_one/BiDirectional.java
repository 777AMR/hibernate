package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectional {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            1.
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Nikolay", "Petrov"
//                    , "HR", 850);
//
//            Detail detail = new Detail("New-York", "65432178"
//                    , "mikolay@mail.ru");
//
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//
//            session.save(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            2. Получение таблицы через - get
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            3. Удаление
            session = factory.getCurrentSession();

            session.beginTransaction();

            Detail detail = session.get(Detail.class, 1);
//          "Разрушение связь между строками"
            detail.getEmployee().setEmpDetail(null);

            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

    }
}
