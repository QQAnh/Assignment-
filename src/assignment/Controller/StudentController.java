package assignment.Controller;


import assignment.model.ConnectionHelper;
import assignment.entity.Student;
import assignment.model.StudentModel;


import java.sql.*;
import java.util.Scanner;

public class StudentController {
    private final StudentModel model = new StudentModel();


    public static void Diskplay() {
        Connection connection = null;
        PreparedStatement ptmt = null;

        connection = ConnectionHelper.ketnoi();

        String sql = "SELECT * FROM students WHERE status = '1'";

        try {
            ptmt = connection.prepareStatement(sql);
            ResultSet res = ptmt.executeQuery();
            System.out.printf("ID    RollNumber        Name            Phone                 Email\n");
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String rollNumber = res.getString("rollNumber");
                String phone = res.getString("phone");
                String email = res.getString("email");
                System.out.println(id + "\t    " + rollNumber + "\t      " + name + "\t      " + phone + "\t       " + email);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());


        }
    }

    public void addStudent() {

        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your name : ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 3) {
                student.setName(value);
                break;
            }
            System.out.println("Name's required. ");
        }
        while (true) {
            System.out.println("Please enter your rollnumber : ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 0) {
                student.setRollNumber(value);
                break;
            }
            System.out.println("RollNumber's required. ");
        }
        while (true) {
            System.out.println("Please enter your phone : ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 0) {
                student.setPhone(value);
                break;
            }
            System.out.println("Phone't required. ");
        }
        while (true) {
            System.out.println("Please enter your email : ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 3) {
                student.setEmail(value);
                break;
            }
            System.out.println("Email't required. ");
        }

        model.insert(student);

    }

    public void deleteStudent() {

        Connection connection = ConnectionHelper.ketnoi();
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Please enter your id you want delete : ");
        id = scanner.nextInt();
        String sql = "UPDATE students SET status = '0' WHERE id = ?";
        System.out.println("Do you really want to delete ? " + "\n" + "1.Yes \t 2.No");
        System.out.println("You choice : ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            try {
                PreparedStatement ptmt = connection.prepareStatement(sql);
                ptmt.setInt(1, id);
                int kt = ptmt.executeUpdate();

                if (kt != 0) {
                    System.out.println("=>Success");

                }
                ptmt.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            return;

        }
    }

    public void editStudent() {

        Connection connection = ConnectionHelper.ketnoi();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.RollNumber ");
        System.out.println("2.Name ");
        System.out.println("3.Phone ");
        System.out.println("4.Email ");
        System.out.println("=============================");
        System.out.println(" You want update :  ");


        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                model.update1();
                Diskplay();
                break;
            case 2:
                model.update2();
                Diskplay();
                break;
            case 3:
                model.update3();
                Diskplay();
                break;
            case 4:
                model.update4();
                Diskplay();
                break;



        }



    }




}





