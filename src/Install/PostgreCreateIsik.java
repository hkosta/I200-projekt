package Install;

// http://www.tutorialspoint.com/postgresql/postgresql_java.htm

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgreCreateIsik {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "kalamaja");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE ISIK " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NIMI           TEXT    NOT NULL, " +
                    " SYNNIAASTA            INT     NOT NULL, " +
                    " EMAIL        TEXT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}