import java.util.ArrayList;
import java.util.Optional;

public class Flight{
    String id;
    Optional<Integer> capacity;
    //ArrayList<City> cit = new ArrayList<>();
City[] cit = new City[2];
    public Flight(int num, Integer c, City in, City out){
        id = "AC"+num;
        capacity = Optional.of(c);
        cit[0] = in;
        cit[1] = out;
    }

    public Optional<Integer> getCapacity(){
        if(capacity.isPresent()){
            return capacity;
        }
        return Optional.empty();
    }

    public String getId(){
        return id;
    }
}