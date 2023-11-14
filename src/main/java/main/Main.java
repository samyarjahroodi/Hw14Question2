package main;

import model.Student;
import repository.TeacherRepository;
import model.Teacher;
import model.teachersDegree;
import model.teachersRate;
import service.StudentService;
import service.TeacherService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = new Student();
//        studentService.save(student);
        studentService.update(student);
        //studentService.delete();
        //studentService.contain();

        //TeacherService teacherService = new TeacherService();
        //Teacher teacher = new Teacher();
        //teacherService.save(teacher);


    }

}
