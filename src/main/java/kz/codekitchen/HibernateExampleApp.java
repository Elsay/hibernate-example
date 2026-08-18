package kz.codekitchen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kz.codekitchen.config.HibernateConfig;
import kz.codekitchen.entity.Address;
import kz.codekitchen.entity.Group;
import kz.codekitchen.entity.Section;
import kz.codekitchen.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Collections;
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

            Section footballSection = new Section(SectionType.FOOTBALL);
            entityManager.persist(footballSection);

            Section basketSection = new Section(SectionType.BASKETBALL);
            entityManager.persist(basketSection);

            Section swimmingSection = new Section(SectionType.SWIMMING);
            entityManager.persist(swimmingSection);

            Section dancingSection = new Section(SectionType.DANCING);
            entityManager.persist(dancingSection);

            Student student1 = new Student(20, "Sidorov", "Ivan");
            student1.setSections(Arrays.asList(footballSection, basketSection));
            entityManager.persist(student1);

            Student student2 = new Student(19, "Petrov", "Andrey");
            student2.setSections(Arrays.asList(footballSection, swimmingSection));
            entityManager.persist(student2);

            Student student3 = new Student(17, "Popov", "Alex");
            student3.setSections(Collections.singletonList(dancingSection));
            entityManager.persist(student3);

            Student student4 = new Student(25, "Little", "Styort");
            student4.setSections(Collections.singletonList(footballSection));
            entityManager.persist(student4);

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
