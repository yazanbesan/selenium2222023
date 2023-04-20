package SQLite;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import java.sql.*;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;


public class DAOTest {  public static String sqlite_url = "jdbc:sqlite:C:/QA_ECOM/SQL_DB/LeageOfLegendsDBB.db";

        private static final LOLDAO dao = new LOLDAO();
        private static final LeagueOfLegends_users leagUser1 = new LeagueOfLegends_users(1,  "player1@example.com", "YB3116@1", "15/03/23");
        private static final LeagueOfLegends_users leaguser2 = new LeagueOfLegends_users(2,  "player2@example.com", "YB3116@2", "25/02/23");
        private static final LeagueOfLegends_users leagUser3 = new LeagueOfLegends_users(3,  "player3@example.com", "YB3116@3", "17/04/23");


        @Test
        public void testCreateUser() throws SQLException {


            // save the user using the DAO
            LOLDAO.createUser(leagUser1);
            LOLDAO.createUser(leaguser2);
            LOLDAO.createUser(leagUser3);

            // retrieve the user from the database using the DAO
            LeagueOfLegends_users retrievedUser = dao.ReadById(leaguser2.getId());
            System.out.println(leaguser2.toString());
            System.out.println(retrievedUser.toString());

            // assert that the retrieved user matches the original user
            assertEquals(leaguser2.getId(), retrievedUser.getId());

            assertEquals(leaguser2.getEmail(), retrievedUser.getEmail());
            assertEquals(leaguser2.getPassword(), retrievedUser.getPassword());
            assertEquals(leaguser2.getBD(), retrievedUser.getBD());
        }

        @Test // Delete record test
        public void testDeleteFromTable() throws SQLException {

            String query = "SELECT COUNT(*) FROM LeagueOfLegends_Users";
            Statement stm = LOLDAO.con.createStatement();

            ResultSet rs = stm.executeQuery(query);
            rs.next();
            int Beforedelet = rs.getInt(1);

            // Delete a record from the table
            LOLDAO.deleteFromTable(2);

            // Check if the record has been deleted

            rs = stm.executeQuery(query);
            rs.next();
            int Afterdelet = rs.getInt(1);
            assertEquals(Afterdelet, Beforedelet - 1);
        }

        @Test
        public void UpdateUser() throws SQLException {
            //Scanner scan = new Scanner(System.in)
            Random rand = new Random();
            int num = rand.nextInt(10);
            String str = "YB3116@3" + num;
            //System.out.println("Please enter the new email. ");
            String email = "yazan"+rand.nextInt(100)+"@email.com";
            String query = "UPDATE LeagueOfLegends_Users SET password = '" + str + "',Email = '"+ email +"' WHERE id = 3";
            Statement stm = LOLDAO.con.createStatement();
            stm.executeUpdate(query);
            query = "SELECT password FROM LeagueOfLegends_Users WHERE id = 3";
            ResultSet rs = stm.executeQuery(query);
            String pw = rs.getString(1);
            assertEquals(pw, str);
        }

    @Test // Select all records test
    public void testREADAll() throws SQLException {
        List<LeagueOfLegends_users> users = LOLDAO.READAll();
        assertNotNull(users); // check that the list is not null
        assertTrue(users.size() > 0); // check that the list is not empty
        for(LeagueOfLegends_users user: users){
            System.out.println(user.toString());
        }
    }
}


