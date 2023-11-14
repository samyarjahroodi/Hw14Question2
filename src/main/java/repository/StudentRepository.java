package repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import model.Student;
import model.Teacher;

import static sessionFactory.SessionFactory.getSessionFactory;

public class StudentRepository implements PersonRepository<Student> {
    Session session = getSessionFactory().openSession();

    @Override
    public void save(Student student) {
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(Student student) {
        try {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            System.out.println("Student updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


    @Override
    public void deleteById(long id) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Student WHERE id = :id");
            query.setParameter("id", id);
            int result = query.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
            } else {
                System.out.println("Student not found for deletion");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


    @Override
    public Student loadAll(long id) {
        try {
            session.beginTransaction();
            return session.load(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean contains(int studentCode) {
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery("FROM Student WHERE studentsCode = :studentCode", Student.class);
            query.setParameter("studentCode", studentCode);
            Student retrievedStudent = query.uniqueResult();
            session.getTransaction().commit();
            return retrievedStudent != null;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}

