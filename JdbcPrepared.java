import java.sql.*;

public class JdbcPrepared {
    public static void main(String[] args) {
        try {
    
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentprep", "postgres", "2785");


            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS studentprep (rollno INT PRIMARY KEY, name VARCHAR(50), address VARCHAR(100))");

            st.executeUpdate("INSERT INTO studentprep VALUES (1, 'Ravi', 'Hyderabad')");
            st.executeUpdate("INSERT INTO studentprep VALUES (2, 'Priya', 'Delhi')");
            st.executeUpdate("INSERT INTO studentprep VALUES (3, 'Amit', 'Mumbai')");

            System.out.println("Initial Records:");
            PreparedStatement psSelect = con.prepareStatement("SELECT * FROM studentprep");
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            PreparedStatement psInsert = con.prepareStatement("INSERT INTO studentprep VALUES (?, ?, ?)");
            psInsert.setInt(1, 4);
            psInsert.setString(2, "Kiran");
            psInsert.setString(3, "Chennai");
            psInsert.executeUpdate();

            psInsert.setInt(1, 5);
            psInsert.setString(2, "Rahul");
            psInsert.setString(3, "Bangalore");
            psInsert.executeUpdate();

            PreparedStatement psUpdate = con.prepareStatement("UPDATE studentprep SET address=? WHERE rollno=?");
            psUpdate.setString(1, "Pune");
            psUpdate.setInt(2, 2);
            psUpdate.executeUpdate();

            PreparedStatement psDelete = con.prepareStatement("DELETE FROM studentprep WHERE rollno=?");
            psDelete.setInt(1, 1);
            psDelete.executeUpdate();

            System.out.println("\nAfter Insert/Update/Delete:");
            rs = psSelect.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
