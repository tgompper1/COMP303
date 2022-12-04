import java.util.ArrayList;

public class AirCanada {
    //ArrayList<String> cities = new ArrayList<>();
    Cities cities = new Cities();
    ArrayList<Flight> flights = new ArrayList<>();
    //flyweight for cities(can only ever be one city of  a given name) and flights(unique)


    public void addFlight(int num, Integer cap, City in, City out){
        String id = "AC"+num;
        for(Flight f : flights){
            if(f.getId().equals(id)){
                return;
            }
        }
        flights.add(new Flight(num, cap,in, out ));
    }

    public Flight getFlights(int i){
        return flights.get(i);
    }

}