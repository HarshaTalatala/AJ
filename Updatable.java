import java.sql.*;

public class Updatable {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "2785");

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            ResultSet rs = st.executeQuery("SELECT * FROM student");

            System.out.println("Original Records:");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + " " + rs.getString("name") + " " + rs.getString("address"));
            }

            rs.moveToInsertRow();
            rs.updateInt("rollno", 6);
            rs.updateString("name", "Sita");
            rs.updateString("address", "Kolkata");
            rs.insertRow();
            System.out.println("\nInserted record (6, Sita, Kolkata)");

            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt("rollno") == 2) {
                    rs.updateString("address", "Pune");
                    rs.updateRow();
                    System.out.println("Updated address of rollno 2 to Pune");
                }
            }

            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt("rollno") == 1) {
                    rs.deleteRow();
                    System.out.println("Deleted record with rollno 1");
                }
            }

            rs = st.executeQuery("SELECT * FROM student");
            System.out.println("\nFinal Records:");
            while (rs.next()) {
                System.out.println(rs.getInt("rollno") + " " + rs.getString("name") + " " + rs.getString("address"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
