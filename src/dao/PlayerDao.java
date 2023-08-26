package dao;

import Config.Football_DB_Connection;
import Model.Player;

import java.sql.*;

public class PlayerDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;


    public static void insertPlayerInTeam(String name, Integer team_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("INSERT INTO players (player_name , team_id) "
                    + "VALUES (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, team_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("unable to add players team " + e);
        }
    }

    public static void listAllPlayersInTeam(int teamID) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT * FROM players WHERE team_id = ?");
            preparedStatement.setInt(1, teamID);
            resultSet = preparedStatement.executeQuery();

            System.out.println("Player id : Player Name");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("player_id") +
                        " : " + resultSet.getString("player_name"));
            }

        } catch (SQLException e) {
            System.out.println("unable to retrieve players list " + e);
        }

    }

    // to add into score goal as well
    public static int getPlayerID(String playerName) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT player_id FROM players " +
                    " WHERE player_name = ?");
            preparedStatement.setString(1, playerName);
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("unable to retrieve players list " + e);
        }
        return 0;
    }

  // 61
    public static void seePlayerScore(int player_Id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(
                    "SELECT gs.goal_id, m.match_id, m.match_date, gs.player_id, p.player_name" +
                    " FROM goal_scorers gs " +
                    "         JOIN matches m ON gs.match_id = m.match_id " +
                    "         JOIN players p ON gs.player_id = p.player_id " +
                    "WHERE p.player_id = ? ;");
            preparedStatement.setInt(1, player_Id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getInt(2) + " : "
                + resultSet.getTimestamp(3) + " : " + resultSet.getInt(4)+ " : "+
                        resultSet.getString(5) );
            }
        } catch (SQLException e) {
            System.out.println("unable to load player score ");
        }
    }

}
