import java.util.Comparator;

public class ByNumTricksComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight f1, Flight f2){
        if(f1.getNumTricks() - f2.getNumTricks() > 0){
            return 1;
        }
        else if( f1.getNumTricks() - f2.getNumTricks() < 0){
            return -1;
        }
        else{
            return 0;
        }
    }
}
