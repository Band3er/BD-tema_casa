import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.*;

public class Connect {
    // var initialization
    OracleDataSource ods;
    Connection conn;
    ResultSet rslt;
    PreparedStatement stmt;

    public void init(){
        try {
            // the connection param
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//bd-dc.cs.tuiasi.ro:1539/orcl"); // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
            ods.setUser("bd161");
            ods.setPassword("bd161");
            
            // Attempts to establish a connection with the data source that
            conn = ods.getConnection();
            
            // the statement that we sent
            //stmt = conn.prepareStatement("SELECT * FROM PERSONS");
            //rslt = stmt.executeQuery();
            
            // print the statement sent
           //while (rslt.next()) {
           //    System.out.println(rslt.getString(1));
           //}        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(){
        try {
                stmt = conn.prepareStatement("SELECT * FROM PERSONS");
                rslt = stmt.executeQuery();

                while (rslt.next()) {
                    System.out.println(rslt.getString(1));
                }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public void close(){
        try {
            // Close resources
            //stmt.close();
            //rslt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
