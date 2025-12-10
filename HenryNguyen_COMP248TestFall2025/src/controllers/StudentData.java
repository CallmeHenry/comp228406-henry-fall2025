package controllers;
import models.*;
import utils.*;
import java.sql.*;
import java.util.ArrayList;

public class StudentData {

    public StudentData() {
    }

    public ArrayList<Student> getStudents(String city) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection conn = SupabaseConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM Students WHERE city = ?");
            pst.setString(1, city);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                        rs.getString("studentID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("postalCode")
                ));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
