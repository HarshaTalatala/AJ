import java.sql.*;

public class Scrollable {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "2785");

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = st.executeQuery("SELECT * FROM student");

            System.out.println("Forward Direction:");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + " " + rs.getString("name") + " " + rs.getString("address"));
            }

            System.out.println("\nBackward Direction:");
            while (rs.previous()) {
                System.out.println(rs.getInt("rollno") + " " + rs.getString("name") + " " + rs.getString("address"));
            }

            rs.first();
            System.out.println("\nFirst Record: " + rs.getInt("rollno") + " " + rs.getString("name"));

            rs.last();
            System.out.println("Last Record: " + rs.getInt("rollno") + " " + rs.getString("name"));

            rs.absolute(2);
            System.out.println("2nd Record: " + rs.getInt("rollno") + " " + rs.getString("name"));

            rs.relative(-1);
            System.out.println("Previous Record (relative -1): " + rs.getInt("rollno") + " " + rs.getString("name"));

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
