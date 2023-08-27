import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.PrimaryKey;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();




        List<PurchaseList> purchaseListItems = session.createQuery("FROM PurchaseList", PurchaseList.class).list();
        List<Student> students = session.createQuery("FROM Student", Student.class).list();
        List<Course> courses = session.createQuery("FROM Course", Course.class).list();

        for (PurchaseList purchaseListItem : purchaseListItems) {
            String studentName = purchaseListItem.getStudentName();
            String courseName = purchaseListItem.getCourseName();

            Student student = students.stream().filter(s -> s.getName().equals(studentName)).findFirst().orElse(null);
            Course course = courses.stream().filter(c -> c.getName().equals(courseName)).findFirst().orElse(null);

            if (student != null && course != null) {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();

                LinkedPurchaseListId linkedPurchaseListId = new LinkedPurchaseListId();
                linkedPurchaseListId.setStudentName(String.valueOf(student.getId()));
                linkedPurchaseListId.setCourseName(String.valueOf(course.getId()));

                linkedPurchaseList.setId(linkedPurchaseListId);
                linkedPurchaseList.setStudent(student);
                linkedPurchaseList.setCourse(course);

                session.save(linkedPurchaseList);
            }
        }

        transaction.commit();

        sessionFactory.close();
    }
}