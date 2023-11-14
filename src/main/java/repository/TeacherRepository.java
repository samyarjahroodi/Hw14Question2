package repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import model.Teacher;

import static sessionFactory.SessionFactory.getSessionFactory;

public class TeacherRepository implements PersonRepository<Teacher> {
    Session session = getSessionFactory().openSession();


    @Override
    public void save(Teacher teacher) {
        try {
            session.beginTransaction();
            session.save(teacher);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(Teacher teacher) {
        try {
            session.beginTransaction();
            session.update(teacher);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Teacher WHERE id = :id");
            query.setParameter("id", id);
            int result = query.executeUpdate();

            if (result > 0) {
                session.getTransaction().commit();
            } else {
                System.out.println("Teacher not found for deletion");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


    @Override
    public Teacher loadAll(long id) {
        try {
            session.beginTransaction();
            return session.load(Teacher.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean contains(int teacherCode) {
        try {
            session.beginTransaction();
            Query<Teacher> query = session.createQuery("FROM Teacher WHERE teachersCode = :teacherCode", Teacher.class);
            query.setParameter("teacherCode", teacherCode);

            Teacher retrievedTeacher = query.uniqueResult();

            session.getTransaction().commit();

            return retrievedTeacher != null;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

//    @Override
//    public boolean contains(Teacher teacher) {
//        try {
//            if (!session.isOpen()) {
//                session = getSessionFactory().openSession();
//            }
//
//            session.beginTransaction();
//            boolean containsTeacher = session.contains(teacher);
//            session.getTransaction().commit();
//
//            return containsTeacher;
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//            return false;
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }
//    }


}
