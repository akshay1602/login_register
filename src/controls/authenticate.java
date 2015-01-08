package controls;

/**
 * Created by akshay.Gupta on 1/7/15.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class authenticate {
    public static boolean validate(String name, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/My_db","root","ocean007");
            st = conn.prepareStatement("Select * from Employee where Username = ? and Password = ?");
            st.setString(1,name);
            st.setString(2,pass);
            rs = st.executeQuery();
            if(rs.next()){
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
            System.out.println(e);
            status = false;
        }

        return status;

    }
}
