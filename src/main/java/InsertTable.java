import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void insertTable(Connection conn, Statement stmt) {
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection

            conn = DriverManager.getConnection(Main.DB_URL);
            conn.setAutoCommit(true);


            // STEP 3: Execute a query
            stmt = conn.createStatement();

            String sql = "INSERT INTO COMPANY " + "VALUES (101, 'Za5435a')";
            stmt.executeUpdate(sql);

//            sql = "INSERT INTO COMPANY " + "VALUES (105, 'Mahnaz')";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO COMPANY " + "VALUES (106, 'Zaid')";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO COMPANY " + "VALUES(107, 'Sumit')";
//            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt !=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn !=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}
