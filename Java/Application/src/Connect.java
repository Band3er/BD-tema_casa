import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import oracle.jdbc.pool.*;

public class Connect {
    // var initialization
    OracleDataSource ods;
    static Connection conn;
    ResultSet rslt;
    PreparedStatement stmt;

    // open the connection
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

    // close the connection
    public boolean close(){
        try {
            conn.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // template to populate all tables
    public boolean populateTable(String query) {
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            return rowsAffected > 0; // Return true if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }

    // template to delete a row from a table
    public boolean deleteTable(String query) {
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            return rowsAffected > 0; // Return true if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }

    // connection used to view TRANSPORTATION TABLE
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

    // connection used to view DRINKS TABLE
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

    // connection used to view EVENT TABLE
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

    // connection used to view MENU TABLE
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

    // connection used to view PERSONS TABLE
    public void viewTablePersons(DefaultTableModel tableModel) throws SQLException {
        String query = "select ID_PERSON,LAST_NAME, FIRST_NAME, AGE, ADDRESS, PHONE_NUMBER, EMAIL, t.NAME as transport_name, m.NAME as menu_name, d.NAME as drinks_name from PERSONS p, DRINKS d, MENU m, TRANSPORTATION t WHERE p.DRINKS = d.ID_DRINKS AND p.MENU = m.ID_MENU AND p.TRANSPORT = t.ID_TRANSPORT";
        try (Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("ID_PERSON");
            String lastName = rs.getString("LAST_NAME");
            String firstName = rs.getString("FIRST_NAME");
            int age = rs.getInt("AGE");
            String address = rs.getString("ADDRESS");
            int phnNbr = rs.getInt("PHONE_NUMBER");
            String email = rs.getString("EMAIL");
            String transport = rs.getString("transport_name");
            String menu = rs.getString("menu_name");
            String drinks = rs.getString("drinks_name");
            Object[] row = {id, lastName, firstName, age, address, phnNbr, 
            email, transport, menu, drinks};
            tableModel.addRow(row);
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    // method to get the options from TRANSPORTATION TABLE for the dropdown when inserting values to the TABLE PERSONS
    public String[] getTransportOptions() throws SQLException{
        String query = "SELECT ID_TRANSPORT, NAME FROM TRANSPORTATION";
        ArrayList<String> stringList = new ArrayList<>();
        if(conn != null){
            try(Statement stmt = conn.createStatement();) {
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    int id = rs.getInt("ID_TRANSPORT");
                    String name = rs.getString("NAME");
                    String concatString = ((String.valueOf(id)).concat("-")).concat(name);
                    stringList.add(concatString);
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }   
        String[] stringArray = stringList.toArray(new String[0]);
        return stringArray;
    }

    // method to get the options from MENU TABLE for the dropdown when inserting values to the TABLE PERSONS
    public String[] getMenuOptions() throws SQLException{
        String query = "SELECT ID_MENU, NAME FROM MENU";
        ArrayList<String> stringList = new ArrayList<>();
        if(conn != null){
            try(Statement stmt = conn.createStatement();) {
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    int id = rs.getInt("ID_MENU");
                    String name = rs.getString("NAME");
                    String concatString = ((String.valueOf(id)).concat("-")).concat(name);
                    stringList.add(concatString);
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }   
        String[] stringArray = stringList.toArray(new String[0]);
        return stringArray;
    }

    // method to get the options from DRINKS TABLE for the dropdown when inserting values to the TABLE PERSONS
    public String[] getDrinksOptions() throws SQLException{
        String query = "SELECT ID_DRINKS, NAME FROM DRINKS";
        ArrayList<String> stringList = new ArrayList<>();
        if(conn != null){
            try(Statement stmt = conn.createStatement();) {
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    int id = rs.getInt("ID_DRINKS");
                    String name = rs.getString("NAME");
                    String concatString = ((String.valueOf(id)).concat("-")).concat(name);
                    stringList.add(concatString);
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }   
        String[] stringArray = stringList.toArray(new String[0]);
        return stringArray;
    }
}
