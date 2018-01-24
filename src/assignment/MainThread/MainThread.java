package assignment.MainThread;


import assignment.Controller.StudentController;

import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        StudentController controller = new StudentController();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = 0;
            System.out.println("==========Student Manager==========");
            System.out.println("1. Student list.");
            System.out.println("2. Add student.");
            System.out.println("3. Edit student.");
            System.out.println("4. Delete student.");
            System.out.println("5. Exit student manager");
            System.out.println("Please enter your choice :  ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    controller.Diskplay();
                    break;
                case 2:
                    controller.addStudent();
                    controller.Diskplay();
                    break;
                case 3:
                    controller.Diskplay();
                    controller.editStudent();
                    break;
                case 4:
                    controller.Diskplay();
                    controller.deleteStudent();
                    break;
                case 5:
                    System.out.println("Bye bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter your choice from 1 to 5 .");
                    break;
            }
            System.out.println("===================================");


        }
    }
}
