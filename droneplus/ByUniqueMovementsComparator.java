import java.util.Comparator;

public class ByUniqueMovementsComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight f1, Flight f2){
        if(f1.getUniqueMovements() - f2.getUniqueMovements() > 0){
            return 1;
        }
        else if( f1.getUniqueMovements() - f2.getUniqueMovements() < 0){
            return -1;
        }
        else{
            return 0;
        }
    }
}
