
import java.sql.*;

public class ReadTable {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:file:C:\\Users\\JJ\\IdeaProjects\\Car Sharing\\Car Sharing\\task\\src\\carsharing\\db\\carsharing";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void readTable(Connection conn, Statement stmt) {
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection

            conn = DriverManager.getConnection(DB_URL);

            // STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql = "SELECT id, name FROM COMPANY";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");

                String name = rs.getString("name");


                // Display values
                System.out.print("ID: " + id);
                System.out.println(", name: " + name);

            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try

    }
}
