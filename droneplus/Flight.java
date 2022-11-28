import java.util.ArrayList;
import java.util.List;

public class Flight{
    //allows client to group tricks, query number of unique movement directions
    final private String aFlightName;
    final private List<Trick> aTricks = new ArrayList<Trick>();
    private int numTricks = 0;

    public Flight(String pFlightName){
        aFlightName = pFlightName;
    }

    public String toString(){
        return aFlightName + ": " + getNumTricks() + " tricks, and " + getUniqueMovements() + " unique movements";
    }

    public String getFlightName(){
        return aFlightName;
    }

    public void addTrick(Trick t){
        aTricks.add(t);
        numTricks++;
    }

    public ArrayList<Trick> getTricks(){
        ArrayList<Trick> tempTricks = new ArrayList<>();
        for(Trick t : aTricks){
            tempTricks.add(t); //tricks are immutable
        }
        return tempTricks;
    }

    public int getUniqueDirections(){
        List<Direction> directions = new ArrayList<>();
        for(Trick t : aTricks){
            ArrayList<BasicMove> trickMoves = t.getMovements();
            for(BasicMove m : trickMoves){
                if(directions.contains(m.getDirection())){
                    continue;
                }
                else{
                    directions.add(m.getDirection());
                }
            }
        }
        return directions.size();
    }

    public int getUniqueMovements(){
        List<BasicMove> movements = new ArrayList<>();
        for(Trick t : aTricks){
            ArrayList<BasicMove> trickMoves = t.getMovements();
            for(BasicMove m : trickMoves){
                if(movements.contains(m)){
                    continue;
                }
                else{
                    movements.add(m);
                }
            }
        }
        return movements.size();
    }

    public int getNumTricks(){
        return numTricks;
    }
}
