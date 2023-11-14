package sessionFactory;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import model.Student;
import model.Teacher;

public class SessionFactory {
    private final static org.hibernate.SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // by default load hibernate.cfg.xml
                .build();

        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
