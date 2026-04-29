import java.sql.*;

public class EmployeeFetch {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_database", "root", "Rishav@91"
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT name, salary FROM employees");

            while (rs.next()) {
                System.out.println(
                    "Name: " + rs.getString("name") +
                    ", Salary: " + rs.getDouble("salary")
                );
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}