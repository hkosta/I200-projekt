package Install;

//// http://www.tutorialspoint.com/postgresql/postgresql_java.htm

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgreInsertIsik {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "kalamaja");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO ISIK (ID,NIMI, SYNNIAASTA, EMAIL) "
                    + "VALUES (1, 'Priit Kuusik', 1982, 'helen.kosta@mail.ee');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO ISIK (ID,NIMI, SYNNIAASTA, EMAIL) "
                    + "VALUES (2, 'Maris Nuustik', 1983, 'helen.kosta@mail.ee');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO ISIK (ID,NIMI, SYNNIAASTA, EMAIL) "
                    + "VALUES (3, 'Kati Karu', 1984, 'helen.kosta@mail.ee');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO ISIK (ID,NIMI, SYNNIAASTA, EMAIL) "
                    + "VALUES (4, 'Kübara Moor', 1982, 'helen.kosta@mail.ee');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}