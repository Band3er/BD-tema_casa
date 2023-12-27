import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.pool.*;

public class Connect {
    try {
        // the connection param
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//bd-dc.cs.tuiasi.ro:1539/orcl"); // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
        ods.setUser("bd161");
        ods.setPassword("bd161");
        
        // Attempts to establish a connection with the data source that
        Connection conn = ods.getConnection();
        
        // the statement that we sent
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Persons");
        ResultSet rslt = stmt.executeQuery();
        
        // print the statement sent
        while (rslt.next()) {
            System.out.println(rslt.getString(1));
        }
        
        // Close resources
        rslt.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
