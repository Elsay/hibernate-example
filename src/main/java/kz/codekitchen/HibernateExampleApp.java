package kz.codekitchen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.codekitchen.config.HibernateConfig;
import kz.codekitchen.entity.Address;
import kz.codekitchen.entity.Group;
import kz.codekitchen.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class HibernateExampleApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Group group = new Group("4399", FacultyType.CHEMISTRY);
            Student student = new Student(18, "Popov", "Viktor", "Ivanovich");
            student.setGroup(group);
            entityManager.persist(group);
            entityManager.persist(student);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception occurred, rollback. Exception " + e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        context.close();
    }
}
