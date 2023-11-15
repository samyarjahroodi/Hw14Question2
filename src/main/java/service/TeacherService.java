package service;

import model.Person;
import model.Teacher;
import model.teachersDegree;
import model.teachersRate;
import org.hibernate.ObjectNotFoundException;
import repository.TeacherRepository;

import java.util.Locale;
import java.util.Scanner;

public class TeacherService implements PersonService<Teacher> {
    TeacherRepository teacherRepository = new TeacherRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(Teacher teacher) {
        System.out.println("Firstname : ");
        String firstname = scanner.nextLine();
        teacher.setFirstName(firstname);
        System.out.println("Lastname : ");
        String lastname = scanner.next();
        teacher.setLastName(lastname);
        System.out.println("Date of birth : ");
        String dateOfBirth = scanner.next();
        teacher.setDOB(dateOfBirth);
        System.out.println("Teacher's code : ");
        int teachersCode = scanner.nextInt();
        teacher.setTeachersCode(teachersCode);
        System.out.println("Teacher's degree : ");
        for (model.teachersDegree degree : model.teachersDegree.values()) {
            System.out.println(degree.name());
        }
        String teachersDegree = scanner.next().toUpperCase();
        teacher.setTeachersDegree(model.teachersDegree.valueOf(teachersDegree));
        System.out.println("Teacher's rate : ");
        for (model.teachersRate rate : model.teachersRate.values()) {
            System.out.println(rate.name());
        }
        String teachersRate = scanner.next().toUpperCase();
        teacher.setTeachersRate(model.teachersRate.valueOf(teachersRate));
        System.out.println("Salary : ");
        int salary = scanner.nextInt();
        teacher.setSalary(salary);
        teacherRepository.save(teacher);
        System.out.println("Successfully added to the data base");

    }

    @Override
    public void update(Teacher teacher) {
        System.out.println("Teacher's code : ");
        int teacherCode = scanner.nextInt();
        boolean contains = teacherRepository.contains(teacherCode);
        if (contains) {
            Teacher updatedTeacher = new Teacher();
            System.out.println("Firstname: ");
            updatedTeacher.setFirstName(scanner.next());
            System.out.println("Lastname: ");
            updatedTeacher.setLastName(scanner.next());
            System.out.println("Date of birth: ");
            updatedTeacher.setDOB(scanner.next());
            System.out.println("Teacher degree: ");
            updatedTeacher.setTeachersDegree(teachersDegree.valueOf(scanner.next().toUpperCase(Locale.ROOT)));
            System.out.println("Teacher rate: ");
            updatedTeacher.setTeachersRate(teachersRate.valueOf(scanner.next().toUpperCase(Locale.ROOT)));
            System.out.println("Salary: ");
            updatedTeacher.setSalary(scanner.nextInt());

            teacherRepository.update(teacherCode, updatedTeacher);
        } else {
            System.out.println("Teacher with code " + teacherCode + " does not exist.");
        }
    }


    @Override
    public void delete() {
        System.out.println("Id that you want to delete");
        long i = scanner.nextLong();
        teacherRepository.deleteById(i);

    }

    @Override
    public Teacher loadAll() {
        try {
            System.out.println("Id that you want to load");
            long l = scanner.nextLong();
            return teacherRepository.loadAll(l);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            System.out.println("Id doesnt exit");
        }
        return null;
    }

    @Override
    public void contain() {
        System.out.println("Enter teacher code: ");
        int studentCode = scanner.nextInt();
        boolean containsStudent = teacherRepository.contains(studentCode);
        if (containsStudent) {
            System.out.println("Student with code " + studentCode + " exists.");
        } else {
            System.out.println("Student with code " + studentCode + " does not exist.");
        }

    }
}
