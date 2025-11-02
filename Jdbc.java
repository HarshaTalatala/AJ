import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "harsha", "2785");

            Statement st = con.createStatement();

            st.executeUpdate("CREATE TABLE IF NOT EXISTS student (rollno INT PRIMARY KEY, name VARCHAR(50), address VARCHAR(100))");

            st.executeUpdate("INSERT INTO student VALUES (1, 'Ravi', 'Hyderabad')");
            st.executeUpdate("INSERT INTO student VALUES (2, 'Priya', 'Delhi')");
            st.executeUpdate("INSERT INTO student VALUES (3, 'Amit', 'Mumbai')");

            System.out.println("Initial Records:");
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            st.executeUpdate("INSERT INTO student VALUES (4, 'Kiran', 'Chennai')");
            st.executeUpdate("INSERT INTO student VALUES (5, 'Rahul', 'Bangalore')");

            st.executeUpdate("UPDATE student SET address='Pune' WHERE rollno=2");

            st.executeUpdate("DELETE FROM student WHERE rollno=1");

            System.out.println("\nAfter Insert/Update/Delete:");
            rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
