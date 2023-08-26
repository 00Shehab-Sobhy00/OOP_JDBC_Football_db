package dao;

import Config.Football_DB_Connection;


import java.sql.*;

public class LeagueDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static boolean insertLeague(String name) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("INSERT INTO leagues (league_name) VALUES (?)");
            preparedStatement.setString(1, name);
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("unable to add League " + e);
        }
        return false;
    }

    public static String retrieveLeagueById(int league_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("SELECT league_name FROM leagues WHERE league_id = ?");
            preparedStatement.setInt(1, league_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("unable to retrieve All Leagues " + e);
        }
        return "";
    }

    public static boolean retrieveAllLeagues() {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("SELECT * FROM leagues ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ":" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("unable to retrieve All Leagues " + e);
        }
        return false;
    }
}
