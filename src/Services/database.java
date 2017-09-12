package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Viet Quan on 03/08/2017.
 */
public class database {
    public static Connection getConnection(){
        Connection con = null;
        try {
            String url = "jdbc:mysql://104.140.22.47:3306/interview_java?useUnicode=true&characterEncoding=UTF-8";
            //?useUnicode=true&characterEncoding=UTF-8
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"tomcat_testing", "QuanViet");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
