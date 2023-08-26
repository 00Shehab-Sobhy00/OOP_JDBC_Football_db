package Model;

import java.util.ArrayList;

public class Team <T extends Player> {
    private String name;
    private ArrayList<T>  players;
    private int numberOfMatchs;
    private String coachName;


    public Team(String name , String coachName ) {
        this.name = name;
        this.players = new ArrayList<>();
        this.coachName = coachName;
        this.numberOfMatchs= 0;

    }

public void addPlayer(T player){
        if(!players.contains(player) ){
            players.add(player);
        }else
            System.out.println("player already exisit ");
}

  public void printPlayers(){
        for (T p : players){
            System.out.println(p.getName());
        }
    }



    public String getName() {
        return name;
    }

    public int addNumberOfMatchs() {
        return numberOfMatchs++;
    }

    public ArrayList<T> getPlayers() {
        return players;
    }

}
