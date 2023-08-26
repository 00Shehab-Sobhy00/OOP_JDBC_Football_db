package dao;

import Config.Football_DB_Connection;
import Model.League;
import Model.Player;

import java.sql.*;
import java.time.LocalDateTime;

public class MatchesDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void
    insertMatch(String team1, String team2, int score1, int score2, String referee, LocalDateTime now) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement("INSERT INTO matches (team1,team2,score1,score2,referee,match_date)" +
                    "VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, team1);
            preparedStatement.setString(2, team2);
            preparedStatement.setInt(3, score1);
            preparedStatement.setInt(4, score2);
            preparedStatement.setString(5, referee);
            preparedStatement.setTimestamp(6, Timestamp.valueOf(now));
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int match_id ;
                match_id = resultSet.getInt("match_id");
                System.out.println("Generated primary key: " + match_id);
                insertGoalScorers(match_id);
            }
        } catch (SQLException e) {
            System.out.println("unable to add match cause " + e);
        }
    }

    public static boolean listAllMatchesInfo() {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT * FROM matches ");
            matchData();
        } catch (SQLException e) {
            System.out.println("unable to retrieve matches info " + e);
        }
        return false;
    }

    public static boolean matchInfo(int match_id) {
        try {
            connection = Football_DB_Connection.connect_to_db();
            preparedStatement = connection.prepareStatement(" SELECT * FROM matches WHERE match_id = ? ;");
            preparedStatement.setInt(1, match_id);
            matchData();
        } catch (SQLException e) {
            System.out.println("unable to retrieve match info " + e);
        }
        return false;
    }

    public static void matchData() throws SQLException {
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " Vs "
                    + resultSet.getString(3) + " : " + resultSet.getInt(4) +
                    " : " + resultSet.getInt(5) + " : " + resultSet.getString(6) + " : " +
                    resultSet.getTimestamp(7));
        }
    }

   // insertMatch()  // default call after match call ends
    private static void insertGoalScorers(int match_ID) {
        for (Player p : League.goalScorers) {
            int playerID = PlayerDao.getPlayerID(p.getName());
            System.out.println(playerID);
            try {
                connection = Football_DB_Connection.connect_to_db();
                preparedStatement = connection.prepareStatement("INSERT INTO goal_scorers (match_id, player_id) VALUES (?, ?)");
                preparedStatement.setInt(1, match_ID);
                preparedStatement.setInt(2, playerID);
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("unable insert Goal Scorers " + e);
            }

        }
    }

}