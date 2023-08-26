package Model;

public class Player {
    private String name;
    private int goalsPerMatch;


    public Player(String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goals (){
        goalsPerMatch++;
    }

    public int getGoalsPerMatch() {
        return goalsPerMatch;
    }
}