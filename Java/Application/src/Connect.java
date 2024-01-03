import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import oracle.jdbc.pool.*;

public class Connect {
    // var initialization
    OracleDataSource ods;
    static Connection conn;
    ResultSet rslt;
    PreparedStatement stmt;

    public boolean init(){
        try {
            // the connection param
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//bd-dc.cs.tuiasi.ro:1539/orcl"); // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
            ods.setUser("bd161");
            ods.setPassword("bd161");
            
            // Attempts to establish a connection with the data source that
            conn = ods.getConnection();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void viewTableTransportation(DefaultTableModel tableModel) throws SQLException {
        String query = "select ID_TRANSPORT, NAME, DESCRIPTION, COST from TRANSPORTATION";
        try (Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("ID_TRANSPORT");
            String name = rs.getString("NAME");
            String description = rs.getString("DESCRIPTION");
            int price = rs.getInt("COST");
            Object[] row = {id, name, description, price};
            tableModel.addRow(row);
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
  }

  public boolean populateTableTransportation(String query) {
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            return rowsAffected > 0; // Return true if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }

    public boolean deleteTableTransportation(String query) {
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            return rowsAffected > 0; // Return true if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }


    public boolean close(){
        try {
            conn.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
