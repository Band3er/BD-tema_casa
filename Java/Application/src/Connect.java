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

    // connection used for the TRANSPORTATION TABLE
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

  public boolean populateTable(String query) {
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            return rowsAffected > 0; // Return true if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }

    public boolean deleteTable(String query) {
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            return rowsAffected > 0; // Return true if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }



    // table DRINKS

    // connection used for the TRANSPORTATION TABLE
    public void viewTableDrinks(DefaultTableModel tableModel) throws SQLException {
        String query = "select ID_DRINKS, NAME, DESCRIPTION, COST from DRINKS";
        try (Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("ID_DRINKS");
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

    // connection used for the TRANSPORTATION TABLE
    public void viewTableEvent(DefaultTableModel tableModel) throws SQLException {
        String query = "select ID_EVENT, NAME, DATE_EVENT, LOCATION from EVENT";
        try (Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("ID_EVENT");
            String name = rs.getString("NAME");
            String description = rs.getString("DATE_EVENT");
            String location = rs.getString("LOCATION");
            Object[] row = {id, name, description, location};
            tableModel.addRow(row);
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    // connection used for the TRANSPORTATION TABLE
    public void viewTableMenu(DefaultTableModel tableModel) throws SQLException {
        String query = "select ID_MENU, NAME, DESCRIPTION, COST from MENU";
        try (Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("ID_MENU");
            String name = rs.getString("NAME");
            String description = rs.getString("DESCRIPTION");
            int cost = rs.getInt("COST");
            Object[] row = {id, name, description, cost};
            tableModel.addRow(row);
        }
        } catch (SQLException e) {
        e.printStackTrace();
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
