import java.sql.*;

public class StoredProcedure {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/employee";
        // String url = "jdbc:mysql://localhost:3306/employee";
        String user = "postgres";
        String password = "2785";

        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            CallableStatement cs1 = con.prepareCall("{CALL insert_employee(?, ?, ?)}");
            cs1.setInt(1, 101);
            cs1.setString(2, "Harsha");
            cs1.setDouble(3, 50000.0);
            cs1.execute();
            System.out.println("Record inserted successfully!");

            CallableStatement cs2 = con.prepareCall("{CALL get_salary_by_id(?, ?)}");
            cs2.setInt(1, 101);
            cs2.registerOutParameter(2, Types.DECIMAL);
            cs2.execute();

            double salary = cs2.getDouble(2);
            System.out.println("Salary for Employee ID 101: " + salary);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
