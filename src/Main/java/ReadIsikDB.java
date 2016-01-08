package Main.java;

//// http://www.tutorialspoint.com/postgresql/postgresql_java.htm

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ReadIsikDB {
    public static List<Isik> getIsikud()//static võimaldab pöörduda meetodi poole ilma objekti loomata.
    {
        List<Isik> isikud = new ArrayList<Isik>();
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
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ISIK;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  nimi = rs.getString("nimi");
                int synniaasta  = rs.getInt("synniaasta");
                String  email = rs.getString("email");

                Isik isik = new Isik ();
                isik.setNimi(rs.getString("nimi"));
                isik.setSynniaasta(rs.getInt("synniaasta"));
                isik.setEmail(rs.getString("email"));

                isikud.add(isik);

                System.out.println( "ID = " + id );
                System.out.println( "NIMI = " + nimi );
                System.out.println( "SYNNIAASTA = " + synniaasta );
                System.out.println( "EMAIL = " + email );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        return isikud;
    }
}