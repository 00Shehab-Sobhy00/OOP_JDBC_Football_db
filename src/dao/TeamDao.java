package dao;

import Config.Football_DB_Connection;
import Model.Player;
import Model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;


    public static boolean insertTeams(String name, int league_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("INSERT INTO  teams (team_name , league_id) VALUES (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, league_id);
            return preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("unable to add team cause " + e);
        }

        return false;
    }

    public static boolean retrieveAllLTeamsInLeague(int league_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT * FROM teams ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2));
            }

        } catch (SQLException e) {
            System.out.println("unable to retrieve All Teams " + e);
        }
        return false;
    }

    // bad practice
    public static Team retrieveOnlyTeam(int team_id) {
        Team  team = null;
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("SELECT t.team_name , c.coach_name " +
                    " FROM teams t " +
                    " JOIN coaches c " +
                    " ON t.team_id = c.team_id " +
                    " WHERE t.team_id =  " + team_id  + ";"  );
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String teamName = resultSet.getString("team_name");
                String coachName = resultSet.getString("coach_name");
               team = new Team (teamName, coachName);
            }
            System.out.println(team.getName());
            return team;


        } catch (SQLException e) {
            System.out.println("unable to retrieve All Teams " + e);
        }
        return null;
    }



}
