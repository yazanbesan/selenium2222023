package SQLite;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static SQLite.LOLDAO.con;

public class LeagueOfLegends_users {
    private int id;
    private String email;
    private String BD;
    private String password;

    public LeagueOfLegends_users(int id, String email, String password, String BD) {
        this.id = id;
        this.email = email;
        this.BD = BD;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LeagueOfLegends_users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", BD='" + BD + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public boolean isPasswordValid() {        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(c)) {
                containsLowercase = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            }
        }
        return containsUppercase && containsLowercase && containsDigit && password.length() >=11;
    }
    public static boolean isValid(String Password) {
        if (Password.length() >= 5 && Password.length() <= 10) {
            return true;
        } else
            return false;
    }

}



