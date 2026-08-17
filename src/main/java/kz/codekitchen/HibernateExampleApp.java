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

            Group group = new Group("4111", FacultyType.IT);
            Student student1 = new Student(18, "Popov1", "Viktor", "Ivanovich");
            Student student2 = new Student(18, "Popov2", "Viktor", "Ivanovich");
            Student student3 = new Student(18, "Popov3", "Viktor", "Ivanovich");
            group.addStudentToGroup(student1);
            group.addStudentToGroup(student2);
            group.addStudentToGroup(student3);
            entityManager.persist(group);
            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);

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
