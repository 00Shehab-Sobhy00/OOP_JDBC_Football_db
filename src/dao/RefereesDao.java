package dao;

import Config.Football_DB_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RefereesDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static boolean insertReferees(String refereeName, int league_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("INSERT INTO  referees (referee_name , league_id) VALUES (?,?)");
            preparedStatement.setString(1, refereeName);
            preparedStatement.setInt(2, league_id);
            return preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("unable to add team cause " + e);
        }

        return false;
    }

    public static boolean retrieveAllLRefereesInLeague(int league_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT * FROM referees WHERE league_id = ? ");
            preparedStatement.setInt(1,league_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " : " +  resultSet.getString(2));
            }

        }catch (SQLException e){
            System.out.println("unable to retrieve All Referees " + e);
        }
        return false;
    }


    public static String retrieveOnlyOneForMatch(int referee_id) {
        String name = "";
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT referee_name FROM referees WHERE referee_id = ? ");
            preparedStatement.setInt(1,referee_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                name = resultSet.getString(1);
            }
            return name;

        }catch (SQLException e){
            System.out.println("unable to retrieve All Referees " + e);
        }
        return name;
    }
}
