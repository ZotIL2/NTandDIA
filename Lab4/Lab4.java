package Lab4;

import java.sql.*;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 obj = new Lab4();
        obj.Db();
        obj.isUserExists("Player1");
        obj.close();

    }
    Connection con;
    public void Db() {
        String dbUrl = "jdbc:mysql://localhost:3306/myGame?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String password = "Mylove19022021";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isUserExists(String username) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users WHERE username='" + username + "';");
            while (rs.next())
                if (rs.getInt(1) == 1) {
                    System.out.println("Yes");
                    return true;
                } else
                    return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
