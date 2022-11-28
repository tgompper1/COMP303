import java.util.ArrayList;
import java.util.List;

public class Drone {

    final private String name;
    final private List<Flight> myFlights = new ArrayList<Flight>();
    private int numFlights = 0;

    /**
     * Constructor
     * @param name of the drone
     */
    public Drone(String name) {
        this.name = name;
    }

    /**
     * Name getter
     * @return drone name
     */
    public String getName() {
        return this.name;
    }

    public int addFlight(Flight f){
        myFlights.add(f);
        numFlights++;
        return numFlights; //returns flights id number
    }

    public void executeFlight(Flight f, int id){
        assert myFlights.contains(f);
        System.out.println("Beginning " + f.getFlightName());
        ArrayList<Trick> flightTricks = myFlights.get(id-1).getTricks();
        for(Trick t : flightTricks){
            t.execute(this);
        }
        System.out.println("Flight ended");
    }
    //create a flight then execute through the drone

    public ArrayList<Flight> getFlights(){
        ArrayList<Flight> temp = new ArrayList<Flight>();
        for(Flight f : myFlights){
            temp.add(f);
        }
        return temp;
    }
}
