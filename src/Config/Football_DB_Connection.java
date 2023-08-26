package Config;

import java.sql.*;


public class Football_DB_Connection {
   static private Connection conn;
   static private String DB_NAME = "Football_DB";
   static private String USER = "postgres";
   static private String PASSWORD = "01001";

   static public Connection connect_to_db() {
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + DB_NAME, USER, PASSWORD);
            if (conn != null) {
//                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

 static public void close (){
        try{
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("Couldnt close connection " + e.getMessage());
        }
    }

//    public List <Model.Player> queryPlayer(){
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//    }


}