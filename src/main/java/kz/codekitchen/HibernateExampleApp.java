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
public class HibernateExampleApp
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        context.close();
    }
}
