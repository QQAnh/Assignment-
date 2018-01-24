package assignment.model;

import assignment.Controller.StudentController;
import assignment.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentModel {
    public ArrayList<Student> getListStudent() throws SQLException {
        ArrayList<Student> listStudent = new ArrayList<>();

        Connection connection = ConnectionHelper.ketnoi();

        if (connection == null) {
            return listStudent;
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  * FROM students");
            while (rs.next()) {
                int id = rs.getInt("id");
                String rollNumber = rs.getString("rollNumber");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int status = rs.getInt("status");

                Student student = new Student(id, rollNumber, name, phone, email, status);
                listStudent.add(student);

            }


        } catch (SQLException ex) {
            System.out.println("Can't connection to database. ");
        }
        return listStudent;
    }

    public boolean insert(Student student) {
        Connection connection = ConnectionHelper.ketnoi();
        StudentController controller = new StudentController();
        Scanner scanner = new Scanner(System.in);
        if (connection == null) {
            return false;
        }
        System.out.printf("RollNumber        Name            Phone                 Email\n");
        System.out.println(student.getRollNumber() + "\t      " + student.getName() + "\t      " + student.getPhone() + "\t       " + student.getEmail());
        System.out.println("Do you want add new student to database ? " + "\n 1. Yes        2.No");
        System.out.println("Your choice : ");
        int a = scanner.nextInt();
        if (a == 1) {
            try {
                Statement statement = connection.createStatement();
                statement.execute("INSERT INTO students(rollNumber,name,phone,email) values ('" + student.getRollNumber() + "', '" + student.getName() + "', '" + student.getPhone() + "', '" + student.getEmail() + "')");
                controller.Diskplay();


            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        } else {
            return false;
        }


        return false;
    }

    public void update1() {
        try {
            Student student = new Student();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Please enter new RollNumber:  ");
            String rollNumber = scanner.nextLine();
            if (rollNumber.length() > 3) {


                System.out.println("Please enter you id you want update : ");
                int id = scanner.nextInt();

                System.out.println("Do you want edit new RollNumber ? " + "\n 1. Yes        2.No");
                System.out.println("Your choice : ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    Connection connection = ConnectionHelper.ketnoi();
                    String sql = "Update students SET rollNumber = ? Where id = ?";
                    PreparedStatement ptmt = connection.prepareStatement(sql);
                    ptmt.setInt(2, id);

                    ptmt.setString(1, rollNumber);
                    int kt = ptmt.executeUpdate();
                    if (kt != 0) {
                        System.out.println("=====Success=====");
                    } else {
                        System.err.println("=====Err=====");

                    }
                }
                if (choice == 2) {
                    System.out.println("You choice NO  ");
                    return;


                }

                if (choice > 2) {
                    System.out.println("Khong co phuong an,yeu cau nhap lai tu dau");
                }
            } else {
                System.out.println("RollNumber is short .RollNumber > 3 ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update2() {
        try {
            Student student = new Student();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Please enter new Name:  ");
            String name = scanner.nextLine();
            if (name.length() > 4) {


                System.out.println("Please enter you id you want update : ");
                int id = scanner.nextInt();

                System.out.println("Do you want edit new name to database ? " + "\n 1. Yes        2.No");
                System.out.println("Your choice : ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    Connection connection = ConnectionHelper.ketnoi();
                    String sql = "Update students SET name = ? Where id = ?";
                    PreparedStatement ptmt = connection.prepareStatement(sql);
                    ptmt.setInt(2, id);

                    ptmt.setString(1, name);
                    int kt = ptmt.executeUpdate();
                    if (kt != 0) {
                        System.out.println("=====Success=====");
                    } else {
                        System.err.println("=====Err=====");

                    }
                }
                if (choice == 2) {
                    System.out.println("You choice NO  ");
                    return;


                }

                if (choice > 2) {
                    System.out.println("Khong co phuong an,yeu cau nhap lai tu dau");
                }
            } else {
                System.out.println("Name is short");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update3() {
        try {
            Student student = new Student();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Please enter new Phone:  ");
            String phone = scanner.nextLine();
            if (phone.length() > 3 && phone.length() < 12) {


                System.out.println("Please enter you id you want update : ");
                int id = scanner.nextInt();
                System.out.println("Do you want add new student to database ? " + "\n 1. Yes        2.No");
                System.out.println("Your choice : ");
                int choice = scanner.nextInt();
                if (choice == 1) {


                    Connection connection = ConnectionHelper.ketnoi();
                    String sql = "Update students SET phone = ? Where id = ?";
                    PreparedStatement ptmt = connection.prepareStatement(sql);
                    ptmt.setInt(2, id);

                    ptmt.setString(1, phone);
                    int kt = ptmt.executeUpdate();
                    if (kt != 0) {
                        System.out.println("=====Success=====");
                    } else {
                        System.err.println("=====Err=====");

                    }
                }
                if (choice == 2) {
                    System.out.println("You choice NO  ");
                    return;


                }

                if (choice > 2) {
                    System.out.println("Khong co phuong an,yeu cau nhap lai tu dau");
                }
            } else {
                System.out.println("Phone doesn't success");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update4() {
        try {
            Student student = new Student();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Please enter new Email :  ");
            String email = scanner.nextLine();
            if (email.length() > 4) {


                System.out.println("Please enter you id you want update : ");
                int id = scanner.nextInt();
                System.out.println("Do you want add new student to database ? " + "\n 1. Yes        2.No");
                System.out.println("Your choice : ");
                int choice = scanner.nextInt();
                if (choice == 1) {


                    Connection connection = ConnectionHelper.ketnoi();
                    String sql = "Update students SET email = ? Where id = ?";
                    PreparedStatement ptmt = connection.prepareStatement(sql);
                    ptmt.setInt(2, id);

                    ptmt.setString(1, email);
                    int kt = ptmt.executeUpdate();
                    if (kt != 0) {
                        System.out.println("=====Success=====");
                    } else {
                        System.err.println("=====Err=====");

                    }
                }
                if (choice == 2) {
                    System.out.println("You choice NO  ");
                    return;


                }

                if (choice > 2) {
                    System.out.println("Khong co phuong an,yeu cau nhap lai tu dau");
                }
            } else {
                System.out.println("Email is short");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
