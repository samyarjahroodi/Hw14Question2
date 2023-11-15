package service;

import model.Person;
import model.Student;
import org.hibernate.ObjectNotFoundException;
import repository.StudentRepository;

import java.util.Scanner;

public class StudentService implements PersonService<Student> {
    StudentRepository studentRepository = new StudentRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(Student student) {
        System.out.println("Firstname : ");
        String firstname = scanner.nextLine();
        student.setFirstName(firstname);
        System.out.println("Lastname : ");
        String lastname = scanner.next();
        student.setLastName(lastname);
        System.out.println("Date of birth : ");
        String dateOfBirth = scanner.next();
        student.setDOB(dateOfBirth);
        System.out.println("Student code : ");
        int studentCode = scanner.nextInt();
        student.setStudentsCode(studentCode);
        System.out.println("Student field");
        String studentField = scanner.next();
        student.setField(studentField);
        System.out.println("Entrance year");
        int entranceYear = scanner.nextInt();
        student.setEntranceYear(entranceYear);
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        System.out.println("Student's code: ");
        int studentCode = scanner.nextInt();
        boolean contains = studentRepository.contains(studentCode);
        if (contains) {
            Student updatedStudent = new Student();
            System.out.println("Firstname: ");
            updatedStudent.setFirstName(scanner.next());
            System.out.println("Lastname: ");
            updatedStudent.setLastName(scanner.next());
            System.out.println("Date of birth: ");
            updatedStudent.setDOB(scanner.next());
            System.out.println("Student field: ");
            updatedStudent.setField(scanner.next());
            System.out.println("Entrance year: ");
            updatedStudent.setEntranceYear(scanner.nextInt());

            studentRepository.update(studentCode, updatedStudent);
        } else {
            System.out.println("Student with code " + studentCode + " does not exist.");
        }
    }


    @Override
    public void delete() {
        System.out.println("Id that you want to delete");
        long i = scanner.nextLong();
        studentRepository.deleteById(i);
    }

    @Override
    public Student loadAll() {
        try {
            System.out.println("Id that you want to load");
            long l = scanner.nextLong();
            return studentRepository.loadAll(l);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            System.out.println("Id doesnt exit");
        }
        return null;
    }

    @Override
    public void contain() {
        System.out.println("Enter student code: ");
        int studentCode = scanner.nextInt();
        boolean containsStudent = studentRepository.contains(studentCode);
        if (containsStudent) {
            System.out.println("Student with code " + studentCode + " exists.");
        } else {
            System.out.println("Student with code " + studentCode + " does not exist.");
        }
    }
}
