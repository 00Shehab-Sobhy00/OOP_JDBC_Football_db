package dao;

import Config.Football_DB_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoacheDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static boolean insertCoach(String CoachName, int team_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("INSERT INTO  coaches (coach_name , team_id) VALUES (?,?)");
            preparedStatement.setString(1, CoachName);
            preparedStatement.setInt(2, team_id);
            return preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("unable to add coach cause " + e);
        }

        return false;
    }

    public static boolean retrieveAllLCoachesInTeams() {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT c.coach_id , c.coach_name , t.team_name " +
                    " FROM coaches c  JOIN teams  t " +
                    " ON c.team_id = t.team_id; ");
            resultSet = preparedStatement.executeQuery();
            System.out.println("Coach id: Coach Name: Team Name ");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " : " +  resultSet.getString(2)
              + " : " + resultSet.getString(3));
            }

        }catch (SQLException e){
            System.out.println("unable to retrieve All Referees " + e);
        }
        return false;
    }

    public static String retrieveCoachByTeamName(String teamName) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT  c.coach_name " +
                    " FROM coaches c  JOIN teams t  " +
                    "     ON c.team_id = t.team_id " +
                    "  WHERE t.team_name = ? ; ");
            preparedStatement.setString(1,teamName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
         return  resultSet.getString(1);
            }

        }catch (SQLException e){
            System.out.println("unable to retrieve All Referees " + e);
        }
        return "";
    }
}
