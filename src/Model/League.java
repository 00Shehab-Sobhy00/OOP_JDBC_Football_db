package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class League<T extends Team> {
    private String leagueName;
    private ArrayList<T> leagueTeams;
    private int numberOfLeagueMatches;
    private DateTimeFormatter dateTimeFormatter ;
    LocalDateTime now;
    private String  referee;
    Random rand;
    private T team1;
    private T team2;
    private int firstRandomTeamScore;
    private int secRandomTeamScore;
//    private HashMap <Player,T>  goalScorers;
  static  public List <Player> goalScorers;


    public League(String name ) {
        this.leagueName = name;
        this.leagueTeams = new ArrayList<>();
        this.rand = new Random();
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = null;

        this.numberOfLeagueMatches = 0;
        this.firstRandomTeamScore = 0;
        this.secRandomTeamScore = 0;
        this.goalScorers = new LinkedList<>();
        this.referee = referee;


    }

    public boolean add(T team) {
        if (leagueTeams.contains(team)) {
            return false;
        }
        leagueTeams.add(team);
        return true;
    }

    public void match( ) {
         now = LocalDateTime.now();
        int firstRandomTeam =  rand.nextInt(leagueTeams.size()); //get index team
        int secRandomTeam =  rand.nextInt(leagueTeams.size());
        firstRandomTeamScore =  rand.nextInt(6);
        secRandomTeamScore =  rand.nextInt(6);


         team1 = leagueTeams.get(firstRandomTeam);      // prepare team for the match
         team2 = leagueTeams.get(secRandomTeam);
//        System.out.println( "Match Date  " + dateTimeFormatter.format(now));
         getNameGoalScorers(team1,firstRandomTeamScore);
         getNameGoalScorers(team2,secRandomTeamScore);


        numberOfLeagueMatches++;

    }

    private void getNameGoalScorers ( T teamName , int randScore){
        if (teamName.getPlayers().isEmpty()) {
            System.out.println("No players in the team.");
            return;
        }

        if (teamName.getPlayers().size() == 1) {
            Player nameOfTheGoal = (Player) teamName.getPlayers().get(0);
            nameOfTheGoal.goals();
            goalScorers.add(nameOfTheGoal);
            return;
        }

        for (int i = 0; i < randScore; i++) {
            Player nameOfTheGoal = (Player) teamName.getPlayers().get(rand.nextInt(teamName.getPlayers().size()));
                nameOfTheGoal.goals();
            goalScorers.add(nameOfTheGoal);
            System.out.println(nameOfTheGoal);
        }

    }


    public String getWinner() {
        if (firstRandomTeamScore > secRandomTeamScore) {
            return " Model.Team " + team1.getName() + " Won against " + team2.getName() +
                    " With Score " + firstRandomTeamScore +  " : " + secRandomTeamScore;
        } else if (firstRandomTeamScore < secRandomTeamScore) {
            return " Model.Team " + team2.getName() + " Won against " + team1.getName() +
                    " With Score " + secRandomTeamScore + " : " + firstRandomTeamScore ;
        } else {
            return team1 + " Draw With " + team2;
        }
    }

    public void printTeams() {
        for (T p : leagueTeams) {
            System.out.println(p.getName());
        }
    }

    public int getNumberOfLeagueMatches(){
        return numberOfLeagueMatches;
    }

    public List getPlayers() {
        return goalScorers;
    }




    public String getReferee() {
        return referee;
    }

    public T getTeam1() {
        return team1;
    }

    public T getTeam2() {
        return team2;
    }

    public int getFirstRandomTeamScore() {
        return firstRandomTeamScore;
    }

    public int getSecRandomTeamScore() {
        return secRandomTeamScore;
    }
    public LocalDateTime getNow() {
        return now;
    }

}
