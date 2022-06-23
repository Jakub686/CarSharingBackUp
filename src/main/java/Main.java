
import java.sql.*;

public class Main {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:file:C:\\Users\\JJ\\IdeaProjects\\CarSharingBackUp\\src\\main\\java\\db\\db";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) throws Exception {

        Connection conn = null;
        Statement stmt = null;

        boolean tableExists = false;

        //Creating Table
        CreateTable.createTable(conn, stmt);
        //InsertTable.insertTable(conn, stmt);
        ReadTable.readTable(conn, stmt);
        ReadTable.readTableID();
        //isTableExists(stmt, tableExists);

    }

    private static void isTableExists(Statement stmt, boolean tableExists) throws Exception {
        Connection conn;
        conn = DriverManager.getConnection(DB_URL); // get a DB connection from somewhere
        ResultSet rset = conn.getMetaData().getTables(null, null, "COMPANY", null);

        if (rset.next()) {
            tableExists = true;
            //DropTable.dropTable(conn, stmt);
            System.out.println("table exists");
        }
    }
}