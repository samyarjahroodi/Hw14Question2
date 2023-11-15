package repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import model.Student;

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
    public void update(long studentsCode, Student student) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Student SET firstName = :newFirstName, " +
                    "lastName = :newLastName, DOB = :newDOB, field = :newField, entranceYear = :newEntranceYear " +
                    "WHERE studentsCode = :studentsCode");

            query.setParameter("newFirstName", student.getFirstName());
            query.setParameter("newLastName", student.getLastName());
            query.setParameter("newDOB", student.getDOB());
            query.setParameter("newField", student.getField());
            query.setParameter("newEntranceYear", student.getEntranceYear());
            query.setParameter("studentsCode", studentsCode);

            int updatedCount = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println(updatedCount + " student(s) updated successfully");
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
    public boolean contains(long studentCode) {
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

