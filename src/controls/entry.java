package controls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class entry {
    public static String enter_into_db(String Name, String Username, String Password, String Confirm_Password) {
        Connection con = null;
        PreparedStatement stat = null;
        ResultSet res = null;

        if (Name == "" || Username == "" || Password == "" || Confirm_Password == "") {
            return "Blank_Field";
        } else if (!Password.matches(Confirm_Password)) {
            return "Passwords_Do_Not_Match";
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception ex) {
                return "driver not registered..";
            }

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/My_db", "root", "ocean007");
                stat = con.prepareStatement("insert into employee(Name, Username, Password, Confirm_Password) VALUES ('" + Name + "','" + Username + "','" + Password + "','" + Confirm_Password + "')");
                int i = stat.executeUpdate();
                return "Successful_Update";
            } catch (SQLException ex) {
                return "Username_already_exists";
            }

        }
    }
}
