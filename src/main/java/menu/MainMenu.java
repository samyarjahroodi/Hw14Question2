package menu;

import model.Student;
import model.Teacher;
import service.StudentService;
import service.TeacherService;

import java.util.Scanner;

public class MainMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        TeacherService teacherService = new TeacherService();
        StudentService studentService = new StudentService();

        while (true) {
            System.out.println("---Welcome---");
            System.out.println("---DEVELOPED BY SAMYAR JAHROODI---");
            System.out.println("1-Teacher");
            System.out.println("2-Student");
            System.out.println("3-quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleTeacherMenu(teacherService);
                    break;
                case 2:
                    handleStudentMenu(studentService);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void handleTeacherMenu(TeacherService teacherService) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---Teacher Menu---");
            System.out.println("1-Save teacher");
            System.out.println("2-Update teacher based on teacher's code");
            System.out.println("3-Delete teacher based on teacher's code");
            System.out.println("4-Show teacher based on id");
            System.out.println("5-Check if specific teacher's code exists");
            System.out.println("6-Back to main menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    teacherService.save(new Teacher());
                    break;
                case 2:
                    teacherService.update(new Teacher());
                    break;
                case 3:
                    teacherService.delete();
                    break;
                case 4:
                    teacherService.loadAll();
                    break;
                case 5:
                    teacherService.contain();
                    break;
                case 6:
                    return; // Exit teacher menu and go back to main menu
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void handleStudentMenu(StudentService studentService) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---Student Menu---");
            System.out.println("1-Save student");
            System.out.println("2-Update student based on student's code");
            System.out.println("3-Delete student based on student's code");
            System.out.println("4-Show student based on id");
            System.out.println("5-Check if specific student's code exists");
            System.out.println("6-Back to main menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentService.save(new Student());
                    break;
                case 2:
                    studentService.update(new Student());
                    break;
                case 3:
                    studentService.delete();
                    break;
                case 4:
                    studentService.loadAll();
                    break;
                case 5:
                    studentService.contain();
                    break;
                case 6:
                    return; // Exit student menu and go back to main menu
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

}