import Config.Football_DB_Connection;
import Model.League;
import Model.Player;
import Model.Team;
import dao.*;

public class Main {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------//
//        LeagueDao.insertLeague("worldCup");
//
//        TeamDao.insertTeams("psg ", 1);
//        TeamDao.insertTeams("Treal madrid", 1);
//        TeamDao.insertTeams("barcelona", 1);
//        TeamDao.insertTeams("liverpool", 1);

//        TeamDao.retrieveAllLTeamsInLeague(1);
//---------------------------------------------------------------------------------------//
//        RefereesDao.insertReferees("referee1",1);
//        RefereesDao.insertReferees("referee2",1);
//        RefereesDao.insertReferees("referee3",1);

//      RefereesDao.retrieveAllLRefereesInLeague(1);
//---------------------------------------------------------------------------------------//
//        PlayerDao.insertPlayersInTeam("Neymar", 5);
//        PlayerDao.insertPlayersInTeam("Kylian Mbappé", 5);
//        PlayerDao.insertPlayersInTeam("Marco Verratti", 5);
 //     PlayerDao.listAllPlayersInTeam(5);

//        PlayerDao.insertPlayersInTeam("Karim Benzema", 6);
//        PlayerDao.insertPlayersInTeam("Luka Modrić", 6);
//        PlayerDao.insertPlayersInTeam("Toni Kroos", 6);
//        PlayerDao.listAllPlayersInTeam(6);
//
//        PlayerDao.insertPlayersInTeam("Lewandowski", 7);
//        PlayerDao.insertPlayersInTeam("Lamine", 7);
//        PlayerDao.insertPlayersInTeam("Pedri", 7);
////        PlayerDao.listAllPlayersInTeam(7);
//
//        PlayerDao.insertPlayersInTeam("Salah", 8);
//        PlayerDao.insertPlayersInTeam("Joe Gomez", 8);
//        PlayerDao.insertPlayersInTeam("Virgil van Dijk", 8);
//        PlayerDao.listAllPlayersInTeam(8);
//---------------------------------------------------------------------------------------//
        //        CoacheDao.insertCoach("psgCoach",5);
//        CoacheDao.insertCoach("realMadridCoach",6);
//        CoacheDao.insertCoach("barcelonaCoach",7);
//        CoacheDao.insertCoach("milanCoach",8);

//        CoacheDao.retrieveAllLCoachesInTeams();
//---------------------------------------------------------------------------------------//
//        Team getTeamName1 = TeamDao.retrieveOnlyTeam(5);
//        String getCoachByTeamName1 = CoacheDao.retrieveCoachByTeamName(getTeamName1.getName());
//        Team<Player> getTeam1 = new Team<>(getTeamName1.getName(),getCoachByTeamName1);
//        getTeam1.addPlayer(new Player("Neymar"));
//        getTeam1.addPlayer(new Player("Kylian Mbappé"));
//        getTeam1.addPlayer(new Player("Marco Verratti"));
//
//
//        Team getTeamName2 = TeamDao.retrieveOnlyTeam(6);
//        String getCoachByTeamName2 = CoacheDao.retrieveCoachByTeamName(getTeamName2.getName());
//        Team<Player> getTeam2 = new Team<>(getTeamName2.getName(),getCoachByTeamName2);
//        getTeam2.addPlayer(new Player("Karim Benzema"));
//        getTeam2.addPlayer(new Player("Luka Modrić"));
//        getTeam2.addPlayer(new Player("Toni Kroos"));
//
//        Team getTeamName3 = TeamDao.retrieveOnlyTeam(7);
//        String getCoachByTeamName3 = CoacheDao.retrieveCoachByTeamName(getTeamName3.getName());
//        Team<Player> getTeam3 = new Team<>(getTeamName3.getName(),getCoachByTeamName3);
//      getTeam3.addPlayer(new Player("Lewandowski"));
//        getTeam3.addPlayer(new Player("Lamine"));
//        getTeam3.addPlayer(new Player("Pedri"));
//
//        Team getTeamName4 = TeamDao.retrieveOnlyTeam(8);
//        String getCoachByTeamName4 = CoacheDao.retrieveCoachByTeamName(getTeamName4.getName());
//        Team<Player> getTeam4 = new Team<>(getTeamName4.getName(),getCoachByTeamName4);
//        getTeam4.addPlayer(new Player("Salah"));
//        getTeam4.addPlayer(new Player("Joe Gomez"));
//        getTeam4.addPlayer(new Player("Joe Gomez"));
//        getTeam4.addPlayer(new Player("Salah"));
//
//
//        League<Team> worldCup = new League<>(LeagueDao.retrieveLeagueById(1));
//            worldCup.add(getTeam1);
//            worldCup.add(getTeam2);
//            worldCup.add(getTeam3);
//            worldCup.add(getTeam4);
//
//        worldCup.match();
        // save matchs result in db   + // goal scores is been saved by default
//          MatchesDao.insertMatch(
//                        worldCup.getTeam1().getName(),
//                        worldCup.getTeam2().getName(),
//                        worldCup.getFirstRandomTeamScore(),
//                        worldCup.getSecRandomTeamScore(),
//                        RefereesDao.retrieveOnlyOneForMatch(3),
//                        worldCup.getNow());


//        MatchesDao.listAllMatchesInfo();
//       MatchesDao.matchInfo(19);
        PlayerDao.seePlayerScore(61);
    }



}