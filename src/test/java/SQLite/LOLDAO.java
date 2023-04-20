package SQLite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LOLDAO {

    public static final String sqlite_url = "jdbc:sqlite:C:/QA_ECOM/SQL_DB/LeageOfLegendsDBB.db";
    public static final Connection con;


    static {
        try {
            con = DriverManager.getConnection(sqlite_url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createNewDataBase() {
        String url = "jdbc:sqlite:C:/QA_ECOM/SQL_DB/LeageOfLegendsDBB.db";
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void create() {
        String url = "jdbc:sqlite:C:/QA_ECOM/SQL_DB/LeageOfLegendsDBB.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
            if (con != null) {
                String sql = "CREATE TABLE IF NOT EXISTS LeagueOfLegends_users(id INTEGER , email TEXT NOT NULL, password TEXT NOT NULL,BOD TEXT NOT NULL )";
                Statement stm = con.createStatement();
                stm.executeUpdate(sql);
                System.out.println("create table =");
                System.out.println("the table  is created ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public static void updateTable(int id, String email, String password, String BOD) throws SQLException {
        String query = "UPDATE LeagueOfLegends_users SET id=?,  email=?, password=?,BOD=? WHERE id=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(4, BOD);
        pst.setString(2, password);
        pst.setString(3, email);
        pst.setInt(1, id);
        int numRowsUpdated = pst.executeUpdate();
        if (numRowsUpdated > 0) {
            System.out.println("Record updated successfully");
        } else {
            System.out.println("No records were updated");
        }
    }


    public static void deleteFromTable(int i) throws SQLException {
        String query = "DELETE FROM LeagueOfLegends_users WHERE id = 2";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
        System.out.println("Record deleted from the table...");
        System.out.println("The table is updated!");
    }

    public static List<LeagueOfLegends_users> READAll() throws SQLException {
        List<LeagueOfLegends_users> users = new ArrayList<>();
        String query = "SELECT * FROM LeagueOfLegends_users";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String date = rs.getString("BOD");
            LeagueOfLegends_users user = new LeagueOfLegends_users(id, email, password, date);
            users.add(user);
        }

        return users;
    }

    public static LeagueOfLegends_users ReadById(int id) throws SQLException {
        String query = "SELECT * FROM LeagueOfLegends_Users WHERE id=?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String email = rs.getString("Email");
                String password = rs.getString("password");
                String date = rs.getString("BOD");
                return new LeagueOfLegends_users(id, email, password, date);
            }
        }
        return null;
    }
        public static void createUser (LeagueOfLegends_users newUser) throws SQLException {
            String query = "INSERT INTO LeagueOfLegends_Users (id, email, password, BOD) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, newUser.getId());
            ps.setString(2, newUser.getEmail());
            ps.setString(3, newUser.getPassword());
            ps.setString(4, newUser.getBD());

            ps.executeUpdate();
        }

    }


