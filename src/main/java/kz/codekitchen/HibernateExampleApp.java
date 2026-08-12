package kz.codekitchen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.codekitchen.config.HibernateConfig;
import kz.codekitchen.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

            int updatedRowCount = entityManager
                    .createQuery("update Student set middleName = 'Sergeevich' where id = 14")
                    .executeUpdate();
            System.out.println("Updated row count: " + updatedRowCount);

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
