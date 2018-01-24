package assignment.entity;

public class Student {
    int id;
    String rollNumber;
    String name;
    String phone;
    String email;
    int status;

    public Student() {

    }

    public Student(int id, String rollNumber, String name, String phone, String email, int status) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
